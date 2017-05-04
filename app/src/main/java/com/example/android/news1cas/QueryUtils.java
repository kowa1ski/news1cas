package com.example.android.news1cas;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by Usuario on 04/05/2017.
 */

public final class QueryUtils {

    public static List<News> fetchNewsDATA(String requestUrl) {
        // Create URL object
        URL url = createURL(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        jsonResponse = makeHttpRequest(url);

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
        //TODO . It´s needed a MalformedURLException?
        url = new URL(stringUrl);


    }


}



