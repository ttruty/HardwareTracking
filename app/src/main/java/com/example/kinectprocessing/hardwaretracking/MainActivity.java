package com.example.kinectprocessing.hardwaretracking;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


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

        Button deviceList = findViewById(R.id.deviceListButton2);
        deviceList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), DeviceList.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}

