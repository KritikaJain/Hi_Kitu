package com.example.dell.hi_kitu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by dell on 16-Jun-17.
 */

public class My_Staggered_Recycler_View_Adapter extends RecyclerView.Adapter<PostViewHolder> {

        private List<Posts> itemList;
        private Context context;


        public My_Staggered_Recycler_View_Adapter(Context context, List<Posts> itemList) {
            this.itemList = itemList;
            this.context = context;
        }

        @Override
        public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.staggered_view_post_list, null);
            PostViewHolder rcv = new PostViewHolder(layoutView);
            return rcv;
        }

        @Override
        public void onBindViewHolder(PostViewHolder holder, int position) {

            holder.post_content.setText(itemList.get(position).getContent());
            holder.post_photo.setImageResource(itemList.get(position).getPhoto());
            holder.post_title.setText(itemList.get(position).getTitle());
        }

        @Override
        public int getItemCount() {
            return this.itemList.size();
        }
    }

