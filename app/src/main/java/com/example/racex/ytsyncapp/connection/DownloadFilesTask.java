//package com.example.racex.ytsyncapp.connection;
//
//import android.app.ProgressDialog;
//import android.os.AsyncTask;
//
//import net.minidev.json.parser.JSONParser;
//
//import org.json.JSONObject;
//
//import java.net.URL;
//
///**
// * Created by racex on 05.05.2017.
// */
//
//private class JSONParse extends AsyncTask<String, String, JSONObject> {
//    private ProgressDialog pDialog;
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//        //przed wywołaniem
//        uid = (TextView)findViewById(R.id.uid);
//        name1 = (TextView)findViewById(R.id.name);
//        email1 = (TextView)findViewById(R.id.email);
//        pDialog = new ProgressDialog(MainActivity.this);
//        pDialog.setMessage("Getting Data ...");
//        pDialog.setIndeterminate(false);
//        pDialog.setCancelable(true);
//        pDialog.show();
//
//    }
//
//    @Override
//    protected JSONObject doInBackground(String... args) {
//        JSONParser jParser = new JSONParser();
//
//        // Getting JSON from URL
//        JSONObject json = jParser.getJSONFromUrl(args);
//        return json;
//    }
//    @Override
//    protected void onPostExecute(JSONObject json) {
//        pDialog.dismiss();
//        try {
//            // Getting JSON Array
//            user = json.getJSONArray(TAG_USER);
//            JSONObject c = user.getJSONObject(0);
//
//            // Storing  JSON item in a Variable
//            String id = c.getString(TAG_ID);
//            String name = c.getString(TAG_NAME);
//            String email = c.getString(TAG_EMAIL);
//
//            //Set JSON Data in TextView
//            uid.setText(id);
//            name1.setText(name);
//            email1.setText(email);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        //po zwrotce
//
//    }
//}