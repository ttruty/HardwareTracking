package com.example.kinectprocessing.hardwaretracking;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlaceHardware extends Activity{
    public String homeID;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_hardware);

        final EditText editHome = findViewById(R.id.editHome);
        Button next = findViewById(R.id.newInstall);

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), PlaceHardware_2.class);
                startActivityForResult(myIntent, 0);
                homeID = editHome.getText().toString();
                HomeDetails.homeId = homeID;
                finish();

            }

        });
    }
}
