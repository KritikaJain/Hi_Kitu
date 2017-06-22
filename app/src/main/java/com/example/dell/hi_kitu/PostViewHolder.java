package com.example.dell.hi_kitu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dell on 16-Jun-17.
 */


public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView post_content;
        public ImageView post_photo;
        public TextView post_title;

        public PostViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            post_content = (TextView) itemView.findViewById(R.id.post_content_txt);
            post_title = (TextView) itemView.findViewById(R.id.post_title_txt);
            post_photo = (ImageView) itemView.findViewById(R.id.post_img);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();
        }
}

