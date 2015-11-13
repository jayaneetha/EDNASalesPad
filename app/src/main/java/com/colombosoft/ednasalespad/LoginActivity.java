package com.colombosoft.ednasalespad;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.colombosoft.ednasalespad.db_transaction.StoreDealer;
import com.colombosoft.ednasalespad.db_transaction.StoreRoute;
import com.colombosoft.ednasalespad.db_transaction.StoreUser;
import com.colombosoft.ednasalespad.dialog.CustomProgressDialog;
import com.colombosoft.ednasalespad.helper_model.UserLoginSuccess;
import com.colombosoft.ednasalespad.helpers.DatabaseHelper;
import com.colombosoft.ednasalespad.helpers.NetworkFunction;
import com.colombosoft.ednasalespad.model.Dealer;
import com.colombosoft.ednasalespad.model.Route;
import com.colombosoft.ednasalespad.model.User;
import com.colombosoft.ednasalespad.url.BaseURL;
import com.colombosoft.ednasalespad.utilities.NetworkUtility;
import com.colombosoft.ednasalespad.utilities.RequestType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by DragonSlayer on 11/7/2015.
 */
public class LoginActivity extends Activity {

    private static final String TAG = "LoginActivity";
    private EditText mEmailText;
    private EditText mPasswordText;
    private Button mSignInButton;
    private TextView mErrorMessage;
    private boolean mHideErrorMessage;
    private Runnable hideRunnable;
    //private DatabaseHelper databaseHelper;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //databaseHelper = DatabaseHelper.getInstance(LoginActivity.this);

        mEmailText = (EditText) findViewById(R.id.text_email_address);
        mPasswordText = (EditText)findViewById(R.id.text_password);

        mSignInButton = (Button) findViewById(R.id.btn_sign_in);
        mSignInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(mEmailText.getText().toString().equals("")){

                    showErrorText("Please enter a Email");
                    mEmailText.requestFocus();

                } else if(mPasswordText.getText().toString().equals("")){

                    showErrorText("Please enter a password");
                    mPasswordText.requestFocus();

                } else {
                    if(NetworkUtility.isNetworkAvailable(LoginActivity.this)){

                        new AuthenticateProcess().execute(mEmailText.getText().toString(),mPasswordText.getText().toString());

                    }else {
                        showErrorText("PLEASE ENABLE INTERNET ");
                    }
                }

            }
        });

    }

    private void showErrorText(String errorMessage){

        mErrorMessage.setTranslationY(500);
        mErrorMessage.setText(errorMessage);
        mErrorMessage.setVisibility(View.VISIBLE);
        ViewCompat.animate(mErrorMessage).translationY(0).setDuration(4000);
        mHideErrorMessage = true;
        handler.postDelayed(hideRunnable, 4000);

    }

    private class AuthenticateProcess extends AsyncTask<String , Void , Boolean>{

        private CustomProgressDialog mWaitingMessage;
        private List<String> mErrorList = new ArrayList<String>();

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            mWaitingMessage = new CustomProgressDialog(LoginActivity.this);
            mWaitingMessage.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mWaitingMessage.setMessage("Authenticating...");
            mWaitingMessage.show();

        }

        @Override
        protected Boolean doInBackground(String... params) {

            if(NetworkUtility.isNetworkAvailable(LoginActivity.this)){

                try{

                    String urlParams = "grant_type="+
                                        URLEncoder.encode("password","UTF-8")+
                                        "&username="+
                                        URLEncoder.encode(params[0],"UTF-8")+
                                        "&password="+
                                        URLEncoder.encode(params[1],"UTF-8");

                    NetworkFunction networkFunction = new NetworkFunction();

                    String loginJSONResult = networkFunction.userAuthentication(BaseURL.AUTHENICATION_URL ,
                                                                                RequestType.POST_REQUEST,
                                                                                urlParams);

                    JSONObject loginJSONObject = new JSONObject(loginJSONResult);

                    if(loginJSONObject.has("access_token")){

                        Gson gson = new Gson();

                        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(LoginActivity.this);
                        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

                        // insert user data to db
                        UserLoginSuccess user = gson.fromJson(loginJSONResult, UserLoginSuccess.class);
                        new StoreUser().storeUserInDB(sqLiteDatabase,user);

                        String routeJSONString =  networkFunction.sendGETRequestToServer(BaseURL.BASE_URL + "Routes", RequestType.GET_REQUEST);
                        Type routeType = new TypeToken<ArrayList<Route>>(){}.getType();
                        List<Route> routesList = new Gson().fromJson(routeJSONString, routeType);
                        new StoreRoute().storeRouteListInDB(sqLiteDatabase, routesList);
                        Log.d(TAG, "************* end routes ****************");

                        Log.d(TAG,"************** start dealer **************");
                        String dealerJSONString = networkFunction.sendGETRequestToServer(BaseURL.BASE_URL + "Dealers", RequestType.GET_REQUEST);
                        Type dealerType = new TypeToken<ArrayList<Dealer>>(){}.getType();
                        List<Dealer> dealersList = new Gson().fromJson(dealerJSONString, dealerType);
                        new StoreDealer().storeDealerListInDB(sqLiteDatabase, dealersList);
                        Log.d(TAG, "************* end dealer ****************");

                        return true;

                    }else {
                        Log.d(TAG,loginJSONResult);
                        return false;
                    }
                }catch (IOException e){

                    Log.e(TAG, e.toString());
                    return false;

                } catch (JSONException e) {
                    e.printStackTrace();
                    return false;
                }
            }else {

                return false;

            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if(aBoolean){
                //super.onPostExecute(aBoolean);
                Intent intent = new Intent(LoginActivity.this, AgentAttendanceActivity.class);
                //intent.putExtra(RequestCodes.KEY_STARTING_SEQUENCE, true);
                startActivity(intent);

            }else {
                if (mWaitingMessage.isShowing()) {

                    mWaitingMessage.dismiss();

                }

                //Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                //intent.putExtra(RequestCodes.KEY_STARTING_SEQUENCE, true);
                //startActivity(intent);
            }


        }

    }


}
