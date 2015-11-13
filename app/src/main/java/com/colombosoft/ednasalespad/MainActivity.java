package com.colombosoft.ednasalespad;

import android.app.Activity;
import android.app.Dialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.colombosoft.ednasalespad.db_transaction.StoreDealer;
import com.colombosoft.ednasalespad.db_transaction.StoreRoute;
import com.colombosoft.ednasalespad.dialog.CustomProgressDialog;
import com.colombosoft.ednasalespad.helpers.DatabaseHelper;
import com.colombosoft.ednasalespad.helpers.NetworkFunction;
import com.colombosoft.ednasalespad.model.Dealer;
import com.colombosoft.ednasalespad.model.Route;
import com.colombosoft.ednasalespad.url.BaseURL;
import com.colombosoft.ednasalespad.utilities.NetworkUtility;
import com.colombosoft.ednasalespad.utilities.RequestType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(MainActivity.this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        new CreateDB().execute((Void[]) null);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private class CreateDB extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {

            NetworkFunction networkFunction = new NetworkFunction();
            Log.d(TAG,"**************Begin to create DB**********************");
            DatabaseHelper databaseHelper = DatabaseHelper.getInstance(MainActivity.this);

            if(NetworkUtility.isNetworkAvailable(MainActivity.this)){

                try{

                    SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

                    Log.d(TAG,"************** start routes ***************");
                    String routeJSONString =  networkFunction.sendGETRequestToServer(BaseURL.BASE_URL + "Routes", RequestType.GET_REQUEST);
                    Type routeType = new TypeToken<ArrayList<Route>>(){}.getType();
                    List<Route> routesList = new Gson().fromJson(routeJSONString, routeType);
                    sqLiteDatabase = new StoreRoute().storeRouteListInDB(sqLiteDatabase, routesList);
                    Log.d(TAG, "************* end routes ****************");

                    Log.d(TAG,"************** start dealer **************");
                    String dealerJSONString = networkFunction.sendGETRequestToServer(BaseURL.BASE_URL + "Dealers",RequestType.GET_REQUEST);
                    Type dealerType = new TypeToken<ArrayList<Dealer>>(){}.getType();
                    List<Dealer> dealersList = new Gson().fromJson(dealerJSONString, dealerType);
                    sqLiteDatabase = new StoreDealer().storeDealerListInDB(sqLiteDatabase,dealersList);
                    Log.d(TAG, "************* end dealer ****************");


                }catch (IOException e){

                    Log.e(TAG,e.toString());

                }
            }

            return null;
        }
    }
}
