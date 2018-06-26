package com.example.kinectprocessing.hardwaretracking;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button next = findViewById(R.id.newPlaceButton);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), PlaceHardware.class);
                startActivityForResult(myIntent, 0);
            }
        });

        Button locate = findViewById(R.id.location_btn);
        locate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), DebugLocation.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}

