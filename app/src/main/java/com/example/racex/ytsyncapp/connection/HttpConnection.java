package com.example.racex.ytsyncapp.connection;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by racex on 04.05.2017.
 */

public class HttpConnection {
   URI website;

    public HttpConnection(String url)
    {
        try {
            website = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    public JSONObject getResponse()
    {
        BufferedReader in = null;
        String data = null;

        try{
            HttpClient httpclient = new DefaultHttpClient();

            HttpGet request = new HttpGet();
            request.setURI(website);
            HttpResponse response = httpclient.execute(request);
            JSONObject myObject = new JSONObject(EntityUtils.toString(response.getEntity()));
           return myObject;
        }catch(Exception e){
            Log.e("log_tag", "Error in http connection "+e.toString());
        }
        return null;
    }
}
