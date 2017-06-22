package com.example.dell.hi_kitu;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by dell on 01-Jun-17.
 */


public class MyRecyclerViewAdapter extends RecyclerView
        .Adapter<MyRecyclerViewAdapter
        .playerHolder> {
    private static String LOG_TAG = "MyAdapter";
    private ArrayList<player> dataset;
    private static MyClickListener myClickListener;

    public static class playerHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView name;
        TextView age;
        TextView id;

        public playerHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            age = (TextView) itemView.findViewById(R.id.age);
            id = (TextView) itemView.findViewById(R.id.id);

            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapter(ArrayList<player> myDataset) {
        dataset = myDataset;
    }

    @Override
    public playerHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);

        playerHolder p = new playerHolder(view);
        return p;
    }

    @Override
    public void onBindViewHolder(playerHolder holder, int position) {
        holder.name.setText(dataset.get(position).getName());
        holder.age.setText(dataset.get(position).getAge());
        holder.id.setText(dataset.get(position).getPlayer_id());
    }

    public void addItem(player dataObj, int index) {
        dataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        dataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}