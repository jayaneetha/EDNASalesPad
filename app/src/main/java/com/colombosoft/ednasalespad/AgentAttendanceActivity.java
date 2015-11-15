package com.colombosoft.ednasalespad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.colombosoft.ednasalespad.db_tables.AttendanceTable;
import com.colombosoft.ednasalespad.helpers.DatabaseHelper;
import com.colombosoft.ednasalespad.helpers.NetworkFunction;
import com.colombosoft.ednasalespad.libs.ProgressWheel;
import com.colombosoft.ednasalespad.model.Attendance;
import com.colombosoft.ednasalespad.utilities.NetworkUtility;
import com.colombosoft.ednasalespad.utilities.RequestType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by DragonSlayer on 11/9/2015.
 */
public class AgentAttendanceActivity extends Activity {

    private final static String TAG = "AgentAttendanceActivity";
    private static Resources resource;
    private Location finalLocation;
    private LocationManager locationManager;
    private ProgressWheel progressWheel;
    private TextView tvProgress;
    private DatabaseHelper dbHandler;
    private boolean openSequence = false;
    private boolean isDayStarted = false;
    private TextView tvTime, tvDate;
    private TextView tvLocationAddressBegin, tvLocationCoordinatesBegin, tvCapturedTimeBegin;
    private Button tvBeginHeader, tvEndHeader;
    private Button rndConfirmBegin;
    private TextView tvLocationAddressEnd, tvLocationCoordinatesEnd, tvCapturedTimeEnd;
    private Button rndConfirmEnd;
    private Runnable countRunnable;
    private SimpleDateFormat dateFormat;
    private String formattedDate;
    private long capturedTime;
    private boolean gpsActive, networkActive;
    private AttendanceLocationListener locationListener;
    private Handler locationHandler;
    private Runnable switchRunnable;
    private boolean locSwitch;
    private NetworkFunction networkFunctions;
    private boolean dayStarted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_attendance);

        dbHandler = DatabaseHelper.getInstance(AgentAttendanceActivity.this);

        networkFunctions = new NetworkFunction();

        tvDate = (TextView) findViewById(R.id.mark_attendance_tv_date);
        tvTime = (TextView) findViewById(R.id.mark_attendance_tv_clock);

        tvBeginHeader = (Button) findViewById(R.id.mark_attendance_tv_begin_header);
        tvEndHeader = (Button) findViewById(R.id.mark_attendance_tv_end_header);

        tvCapturedTimeBegin = (TextView) findViewById(R.id.mark_attendance_tv_begin_time);
        tvLocationAddressBegin = (TextView) findViewById(R.id.mark_attendance_tv_begin_location);
        tvLocationCoordinatesBegin = (TextView) findViewById(R.id.mark_attendance_tv_begin_location_coordinates);
        rndConfirmBegin = (Button) findViewById(R.id.mark_attendance_crclbtn_start_function);

        tvCapturedTimeEnd = (TextView) findViewById(R.id.mark_attendance_tv_end_time);
        tvLocationAddressEnd = (TextView) findViewById(R.id.mark_attendance_tv_end_location);
        tvLocationCoordinatesEnd = (TextView) findViewById(R.id.mark_attendance_tv_end_location_coordinates);
        rndConfirmEnd = (Button) findViewById(R.id.mark_attendance_crclbtn_end_function);

        rndConfirmBegin.setScaleX(0);
        rndConfirmBegin.setScaleY(0);

        rndConfirmEnd.setScaleX(0);
        rndConfirmEnd.setScaleY(0);

        rndConfirmBegin.setEnabled(false);
        rndConfirmEnd.setEnabled(false);

        rndConfirmBegin.setVisibility(View.VISIBLE);
        rndConfirmEnd.setVisibility(View.VISIBLE);

        dateFormat = new SimpleDateFormat("hh:mm:ss aaa", Locale.getDefault());

        tvEndHeader.setEnabled(false);

        //TODO: Remove on production
        Button testButton = (Button) findViewById(R.id.test_button);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AgentAttendanceActivity.this, AddDealerActivity.class));
            }
        });

