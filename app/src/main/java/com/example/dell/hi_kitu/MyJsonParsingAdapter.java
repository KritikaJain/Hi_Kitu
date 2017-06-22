package com.example.dell.hi_kitu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

/**
 * Created by dell on 01-Jun-17.
 */


public class MyJsonParsingAdapter extends RecyclerView
        .Adapter<MyJsonParsingAdapter
        .jsontextHolder> {
    private static String LOG_TAG = "MyAdapter";
    private ArrayList<jsontext> dataset;
    private static MyClickListener myClickListener;



    public static class jsontextHolder extends RecyclerView.ViewHolder{
        TextView lbluserid;
        TextView lblid;
        TextView lbltitle;
        TextView lblbody;
        TextView userId;
        TextView id;
        TextView title;
        TextView body;
        Button right;
        Button wrong;


        public jsontextHolder(View itemView) {
            super(itemView);
            lbluserid = (TextView) itemView.findViewById(R.id.lbl_userId);
            userId = (TextView) itemView.findViewById(R.id.userId);
            lbltitle = (TextView) itemView.findViewById(R.id.lbl_title);
            title = (TextView) itemView.findViewById(R.id.title);
            body = (TextView) itemView.findViewById(R.id.body);
            lblbody = (TextView) itemView.findViewById(R.id.lbl_body);
            lblid = (TextView) itemView.findViewById(R.id.lbl_id);
            id = (TextView) itemView.findViewById(R.id.id);
            right= (Button) itemView.findViewById(R.id.right);
            wrong= (Button) itemView.findViewById(R.id.wrong);

            Log.i(LOG_TAG, "Adding Listener");
           // itemView.setOnClickListener(this);
        }


    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyJsonParsingAdapter(ArrayList<jsontext> myDataset,MyClickListener myClickListener) {
        dataset = myDataset;
        this.myClickListener=myClickListener;
    }

    @Override
    public jsontextHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.json_object, parent, false);

        jsontextHolder p = new jsontextHolder(view);
        return p;
    }

    @Override
    public void onBindViewHolder(jsontextHolder holder, final int position) {

        final jsontext text=dataset.get(position);
        holder.userId.setText(text.getUserId());
        holder.id.setText(text.getId());
        holder.title.setText(text.getTitle());
        holder.body.setText(text.getBody());
        holder.right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClickListener.onRightClick(position);
            }
        });
        holder.wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               myClickListener.onWrongClick(position);
            }
        });

    }

    public void addItem(jsontext dataObj, int index) {
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
        public void onRightClick(int position);
        public void onWrongClick(int position);
    }
}