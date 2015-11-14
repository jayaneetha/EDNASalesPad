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
import com.colombosoft.ednasalespad.db_transaction.StoreDealerClass;
import com.colombosoft.ednasalespad.db_transaction.StoreProduct;
import com.colombosoft.ednasalespad.db_transaction.StoreProductBatch;
import com.colombosoft.ednasalespad.db_transaction.StoreProductBrand;
import com.colombosoft.ednasalespad.db_transaction.StoreProductCategory;
import com.colombosoft.ednasalespad.db_transaction.StoreProductLevel;
import com.colombosoft.ednasalespad.db_transaction.StoreProductUnit;
import com.colombosoft.ednasalespad.db_transaction.StoreRoute;
import com.colombosoft.ednasalespad.db_transaction.StoreUser;
import com.colombosoft.ednasalespad.db_transaction.StoreAttendance;
import com.colombosoft.ednasalespad.dialog.CustomProgressDialog;
import com.colombosoft.ednasalespad.helper_model.UserLoginSuccess;
import com.colombosoft.ednasalespad.helpers.DatabaseHelper;
import com.colombosoft.ednasalespad.helpers.NetworkFunction;
import com.colombosoft.ednasalespad.model.Attendance;
import com.colombosoft.ednasalespad.model.Dealer;
import com.colombosoft.ednasalespad.model.DealerClass;
import com.colombosoft.ednasalespad.model.Product;
import com.colombosoft.ednasalespad.model.ProductBatch;
import com.colombosoft.ednasalespad.model.ProductBrand;
import com.colombosoft.ednasalespad.model.ProductCategory;
import com.colombosoft.ednasalespad.model.ProductLevel;
import com.colombosoft.ednasalespad.model.ProductUnit;
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

                        // download all routes
                        String routeJSONString =  networkFunction.sendGETRequestToServer(BaseURL.BASE_URL + "Routes", RequestType.GET_REQUEST);
                        Type routeType = new TypeToken<ArrayList<Route>>(){}.getType();
                        List<Route> routesList = new Gson().fromJson(routeJSONString, routeType);
                        new StoreRoute().storeRouteListInDB(sqLiteDatabase, routesList);

                        // download all dealers
                        String dealerJSONString = networkFunction.sendGETRequestToServer(BaseURL.BASE_URL + "Dealers", RequestType.GET_REQUEST);
                        Type dealerType = new TypeToken<ArrayList<Dealer>>(){}.getType();
                        List<Dealer> dealersList = new Gson().fromJson(dealerJSONString, dealerType);
                        new StoreDealer().storeDealerListInDB(sqLiteDatabase, dealersList);

                        // download all dealer class
                        String dealerClassJSONString = networkFunction.sendGETRequestToServer(BaseURL.BASE_URL + "DealerClasses", RequestType.GET_REQUEST);
                        Type dealerClassType = new TypeToken<ArrayList<DealerClass>>(){}.getType();
                        List<DealerClass> dealerClassList = new Gson().fromJson(dealerClassJSONString, dealerClassType);
                        new StoreDealerClass().storeDealerClassListInDB(sqLiteDatabase, dealerClassList);

                        // download all attendance

                        String attendenceJSONString = networkFunction.userAttendance(BaseURL.BASE_URL + "Attendances",
                                RequestType.GET_REQUEST,
                                user.getAccess_token());
                        Type attendanceType = new TypeToken<ArrayList<Attendance>>(){}.getType();
                        List<Attendance> attendanceList = new Gson().fromJson(attendenceJSONString, attendanceType);
                        List<Attendance> attendances = new ArrayList<Attendance>();
                        for(Attendance attendanceInner : attendanceList){
                            attendanceInner.setIsSync(true);
                            attendances.add(attendanceInner);
                        }
                        new StoreAttendance().storeDealerListInDB(sqLiteDatabase, attendances);

                        // download all products

                        String productJSONString = networkFunction.sendGETRequestToServer(BaseURL.BASE_URL + "Products", RequestType.GET_REQUEST);
                        Type productType = new TypeToken<ArrayList<Product>>(){}.getType();
                        List<Product> productList = new Gson().fromJson(productJSONString, productType);
                        new StoreProduct().storeProductListInDB(sqLiteDatabase, productList);

                        // dowload all product batch

                        String productBatchJSONString = networkFunction.sendGETRequestToServer(BaseURL.BASE_URL + "ProductBatches", RequestType.GET_REQUEST);
                        Type productBatchType = new TypeToken<ArrayList<ProductBatch>>(){}.getType();
                        List<ProductBatch> productBatchList = new Gson().fromJson(productBatchJSONString, productBatchType);
                        new StoreProductBatch().storeProductBatchListInDB(sqLiteDatabase, productBatchList);

                        // download all product brands

                        String productBrandJSONString = networkFunction.sendGETRequestToServer(BaseURL.BASE_URL + "ProductBrands", RequestType.GET_REQUEST);
                        Type productBrandType = new TypeToken<ArrayList<ProductBrand>>(){}.getType();
                        List<ProductBrand> productBrandList = new Gson().fromJson(productBrandJSONString, productBrandType);
                        new StoreProductBrand().storeDealerClassListInDB(sqLiteDatabase, productBrandList);

                        // download all product category

                        String productCategoryJSONString = networkFunction.sendGETRequestToServer(BaseURL.BASE_URL + "ProductCategories", RequestType.GET_REQUEST);
                        Type productCategoryType = new TypeToken<ArrayList<ProductCategory>>(){}.getType();
                        List<ProductCategory> productCategoryList = new Gson().fromJson(productCategoryJSONString, productCategoryType);
                        new StoreProductCategory().storeProductCategoryListInDB(sqLiteDatabase, productCategoryList);

                        // download all product levels

                        String productLevelJSONString = networkFunction.sendGETRequestToServer(BaseURL.BASE_URL + "ProductLevels", RequestType.GET_REQUEST);
                        Type productLevelType = new TypeToken<ArrayList<ProductLevel>>(){}.getType();
                        List<ProductLevel> productLevelList = new Gson().fromJson(productLevelJSONString, productLevelType);
                        new StoreProductLevel().storeProductListInDB(sqLiteDatabase, productLevelList);

                        // download all product unites

                        String productUnitJSONString = networkFunction.sendGETRequestToServer(BaseURL.BASE_URL + "ProductUnits", RequestType.GET_REQUEST);
                        Type productUnitType = new TypeToken<ArrayList<ProductUnit>>(){}.getType();
                        List<ProductUnit> productUnitList = new Gson().fromJson(productUnitJSONString, productUnitType);
                        new StoreProductUnit().storeProductUnitListInDB(sqLiteDatabase, productUnitList);


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

                Intent intent = new Intent(LoginActivity.this, AgentAttendanceActivity.class);
                startActivity(intent);

            }else {
                if (mWaitingMessage.isShowing()) {

                    mWaitingMessage.dismiss();

                }
                //mErrorMessage.setTranslationY(500);
                //mErrorMessage.setText("Email or Password is wrong");
                //mErrorMessage.setVisibility(View.VISIBLE);

            }
        }
    }

}