//        if (attendance != null && isDayStarted) {
//            tvEndHeader.setEnabled(true);
//            tvBeginHeader.setEnabled(false);
//            tvCapturedTimeBegin.setText(dateFormat.format(attendance.getLogTime()));
//            tvLocationAddressBegin.setText(attendance.getLoc());
//            tvLocationCoordinatesBegin.setText(String.valueOf(attendance.getLatitude()) + ", " + String.valueOf(attendance.getLongitude()));
//
//        } else {
//            tvCapturedTimeBegin.setText("");
//            tvLocationAddressBegin.setText("");
//            tvLocationCoordinatesBegin.setText("");
//        }

        tvCapturedTimeBegin.setText("");
        tvLocationAddressBegin.setText("");
        tvLocationCoordinatesBegin.setText("");

        resource = getResources();

        tvBeginHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestUpdates();

            }
        });

        tvEndHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestUpdates();
            }
        });

        tvDate.setText(new SimpleDateFormat("yyyy MMM dd", Locale.getDefault()).format(new Date(System.currentTimeMillis())));

        Thread timeThread;
        countRunnable = new Runnable() {
            @Override
            public void run() {
                formattedDate = dateFormat.format(new Date(System.currentTimeMillis()));
                tvTime.setText(formattedDate);
            }
        };

        Runnable finalRunnable = new TimeRunner();
        timeThread = new Thread(finalRunnable);
        timeThread.start();

//        isDayStarted = sharedPref.isDayStarted();

        //openSequence = getIntent().getBooleanExtra(RequestCodes.KEY_STARTING_SEQUENCE, false);
//        btnAdd = (CircleButton)findViewById(R.id.mark_attendance_crclbtn_function);
//        btnAdd.setScaleX(0);
//        btnAdd.setScaleY(0);
//        ViewPropertyAnimator.animate(btnAdd).scaleX(0).scaleY(0).setDuration(10).start();
//        btnAdd.setVisibility(View.VISIBLE);

//        tvFunction = (TextView)findViewById(R.id.mark_attendance_tv_function);

        progressWheel = (ProgressWheel) findViewById(R.id.mark_attendance_progress_location);

        tvProgress = (TextView) findViewById(R.id.mark_attendance_tv_progress);

        locationManager = (LocationManager) AgentAttendanceActivity.this.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new AttendanceLocationListener();

        try {
            gpsActive = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
            gpsActive = false;
        }

//        boolean networkActive;
        try {
            networkActive = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
            networkActive = false;
        }

        rndConfirmBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                int sessionId = sharedPref.startDay();
//                Attendance attendance = new Attendance(capturedTime, Attendance.ATTENDANCE_STATUS_START);
//                attendance.setLatitude(finalLocation.getLatitude());
//                attendance.setLongitude(finalLocation.getLongitude());
//                attendance.setLoc(tvLocationAddressBegin.getText().toString());
//                attendance.setLocalSession(sessionId);
//                dbHandler.storeAttendance(attendance);
                DatabaseHelper databaseHelper = DatabaseHelper.getInstance(AgentAttendanceActivity.this);

                Attendance attendance = new Attendance();

                com.colombosoft.ednasalespad.model.Location location = new com.colombosoft.ednasalespad.model.Location();
                location.setLong(finalLocation.getLongitude());
                location.setLat(finalLocation.getLatitude());

                Log.d(TAG, new Date().toString());
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.Sz");
                Log.d(TAG, new Date().toString());

                attendance.setLocation(location);
                attendance.setDateAndTime(df.format(new Date()));
                attendance.setType(1);

                AttendanceTable attendanceTable = new AttendanceTable();
                attendanceTable.insertAttendance(databaseHelper.getWritableDatabase(), attendance);
                Intent intent = new Intent(AgentAttendanceActivity.this, RouteActivity.class);
                startActivity(intent);

