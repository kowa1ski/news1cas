package com.example.android.news1cas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // this is the link to use
    // http://content.guardianapis.com/search?q=technology&tag=technology/technology&api-key=test
    //recuerda que quizá esa url no sea la mejor opción

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}