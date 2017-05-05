package com.example.racex.ytsyncapp;

import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.racex.ytsyncapp.connection.HttpConnection;
import com.jayway.jsonpath.JsonPath;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button przycisk;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         przycisk = (Button) findViewById(R.id.button);
         text = (TextView) findViewById(R.id.text);
    }

    public void getSync(View v)
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        this.runOnUiThread(new Runnable() {
            public void run() {
                String  json1 = new HttpConnection("https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UCycOk21xIkZWHrTeWFVTIMg&key=AIzaSyCg3WitBUQl5ifC2QygQaZUPOSRMKfSD5E").getResponse().toString();
                List<String> test = JsonPath.read(json1, "$.items[*].id");
                String json2 = new HttpConnection("https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLZaEF7JGNv6I8jyxRAjKnYRT5xFA1a5u-&key=AIzaSyCg3WitBUQl5ifC2QygQaZUPOSRMKfSD5E").getResponse().toString();
                List<String> test2 = JsonPath.read(json2, "$.items[*].snippet.title");
                text.setText(test.toString() + test2.toString());
           }
        });





        //pobieranie dostępnych plalist https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UCycOk21xIkZWHrTeWFVTIMg&key=AIzaSyCg3WitBUQl5ifC2QygQaZUPOSRMKfSD5E
        //moj get listy video dla plalisty :D https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLZaEF7JGNv6I8jyxRAjKnYRT5xFA1a5u-&key=AIzaSyCg3WitBUQl5ifC2QygQaZUPOSRMKfSD5E
        //potem z niego pobieram videoID
        //no i zapisuję do pliku łatwe co nie xD
        //brakuje  tylko zamiany z username na channel id
       // text.setText("Nacisnąłes przycisk no haker kurwa Xd");
    }


}
