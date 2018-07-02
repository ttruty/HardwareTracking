package com.example.kinectprocessing.hardwaretracking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DeviceInfo extends Activity{



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_info_page);
        Bundle bundle = getIntent().getExtras();
        String itemId = bundle.getString("itemid");
        String mac = bundle.getString("mac");
        String serial = bundle.getString("serial");
        String subtype = bundle.getString("model");
        String itemname = bundle.getString("itemname");

        // item id display
        TextView item_idText = findViewById(R.id.itemIdField);
        item_idText.setText(itemId);

        TextView item_nameText = findViewById(R.id.itemNameField);
        item_nameText.setText(itemname);

        TextView serialText = findViewById(R.id.serialField);
        serialText.setText(serial);

        TextView macText = findViewById(R.id.macField);
        macText.setText(mac);

        TextView subText = findViewById(R.id.modelField);
        subText.setText(subtype);

//        //height  display
//        TextView heightText = findViewById(R.id.heightField);
//        heightText.setText(ParticipantDetails.height);
//
//        //weight display
//        TextView weightText = findViewById(R.id.weightField);
//        weightText.setText((ParticipantDetails.weight));
//
//        //pacemaker time display
//        TextView pacemakerText = findViewById(R.id.pacemakerField);
//        pacemakerText.setText(Boolean.toString(ParticipantDetails.pacemaker));
//
//        // home id display
//        TextView home_idText = findViewById(R.id.homeIdField);
//        home_idText.setText(HomeDetails.homeId);
//
//        //sqr footage display
//        TextView sqftText = findViewById(R.id.sqftField);
//        sqftText.setText(HomeDetails.sqrft);
//
//        //couple display
//        TextView coupleText = findViewById(R.id.coupleField);
//        coupleText.setText(Boolean.toString(HomeDetails.couple));
//
//        //date time display
//        Date currentTime = Calendar.getInstance().getTime();
//        TextView datetime = findViewById(R.id.dateField);
//        datetime.setText(currentTime.toString());
//
//        TextView cityText =  findViewById(R.id.cityField);
//        cityText.setText(LocationInfo.cityName);
//
//        TextView zipText =  findViewById(R.id.zipField);
//        zipText.setText(LocationInfo.zipCode);
//
//        TextView studyText =  findViewById(R.id.studyField);
//        studyText.setText(StudyDetials.studyId);


        Button next = findViewById(R.id.place_btn);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), TakePicture.class);
                startActivityForResult(myIntent, 0);
            }
        });



    }
}
