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
import com.colombosoft.ednasalespad.model.Dealer;

import java.util.List;

/**
 * Created by DragonSlayer on 11/11/2015.
 */
public class DealerActivity extends Activity {

    private static final String TAG = "DealerActivity";
    final Context context = this;
    ListView routes;
    private List<Dealer> routeList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_routes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.view_routes_toolbar);
        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        title.setText("ROUTES");


        routes = (ListView) findViewById(R.id.view_routes_listview);

        new GetRoutes().execute();

        // Set the on click event.
        routes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Dealer selectedDealer = routeList.get(position);

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_confirm);
                dialog.setTitle("Confirm");

                TextView message_text = (TextView) dialog.findViewById(R.id.message_text);
                message_text.setText("Do you really want to select the route " + selectedDealer.getContactPerson() + " ?");
                Button btn_yes = (Button) dialog.findViewById(R.id.btn_yes);
                btn_yes.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        //pref.storeSelectedRoute(selectedRoute);
                        dialog.dismiss();
                        startActivity(new Intent(DealerActivity.this, MainActivity.class));
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

            }
        });

    }

    private class GetRoutes extends AsyncTask<Void, Void, List<Dealer>> {

        private CustomProgressDialog pDialog;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new CustomProgressDialog(DealerActivity.this);
            pDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            pDialog.setMessage("Loading Routes...");
            pDialog.show();
        }

        @Override
        protected List doInBackground(Void... params) {

            DatabaseHelper databaseHandler = DatabaseHelper.getInstance(DealerActivity.this);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    pDialog.setMessage("Loading Routes...");
                }
            });
            List<Dealer> dealer1List = databaseHandler.getAllDealers();
            return dealer1List;
        }

        @Override
        protected void onPostExecute(List<Dealer> list) {
            super.onPostExecute(list);

            String[] Stringlist = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Stringlist[i] = list.get(i).getContactPerson();
            }

            // Define the array adapter to feed the route names to the listview
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(DealerActivity.this, android.R.layout.simple_list_item_1, Stringlist);
            routes.setAdapter(adapter);

            routeList = list;

            if (pDialog.isShowing()) {
                pDialog.dismiss();
            }

        }
    }

}
