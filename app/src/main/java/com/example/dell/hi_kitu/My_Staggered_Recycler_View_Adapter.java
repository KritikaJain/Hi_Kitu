package com.example.dell.hi_kitu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.List;

/**
 * Created by dell on 16-Jun-17.
 */

public class My_Staggered_Recycler_View_Adapter extends RecyclerView.Adapter<PostViewHolder> {

        private List<Posts> itemList;
        private Context mcontext;


        public My_Staggered_Recycler_View_Adapter(Context context, List<Posts> itemList) {
            this.itemList = itemList;
            this.mcontext = context;
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
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mcontext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mcontext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mcontext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
    }

