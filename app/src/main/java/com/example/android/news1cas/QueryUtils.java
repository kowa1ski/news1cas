package com.example.android.news1cas;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

}



