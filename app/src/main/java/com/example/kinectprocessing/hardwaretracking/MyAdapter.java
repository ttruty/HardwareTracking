package com.example.kinectprocessing.hardwaretracking;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] mDataset;
    private List<SampleInventory> inventortySamples =new ArrayList<>();

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView itemId, serial, itemName, mac;
        public ViewHolder(View view) {
            super(view);
            itemId = (TextView) view.findViewById(R.id.tv_item_id);
            serial = (TextView) view.findViewById(R.id.tv_serial);
            itemName = (TextView) view.findViewById(R.id.tv_name);
            mac = (TextView) view.findViewById(R.id.tv_mac);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<SampleInventory> inventortySamples) {
        this.inventortySamples = inventortySamples;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_row, parent, false);
        ViewHolder vh = new ViewHolder(itemView);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        SampleInventory sample = inventortySamples.get(position);
        holder.itemId.setText(sample.getItemid());
        holder.serial.setText(sample.getSerialnumber());
        holder.itemName.setText(sample.getItemname());
        holder.mac.setText(sample.getMacaddress());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return inventortySamples.size();
    }
}
