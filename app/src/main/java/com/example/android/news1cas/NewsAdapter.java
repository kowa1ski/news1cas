package com.example.android.news1cas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * An {@Link NewsAdapter} knows how to create a list item layout for each new
 * in the data source (a list of {@Link News} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */

public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Construct a new {@Link newsAdapter}.
     *
     * @param context of the app
     * @param newsList is the list of news, which is the data source of the adapter
     */

    public NewsAdapter(Context context, List<News> newsList) { super(context, 0, newsList);}

    /**
     * Returns a list item view that displays information about the news at the given position
     * in the list of news
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        //otherwise, if convertView is null, then inflate a new list iten layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_news_adapter, parent, false);
        }

        //Find the new at the given position in the list
        News currentnew = getItem(position);

        //Find the Texview with view ID section
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        String sectionName = currentnew.getmSection();
        //Display the section
        sectionView.setText(sectionName);

        // TODO - este bloque lo estoy haciendo sin mirar así que hay que comprobarlo luego
        //Find the TexView with view ID tittle
        TextView tittleInformationView = (TextView) listItemView.findViewById(R.id.tittle);
        String tittleInformation = currentnew.getmTittle();
        //Display the tittle information
        tittleInformationView.setText(tittleInformation);

        //Return the list item view that is now showing the apropiate data
        return listItemView;

    }
}