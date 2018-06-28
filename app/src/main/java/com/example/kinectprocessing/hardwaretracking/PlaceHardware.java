package com.example.kinectprocessing.hardwaretracking;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

public class PlaceHardware extends Activity {
    private String homeID;
    private String sqrft;
    private String studyId;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_hardware);

        final EditText homeIdInput = findViewById(R.id.subjectIDText);
        final EditText sqftInput = findViewById(R.id.weightText);
        Button next = findViewById(R.id.next_btn);

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), PlaceHardware_2.class);
                startActivityForResult(myIntent, 0);
                homeID = homeIdInput.getText().toString();
                HomeDetails.homeId = homeID;
                sqrft = sqftInput.getText().toString();
                HomeDetails.sqrft = sqrft;

                // couple switch
                Switch coupleSwitch = findViewById(R.id.pacemaker);

                // check current state of a Switch (true or false).
                Boolean isCouple = coupleSwitch.isChecked();
                HomeDetails.couple = isCouple;

                finish();

            }

        });

        //Study selection code.
        Spinner dropdown = findViewById(R.id.spinner);
        //create a list of studies.
        String[] items = new String[]{"MARS", "MAP", "CORE", "ROS", "LATC"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);
        /* dropdown.setOnItemSelectedListener(this); */
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                Object item = adapterView.getItemAtPosition(position);
                String study = item.toString();
                //...
                switch (study) {
                    case "MARS":
                        studyId = "MARS";
                        break;
                    case "MAP":
                        studyId = "MAP";
                        break;
                    case "CORE":
                        studyId = "CORE";
                        break;
                    case "ROS":
                        studyId = "ROS";
                        break;
                    case "LATC":
                        studyId = "LATC";
                        break;
                }
                StudyDetials.studyId = studyId;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

}
