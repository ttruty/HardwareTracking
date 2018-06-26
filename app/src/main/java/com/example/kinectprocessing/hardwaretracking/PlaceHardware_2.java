package com.example.kinectprocessing.hardwaretracking;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PlaceHardware_2 extends Activity{

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_page);
        TextView home_id = findViewById(R.id.homeIdField);
        home_id.setText(HomeDetails.homeId);
    }
}
