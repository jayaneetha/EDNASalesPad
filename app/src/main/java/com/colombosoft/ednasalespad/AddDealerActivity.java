package com.colombosoft.ednasalespad;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.colombosoft.ednasalespad.adapter.DealerClassAdapter;
import com.colombosoft.ednasalespad.db_transaction.StoreDealer;
import com.colombosoft.ednasalespad.helpers.DatabaseHelper;
import com.colombosoft.ednasalespad.model.Dealer;
import com.colombosoft.ednasalespad.model.DealerClass;
import com.colombosoft.ednasalespad.model.DealerImage;
import com.colombosoft.ednasalespad.model.GeoCordinates;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddDealerActivity extends AppCompatActivity {


    final int REQUEST_IMAGE_CAPTURE_FRONT = 1;
    final int REQUEST_IMAGE_CAPTURE_SHOWCASE = 2;
    final int REQUEST_IMAGE_CAPTURE_PROMOTION_1 = 3;
    final int REQUEST_IMAGE_CAPTURE_PROMOTION_2 = 4;
    final String DEALER_DIR = new StringBuilder().append(Environment.getExternalStorageDirectory()).append("/EDNA/Dealers/").toString();
    Dealer dealer;
    EditText dealerName, address, district, dsDivision, gnDivision, openBalance, contactPerson, fixedLine, mobile;
    TextView location_tv;
    Button add_btn;
    Spinner dealerClass;
    ImageView shopFront, showcase, promotion_1, promotion_2;
    RelativeLayout shopFrontNA, showcaseNA, promotion_1NA, promotion_2NA;

    List<DealerClass> dealerClassList;
    Location finalLocation;
    LocationManager locationManager;
    int routeId;
    Boolean gpsActive, networkActive;
    AddDealerLocationListener locationListener;
    String captured_image_name = null;
    DealerImage dealerImage;

    private DatabaseHelper databaseHelper;
    //    private SharedPref pref;
    private String LOG_TAG = AddDealerActivity.class.getSimpleName();
    private Runnable switchRunnable;
    private boolean locSwitch;
    private Handler locationHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dealer);

        databaseHelper = DatabaseHelper.getInstance(AddDealerActivity.this);

        //TODO: Remove in production
        dealerClassList = new ArrayList<DealerClass>();
        dealerClassList.add(new DealerClass(1, "One"));
        dealerClassList.add(new DealerClass(2, "Two"));
        dealerClassList.add(new DealerClass(3, "Three"));
        dealerClassList.add(new DealerClass(4, "Four"));

        dealerName = (EditText) findViewById(R.id.add_dealer_et_name);
        address = (EditText) findViewById(R.id.add_dealer_et_address);
        district = (EditText) findViewById(R.id.add_dealer_et_district);
        dsDivision = (EditText) findViewById(R.id.add_dealer_et_dsdivision);
        gnDivision = (EditText) findViewById(R.id.add_dealer_et_gndivision);
        openBalance = (EditText) findViewById(R.id.add_dealer_et_open_balance);
        contactPerson = (EditText) findViewById(R.id.add_dealer_et_contact_person);
        fixedLine = (EditText) findViewById(R.id.add_dealer_et_contact_fixed);
        mobile = (EditText) findViewById(R.id.add_dealer_et_contact_mob);

        add_btn = (Button) findViewById(R.id.add_dealer_btn_add);

        location_tv = (TextView) findViewById(R.id.add_dealer_tv_location);

        shopFront = (ImageView) findViewById(R.id.add_dealer_iv_front_image_view);
        showcase = (ImageView) findViewById(R.id.add_dealer_iv_show_image_view);
        promotion_1 = (ImageView) findViewById(R.id.add_dealer_iv_promotion_1_view);
        promotion_2 = (ImageView) findViewById(R.id.add_dealer_iv_promotion_2_view);

        shopFrontNA = (RelativeLayout) findViewById(R.id.add_dealer_rel_front_image_view_na);
        showcaseNA = (RelativeLayout) findViewById(R.id.add_dealer_rel_show_image_view_na);
        promotion_1NA = (RelativeLayout) findViewById(R.id.add_dealer_rel_promotion_1_na);
        promotion_2NA = (RelativeLayout) findViewById(R.id.add_dealer_rel_promotion_2_na);

        locationManager = (LocationManager) AddDealerActivity.this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new AddDealerLocationListener();
        locationHandler = new Handler();

        dealer = new Dealer();

