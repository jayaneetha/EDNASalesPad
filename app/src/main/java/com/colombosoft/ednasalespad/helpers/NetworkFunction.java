package com.colombosoft.ednasalespad.helpers;

import android.util.Log;

import com.colombosoft.ednasalespad.utilities.RequestType;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by DragonSlayer on 11/6/2015.
 */

public class NetworkFunction {

    private final static String TAG = "NetworkFunction";

    private HttpURLConnection connection;

    private HttpURLConnection getNetworkConnection(String URL , String requestMethod) throws IOException{

        URL postURL = new URL(URL);
        HttpURLConnection innerConnection = (HttpURLConnection) postURL.openConnection();
        innerConnection.setRequestMethod(requestMethod);
        innerConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");

        if(requestMethod == RequestType.POST_REQUEST){
            innerConnection.setDoInput(true);
            innerConnection.setDoOutput(true);
        }

        //innerConnection.connect();
        return innerConnection;

    }

    private String serverResponse(HttpURLConnection connection)throws IOException{

        String response = "";

        int status = connection.getResponseCode();

        Log.d(TAG, Integer.toString(status));
        switch (status) {
            case 200:
            case 201:
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();

                response = stringBuilder.toString();
                //Log.i(TAG, "Server Response : \n" + response);
        }
        connection.disconnect();
        return response;
    }

    public String sendPOSTRequestToServer(String URL , String requestMethod ,String jsonString) throws IOException{

        connection = getNetworkConnection(URL,requestMethod);

        DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
        wr.writeBytes(jsonString);
        wr.flush();
        wr.close();

        return serverResponse(connection);
    }

    public String sendGETRequestToServer(String URL , String requestMethod) throws IOException{

        connection = getNetworkConnection(URL , requestMethod);

        return serverResponse(connection);
    }

    public String userAuthentication (String URL , String requestMethod ,String jsonString) throws IOException{

        URL postURL = new URL(URL);
        HttpURLConnection innerConnection = (HttpURLConnection) postURL.openConnection();
        innerConnection.setRequestMethod(requestMethod);
        innerConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        innerConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        innerConnection.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream (innerConnection.getOutputStream ());
        wr.writeBytes(jsonString);
        wr.flush();
        wr.close();

        return serverResponse(innerConnection);

    }

}