//                if (openSequence) {
//                    Log.i(LOG_TAG, "View Routes");
//
//                    Intent intent = new Intent(MarkAttendanceActivity.this, ViewRoutesActivity.class);
//                    intent.putExtra(RequestCodes.KEY_STARTING_SEQUENCE, true);
//                    startActivity(intent);
//                    finish();
//                } else {
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            finish();
//                        }
//                    }, 150);
//                }

            }
        });

        rndConfirmEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                int sessionId = sharedPref.getLocalSessionId();
//                Attendance attendance = new Attendance(capturedTime, Attendance.ATTENDANCE_STATUS_END);
//                attendance.setLatitude(finalLocation.getLatitude());
//                attendance.setLongitude(finalLocation.getLongitude());
//                attendance.setLocalSession(sessionId);
//                dbHandler.storeAttendance(attendance);
//                sharedPref.endDay();
//
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        new NotifyServer().execute("end");
//                    }
//                };
                System.exit(0);
                finish();
            }
        });

        locationHandler = new Handler();
    }

    private void requestUpdates() {

        try {
            gpsActive = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
            gpsActive = false;
        }

        try {
            networkActive = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
            networkActive = false;
        }

        if (networkActive) {

            if (gpsActive) {
                // Request timed location update using GPS
                requestGPSLocation();

                if (switchRunnable == null) {

                    switchRunnable = new Runnable() {
                        @Override
                        public void run() {
                            try {
                                locationManager.removeUpdates(locationListener);
                                requestNetworkLocation();
                                locSwitch = true;
                            } catch (SecurityException ex) {
                                Log.d(TAG, "Error ocured : \n");
                                Log.d(TAG, ex.toString());
                            }
                        }
                    };

                }

                // Stop getting the location from GPS  and get from network if taking too long
                locationHandler.postDelayed(switchRunnable, 10 * 1000);
            } else {
                // Request location update using network
                requestNetworkLocation();
            }
        } else {
            if (gpsActive) {
                // Only GPS active. Request location from GPS provider
                requestGPSLocation();
            } else {
                tvProgress.setVisibility(View.INVISIBLE);
                progressWheel.stopSpinning();
                Toast.makeText(AgentAttendanceActivity.this, "Please enable location service and try again", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void showButton() {
        if (isDayStarted) {
            rndConfirmEnd.setEnabled(true);
            //ViewPropertyAnimator.animate(rndConfirmEnd).cancel();
            //ViewPropertyAnimator.animate(rndConfirmEnd).scaleX(1).scaleY(1).setDuration(200).setStartDelay(50).start();
        } else {
            rndConfirmBegin.setEnabled(true);
            //ViewPropertyAnimator.animate(rndConfirmBegin).cancel();
            //ViewPropertyAnimator.animate(rndConfirmBegin).scaleX(1).scaleY(1).setDuration(200).setStartDelay(50).start();
        }
    }

    private void requestGPSLocation() throws SecurityException {

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        tvProgress.setVisibility(View.VISIBLE);
        tvProgress.setText("Getting location (GPS)");
//        progressWheel.setVisibility(View.VISIBLE);
        progressWheel.spin();
    }

    private void requestNetworkLocation() throws SecurityException {

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        tvProgress.setVisibility(View.VISIBLE);
        tvProgress.setText("Getting location (Network)");
        progressWheel.spin();

    }

    private class AttendanceLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {

            if (location != null) {

                finalLocation = location;
                Log.i(TAG, "Lat : " + String.valueOf(location.getLatitude()) + "\nLon : " + String.valueOf(location.getLongitude()));
                try {

                    locationManager.removeUpdates(this);

                } catch (SecurityException ex) {

                }


//                showButton();
                capturedTime = System.currentTimeMillis();

                if (NetworkUtility.isNetworkAvailable(AgentAttendanceActivity.this)) {
                    if (isDayStarted) {
                        tvCapturedTimeEnd.setText(dateFormat.format(new Date(capturedTime)));
                        tvLocationAddressEnd.setText("Please wait...");
                        tvLocationCoordinatesEnd.setText(String.valueOf(finalLocation.getLatitude()) + ", " + String.valueOf(finalLocation.getLongitude()));
                    } else {
                        tvCapturedTimeBegin.setText(dateFormat.format(new Date(capturedTime)));
                        tvLocationAddressBegin.setText("Please wait...");
                        tvLocationCoordinatesBegin.setText(String.valueOf(finalLocation.getLatitude()) + ", " + String.valueOf(finalLocation.getLongitude()));
                    }
                    new GetAddress().execute();
                } else {
                    tvProgress.setVisibility(View.INVISIBLE);
                    progressWheel.stopSpinning();

                    if (isDayStarted) {
                        tvCapturedTimeEnd.setText(dateFormat.format(new Date(capturedTime)));
                        tvLocationAddressEnd.setText("Cannot process location");
                        tvLocationCoordinatesEnd.setText(String.valueOf(finalLocation.getLatitude()) + ", " + String.valueOf(finalLocation.getLongitude()));
                    } else {
                        tvCapturedTimeBegin.setText(dateFormat.format(new Date(capturedTime)));
                        tvLocationAddressBegin.setText("Cannot process location");
                        tvLocationCoordinatesBegin.setText(String.valueOf(finalLocation.getLatitude()) + ", " + String.valueOf(finalLocation.getLongitude()));
                    }

                    showButton();
                }
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {
            if (finalLocation == null) {
                Toast.makeText(AgentAttendanceActivity.this, "Provider enabled. Accessing location", Toast.LENGTH_SHORT).show();
                tvProgress.setVisibility(View.VISIBLE);
//                progressWheel.setVisibility(View.VISIBLE);
                progressWheel.spin();
                requestUpdates();
            }
        }

        @Override
        public void onProviderDisabled(String provider) {
            Toast.makeText(AgentAttendanceActivity.this, "Provider disabled", Toast.LENGTH_SHORT).show();
            tvProgress.setVisibility(View.INVISIBLE);
            progressWheel.stopSpinning();
        }

    }

    private class GetAddress extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvProgress.setText("Processing location");
        }

        @Override
        protected String doInBackground(Void... params) {

            try {

                //String response = networkFunction.getAddressOfLocation(finalLocation);

                String response = networkFunctions.sendGETRequestToServer("http://maps.googleapis.com/maps/api/geocode/json?latlng="
                        + String.valueOf(finalLocation.getLatitude())
                        + ","
                        + String.valueOf(finalLocation.getLongitude())
                        + "&sensor=true", RequestType.GET_REQUEST);


                if (response != null && response.length() > 0) {
                    JSONObject responseJSON = new JSONObject(response);

                    boolean status = responseJSON.getString("status").equalsIgnoreCase("OK");

                    if (status) {
                        JSONArray addressesArray = responseJSON.getJSONArray("results");
                        if (addressesArray.length() > 0) {
                            String finalAddress = addressesArray.getJSONObject(0).getString("formatted_address");
                            Log.i(TAG, "Final Address: " + finalAddress);
                            if (finalAddress != null) {
                                return finalAddress;
                            }
                        }
                    }
                }

                return null;

            } catch (IOException e) {
                Log.d(TAG, "IOException caught");
                e.printStackTrace();
                return null;
            } catch (JSONException e) {
                Log.d(TAG, "JSONException caught");
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//            tvAddress.setText(s);

            if (isDayStarted) {
                if (s != null) {
                    tvLocationAddressEnd.setText(s);
                } else {
                    tvLocationAddressEnd.setText("Cannot process location");
                }
                tvLocationCoordinatesEnd.setText(String.valueOf(finalLocation.getLatitude()) + ", " + String.valueOf(finalLocation.getLongitude()));
            } else {
                if (s != null) {
                    tvLocationAddressBegin.setText(s);
                } else {
                    tvLocationAddressBegin.setText("Cannot process location");
                }

                tvLocationCoordinatesBegin.setText(String.valueOf(finalLocation.getLatitude()) + ", " + String.valueOf(finalLocation.getLongitude()));
            }

            tvProgress.setVisibility(View.INVISIBLE);
            progressWheel.stopSpinning();

            showButton();
        }

    }

    private class TimeRunner implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    runOnUiThread(countRunnable);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
