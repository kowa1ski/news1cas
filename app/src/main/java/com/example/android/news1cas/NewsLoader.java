package com.example.android.news1cas;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by Usuario on 04/05/2017.
 *
 * Loads a list of books by using an Loader(AsynTask to perform
 * the network request to the given URL.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>>{

    /** Query URL */
    private String mURL;

    /**
     * Constructs a new {@Link NewsLoader}
     *
     * @param context of the activity
     * @param url to load data from
     */

    public NewsLoader(Context context, String url) {
        super(context);
        mURL = url;
    }

    @Override
    protected void onStartLoading() {forceLoad();}


    /**
     * This is on a background thead
     * @return
     */
    @Override
    public List<News> loadInBackground() {
        if(mURL == null) {return null;}

        List<News> newsList = QueryUtils.fetchNewsDATA(mURL);
        return newsList

    }


}
