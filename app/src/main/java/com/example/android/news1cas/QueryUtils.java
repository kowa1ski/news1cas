package com.example.android.news1cas;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 04/05/2017.
 */

public final class QueryUtils {

    private static final String TAG = "QueryUtils";

    public static List<News> fetchNewsDATA(String requestUrl) {
        // Create URL object
        URL url = createURL(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(TAG, "Problem making the HTTP requesst.", e);
        }

        // Extract relevant fields from the JSON response and create a list of
        //  {@Link new}
        List<News> newsList = extractFeatureFromJson(jsonResponse);

        // Return the list of {@link news}
        return newsList;

    }

    /**
     * Returns new URL object from the given String URL
     */
    private static URL createURL(String stringUrl){
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(TAG, "Problem building the URL ", e);
        }

        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        //If the URL is null, then return early
        if(url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConection = null;
        InputStream inputStream = null;
        try {
            urlConection = (HttpURLConnection) url.openConnection();
            urlConection.setReadTimeout(10000);
            urlConection.setConnectTimeout(15000);
            urlConection.setRequestMethod("GET");
            urlConection.connect();

            //If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConection.getResponseCode() == 200) {
                inputStream = urlConection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(TAG, "Error response code: " + urlConection.getResponseCode());
            }

        } catch (IOException e) {
            Log.e(TAG, "Problem retrieving the news JSON results.", e);
        } finally {
            if (urlConection != null) {
                urlConection.disconnect();
            }
            if (inputStream != null) {
                //Closing the input stram could throw an IOException, which is why
                //the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the {@Link InputStream} into a String whit contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    /**
     * Return a lis of {@Link News} objects thath has been built up from
     * parsing the given JSON response.
     */
    private static List<News> extractFeatureFromJson(String newsJSON) {
        // If JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(newsJSON)) {
            return null;
        }
        //Create an empty ArrayList that we can start adding news to
        List<News> newsArrayList = new ArrayList<>();

        //Try parse the JSON response string. If there´s a problem with the way the JSON
        // is formatted, a JSONException exception object will be trhown.
        //Catch the exception so the app doesn´t crash, and print the error message to the logs.
        try {

            //Create a JSONObject from the JSON response string
            JSONObject baseJsonResponse = new JSONObject(newsJSON);

            /**
             * El siguiente bloque va a extraer la información de las
             * diferentes keys del objeto JSON.
             * TODO - los pasos son
             * 1. carga la url que tengo en comentarios en el main.
             * 2. identifica las claves que nos van a hacer falta.
             * 3. ponte a extraer esas claves debidamente.
             */
            //Extract the JSONArray associated with the key called





        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" bloc,
            // catch the exception here, so the app doesn´t crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the news JSON results", e);
        }
    }


}


















