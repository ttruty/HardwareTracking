package com.example.kinectprocessing.hardwaretracking;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class DeviceList extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<SampleInventory> inventortySamples =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_list_page);
        mRecyclerView = findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(inventortySamples);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setAdapter(mAdapter);

        // row click listener
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                SampleInventory sample = inventortySamples.get(position);
                Intent myIntent = new Intent(view.getContext(), DeviceInfo.class);
                myIntent.putExtra("itemid", sample.getItemid());
                myIntent.putExtra("mac", sample.getMacaddress());
                myIntent.putExtra("itemname", sample.getItemname());
                myIntent.putExtra("model", sample.getModelname());
                myIntent.putExtra("subtype", sample.getSubtypename());

                startActivityForResult(myIntent, 0);
                //Toast.makeText(getApplicationContext(), sample.getItemname() + " is selected!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        readInventory();
    }

    private void readInventory() {
        InputStream is = getResources().openRawResource(R.raw.griddata_1530540271058);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                // split by commas
                String[] tokens = line.split(",");

                //read data
                SampleInventory sample = new SampleInventory();
                sample.setItemid(tokens[0].replace("\"", ""));
                sample.setItemname(tokens[1].replace("\"", ""));
                sample.setSerialnumber(tokens[5].replace("\"", ""));
                sample.setMacaddress(tokens[3].replace("\"", ""));

                //add to list
                inventortySamples.add(sample);
                Log.d("MyActivity", "Just Created: " + sample.toString());
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line "  + line, e);
            e.printStackTrace();
        }
        mAdapter.notifyDataSetChanged();
    }
}