package com.example.appleitorrss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class FeedDetails extends AppCompatActivity {

    private static final String TAG = "FeedDetails";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_details);

        Intent intent = getIntent();
        FeedEntry feedEntry = (FeedEntry) intent.getSerializableExtra("feedEntry");
        Log.d(TAG, "onCreate: Do FeedDetails - recebi: " + feedEntry);
    }
}