//        routeId = pref.getSelectedRoute().getRouteId();
        //TODO: remove the following lines
        routeId = 1;
        String dealerId = "1";
        dealer.setDealerId(dealerId);

        try {
            gpsActive = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {
            gpsActive = false;
        }
        try {
            networkActive = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception e) {
            networkActive = false;
        }

        requestUpdates(); //request GPS Coordinates

        dealerClass = (Spinner) findViewById(R.id.add_dealer_sp_class);
        dealerClass.setAdapter(new DealerClassAdapter(this, dealerClassList));

        //Click Listeners
        shopFrontNA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imageName = "Dealer_" + String.valueOf(dealer.getDealerId()) + "_front.jpg";
                dispatchTakePictureIntent(REQUEST_IMAGE_CAPTURE_FRONT, imageName);
            }
        });

        showcaseNA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imageName = "Dealer_" + String.valueOf(dealer.getDealerId()) + "_showcase.jpg";
                dispatchTakePictureIntent(REQUEST_IMAGE_CAPTURE_SHOWCASE, imageName);
            }
        });

        promotion_1NA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imageName = "Dealer_" + String.valueOf(dealer.getDealerId()) + "_promotion_1.jpg";
                dispatchTakePictureIntent(REQUEST_IMAGE_CAPTURE_PROMOTION_1, imageName);
            }
        });

        promotion_2NA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imageName = "Dealer_" + String.valueOf(dealer.getDealerId()) + "_promotion_2.jpg";
                dispatchTakePictureIntent(REQUEST_IMAGE_CAPTURE_PROMOTION_2, imageName);
            }
        });
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
                            } catch (SecurityException e) {
                                Toast.makeText(AddDealerActivity.this, "Enable the Location services", Toast.LENGTH_SHORT).show();
                            }
                            requestNetworkLocation();
                            locSwitch = true;
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
                Toast.makeText(AddDealerActivity.this, "Please enable location service and try again", Toast.LENGTH_SHORT).show();
            }
        }

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(finalLocation!=null) {
                    dealer.setName(dealerName.getText().toString());
                    dealer.setAddress(address.getText().toString());
                    dealer.setDistrict(district.getText().toString());
                    dealer.setDSDivision(dsDivision.getText().toString());
                    dealer.setGNDivision(gnDivision.getText().toString());
                    dealer.setContactPerson(contactPerson.getText().toString());
                    dealer.setLandNumber(fixedLine.getText().toString());
                    dealer.setMobileNumber(mobile.getText().toString());
                    GeoCordinates geoCordinates = new GeoCordinates(finalLocation.getLongitude(), finalLocation.getLatitude());
                    dealer.setGeoCordinates(geoCordinates);

                    DatabaseHelper databaseHelper = DatabaseHelper.getInstance(AddDealerActivity.this);
                    SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
                    List<Dealer> tempDealerList = new ArrayList<Dealer>();
                    tempDealerList.add(dealer);
                    (new StoreDealer()).storeDealerListInDB(sqLiteDatabase, tempDealerList);
                    Toast.makeText(AddDealerActivity.this, "Dealer Stored", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(AddDealerActivity.this, "Please wait. Application is fetching the Location", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void requestGPSLocation() {
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        } catch (SecurityException e) {
            Toast.makeText(AddDealerActivity.this, "Enable the Location services", Toast.LENGTH_SHORT).show();
        }
        location_tv.setText("Getting location (GPS)");
    }

    private void requestNetworkLocation() {
        try {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        } catch (SecurityException e) {
            Toast.makeText(AddDealerActivity.this, "Enable the Location services", Toast.LENGTH_SHORT).show();
        }
        location_tv.setText("Getting location (Network)");
    }

    @Override
    public void onBackPressed() {
        if (switchRunnable != null && !locSwitch) {
            locationHandler.removeCallbacks(switchRunnable);
        }
        super.onBackPressed();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Bitmap bitmap = null;
            Uri imageUri = Uri.fromFile(new File(DEALER_DIR, captured_image_name));
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (requestCode) {
                case REQUEST_IMAGE_CAPTURE_FRONT:
                    //Front
                    dealerImage = new DealerImage(String.valueOf(Math.random()), imageUri.toString(), dealer.getDealerId());
                    dealer.addDealerImage(dealerImage);
                    shopFront.setImageBitmap(bitmap);
                    shopFront.setVisibility(View.VISIBLE);
                    shopFrontNA.setVisibility(View.GONE);
                    break;
                case REQUEST_IMAGE_CAPTURE_SHOWCASE:
                    //Showcase
                    //outlet.setShowcaseImageUri(imageUri.toString());
                    dealerImage = new DealerImage(String.valueOf(Math.random()), imageUri.toString(), dealer.getDealerId());
                    dealer.addDealerImage(dealerImage);
                    showcase.setImageBitmap(bitmap);
                    showcase.setVisibility(View.VISIBLE);
                    showcaseNA.setVisibility(View.GONE);
                    break;
                case REQUEST_IMAGE_CAPTURE_PROMOTION_1:
                    //Promotion 1
                    //outlet.setPromotion1ImageUri(imageUri.toString());
                    dealerImage = new DealerImage(String.valueOf(Math.random()), imageUri.toString(), dealer.getDealerId());
                    dealer.addDealerImage(dealerImage);
                    promotion_1.setImageBitmap(bitmap);
                    promotion_1.setVisibility(View.VISIBLE);
                    promotion_1NA.setVisibility(View.GONE);
                    break;
                case REQUEST_IMAGE_CAPTURE_PROMOTION_2:
                    //Promotion 2
                    //outlet.setPromotion2ImageUri(imageUri.toString());
                    dealerImage = new DealerImage(String.valueOf(Math.random()), imageUri.toString(), dealer.getDealerId());
                    dealer.addDealerImage(dealerImage);
                    promotion_2.setImageBitmap(bitmap);
                    promotion_2.setVisibility(View.VISIBLE);
                    promotion_2NA.setVisibility(View.GONE);
                    break;
                default:
                    Log.e(LOG_TAG, "Invalid Request");
            }
            //dbHandler.updateOutlet(outlet);
            //outlet = dbHandler.getOutletOfId(pref.getSelectedOutletId());
        }
    }

    private void dispatchTakePictureIntent(int requestCode, String imageName) {
        captured_image_name = null;
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(this.getPackageManager()) != null) {
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(DEALER_DIR, imageName)));
            //stores the image name captured.
            captured_image_name = imageName;
            startActivityForResult(takePictureIntent, requestCode);
        }
    }


    private class AddDealerLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            finalLocation = location;
            try {
                locationManager.removeUpdates(this);
            } catch (SecurityException e) {
                Toast.makeText(AddDealerActivity.this, "Enable the Location services", Toast.LENGTH_SHORT).show();
            }
            location_tv.setText("Location: " + location.getLatitude() + ", " + location.getLongitude());
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {
            if (finalLocation == null) {
                Toast.makeText(AddDealerActivity.this, "Provider enabled. Accessing location", Toast.LENGTH_SHORT).show();
                requestUpdates();
            }
        }

        @Override
        public void onProviderDisabled(String provider) {
            Toast.makeText(AddDealerActivity.this, "Provider disabled", Toast.LENGTH_SHORT).show();
        }
    }

}
