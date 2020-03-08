package com.example.myflickrproject;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class AsyncFlicker extends AsyncTask<Void, Void, String> {

    private String urlString;
    private HttpURLConnectionPostProcessorInterface httpURLConnectionPostProcessorInterface;

    public AsyncFlicker(String urlString,HttpURLConnectionPostProcessorInterface httpURLConnectionPostProcessorInterface) {

        this.urlString = urlString;
        this.httpURLConnectionPostProcessorInterface = httpURLConnectionPostProcessorInterface; // This is our Activity which implements the HttpURLConnectionPostProcessorInterface
    }

    @Override
    protected String doInBackground(Void... params) {
        String urlConnectionResultString = "";
        HttpURLConnection httpURLConnection = null;
        try {
            System.out.println("---------------------------------------------------------------" + urlString);

            httpURLConnection = (HttpURLConnection) new URL(urlString).openConnection();
            InputStream urlConnectionInputStream = httpURLConnection.getInputStream();
            urlConnectionResultString = inputStreamToString(urlConnectionInputStream);

        } catch (Exception exception) {

        }
        return urlConnectionResultString;
    }

    private String inputStreamToString(InputStream inputStream) {

        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        bufferedReader = new BufferedReader(inputStreamReader);
        String oneLine = null;
        try {
            while ((oneLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(oneLine);
            }
        } catch (Exception e) {
            httpURLConnectionPostProcessorInterface.failureHandler(e);
        }
        System.out.printf("--------------------------Result String" + stringBuilder.toString());
        return stringBuilder.toString();
    }

    @Override
    protected void onPostExecute(String urlConnectionResultString) {
        super.onPostExecute(urlConnectionResultString);
        System.out.println("-----------------------onPostExecute" + urlConnectionResultString);
        httpURLConnectionPostProcessorInterface.successHandler(urlConnectionResultString);
    }
}