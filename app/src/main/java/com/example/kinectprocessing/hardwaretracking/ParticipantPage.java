package com.example.kinectprocessing.hardwaretracking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class ParticipantPage extends Activity {
    private String partId;
    private String height;
    private String weight;
    private boolean isPacemaker = false;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.participant_page);

        final EditText partIdText = findViewById(R.id.subjectIDText);
        final EditText heightText = findViewById(R.id.heightText);
        final EditText weightText = findViewById(R.id.weightText);
        Button next = findViewById(R.id.next_btn);

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ParticipantPage_2.class);
                startActivityForResult(myIntent, 0);
                partId = partIdText.getText().toString();
                ParticipantDetails.partId = partId;

                height = heightText.getText().toString();
                ParticipantDetails.height = height;

                weight = weightText.getText().toString();
                ParticipantDetails.weight = weight;

                // couple switch
                Switch pacemakerSwitch = findViewById(R.id.pacemaker);

                // check current state of a Switch (true or false).
                isPacemaker = pacemakerSwitch.isChecked();
                ParticipantDetails.pacemaker = isPacemaker;

                finish();

            }

        });
    }
}
