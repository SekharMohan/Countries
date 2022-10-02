package com.countries.details.network;

import com.countries.details.model.Country;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RemoteCall {
    private static final String URL ="https://restcountries.com/v3.1/all";
    private Gson mGson;
    private URL mUrl;
    private static RemoteCall sRemoteCall;
    private RemoteCall()  {

        mGson = new Gson();
        try {
         mUrl = new URL(URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized  RemoteCall getRemoteCallInstance() {
        if(sRemoteCall == null) {
            sRemoteCall = new RemoteCall();
        }
        return sRemoteCall;
    }

    public void getCountryList(Result result) {
        new Thread()
        {
            public void run() {
                try {
                    HttpURLConnection urlConnection = (HttpURLConnection) mUrl.openConnection();
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    Type typeOfT = TypeToken.getParameterized(List.class, Country.class).getType();
                    result.onResponse(mGson.fromJson( readStream(in), typeOfT));
                } catch (IOException exception) {
                    exception.printStackTrace();
                    result.onResponse(Collections.emptyList());
                }
            }
        }.start();


    }

    private String readStream(InputStream is) throws IOException{

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int readBuffer = is.read();
            while(readBuffer != -1) {
                outputStream.write(readBuffer);
                readBuffer = is.read();
            }
            return outputStream.toString();

    }

    public interface Result {
       void onResponse(List<Country> countryList);

    }
}
