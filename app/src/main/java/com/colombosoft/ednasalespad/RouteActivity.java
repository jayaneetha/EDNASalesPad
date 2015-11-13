package com.colombosoft.ednasalespad;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.colombosoft.ednasalespad.dialog.CustomProgressDialog;
import com.colombosoft.ednasalespad.helpers.DatabaseHelper;
import com.colombosoft.ednasalespad.model.Route;

import java.util.List;

/**
 * Created by DragonSlayer on 11/10/2015.
 */
public class RouteActivity extends Activity {

    private static final String TAG = "RouteActivity";
    final Context context = this;
    ListView routes;
    private List<Route> routeList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_routes);
        Intent entry = getIntent();
        //requestCode = entry.getIntExtra("request_code", 0);
        //startingSequence = entry.getBooleanExtra(RequestCodes.KEY_STARTING_SEQUENCE, false);
        //DatabaseHelper dbHandler = DatabaseHelper.getInstance(RouteActivity.this);
        //pref = SharedPref.getInstance(ViewRoutesActivity.this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.view_routes_toolbar);
        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText("ROUTES");

        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        routes = (ListView) findViewById(R.id.view_routes_listview);

        new GetRoutes().execute();

        // Set the on click event.
        routes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Route selectedRoute = routeList.get(position);

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_confirm);
                dialog.setTitle("Confirm");

                TextView message_text = (TextView) dialog.findViewById(R.id.message_text);
                message_text.setText("Do you really want to select the route " + selectedRoute.getRouteName() + " ?");
                Button btn_yes = (Button) dialog.findViewById(R.id.btn_yes);
                btn_yes.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        //pref.storeSelectedRoute(selectedRoute);
                        dialog.dismiss();
                        startActivity(new Intent(RouteActivity.this, DealerActivity.class));
                        //Toast.makeText(ViewRoutesActivity.this, "Select Dealer Activity", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                });

                Button btn_no = (Button) dialog.findViewById(R.id.btn_no);
                btn_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
//                if (startingSequence) {
//
//
//
//                } else {
//
//                    final Dialog dialog = new Dialog(context);
//                    dialog.setContentView(R.layout.dialog_confirm);
//                    dialog.setTitle("Confirm");
//
//                    TextView message_text = (TextView) dialog.findViewById(R.id.message_text);
//                    message_text.setText("Do you really want to switch to the route " + selectedRoute.getRouteName() + " ?");
//                    Button btn_yes = (Button) dialog.findViewById(R.id.btn_yes);
//                    btn_yes.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            //pref.storeSelectedRoute(selectedRoute);
//                            dialog.dismiss();
//                            startActivity(new Intent(RouteActivity.this, MainActivity.class));
//                            //Toast.makeText(ViewRoutesActivity.this, "Select Dealer Activity", Toast.LENGTH_SHORT).show();
//                            finish();
//                        }
//                    });
//
//                    Button btn_no = (Button) dialog.findViewById(R.id.btn_no);
//                    btn_no.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            dialog.dismiss();
//                        }
//                    });
//
//                    dialog.show();
////                        AlertDialog alert = new AlertDialog.Builder(ViewRoutesActivity.this)
////                                .setMessage("Are you sure you want to switch to " + selectedRoute.getRouteName() + " temporarily?")
////                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
////                                    @Override
////                                    public void onClick(DialogInterface dialog, int which) {
////                                        startActivity(new Intent(ViewRoutesActivity.this, SelectDealerActivity.class).putExtra(RequestCodes.KEY_TEMPORARY_ROUTE, selectedRoute.getRouteId()));
////                                        Toast.makeText(ViewRoutesActivity.this, "Select Dealer Activity", Toast.LENGTH_SHORT).show();
////                                        finish();
////                                    }
////                                })
////                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
////                                    @Override
////                                    public void onClick(DialogInterface dialog, int which) {
////                                        dialog.dismiss();
////                                    }
////                                })
////                                .create();
////                        alert.show();
//                }
            }
        });

    }

    private class GetRoutes extends AsyncTask<Void, Void, List<Route>> {

        private CustomProgressDialog pDialog;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Toast.makeText(ViewRoutesActivity.this, "Getting Data Please wait", Toast.LENGTH_SHORT).show();
            pDialog = new CustomProgressDialog(RouteActivity.this);
            pDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            pDialog.setMessage("Loading Routes...");
            pDialog.show();
        }

        @Override
        protected List doInBackground(Void... params) {

            DatabaseHelper databaseHandler = DatabaseHelper.getInstance(RouteActivity.this);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    pDialog.setMessage("Loading Routes...");
                }
            });

            //List<Route> list = databaseHandler.getRoutes();

            //CSS start added by rasika gayan

            List<Route> routesList = databaseHandler.getAllRoutes();

            //CSS end

//            Collections.sort(list, new Comparator<Route>() {
//                @Override
//                public int compare(Route lhs, Route rhs) {
//                    return lhs.getRouteName().compareToIgnoreCase(rhs.getRouteName());
//                }
//            });

            //return list;
            return routesList;
        }

        @Override
        protected void onPostExecute(List<Route> list) {
            super.onPostExecute(list);

            String[] Stringlist = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Stringlist[i] = list.get(i).getRouteName();
            }

            // Define the array adapter to feed the route names to the listview
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(RouteActivity.this, android.R.layout.simple_list_item_1, Stringlist);
            routes.setAdapter(adapter);

            routeList = list;

            if (pDialog.isShowing()) {
                pDialog.dismiss();
            }

        }
    }
}
