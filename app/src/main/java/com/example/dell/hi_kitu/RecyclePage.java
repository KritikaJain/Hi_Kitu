package com.example.dell.hi_kitu;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclePage extends AppCompatActivity {
    private RecyclerView rv;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lm;
    private static String LOG_TAG = "RecyclePage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_page);

        rv = (RecyclerView) findViewById(R.id.recycle_view);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        adapter = new MyRecyclerViewAdapter(getDataSet());
        rv.setAdapter(adapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        rv.addItemDecoration(itemDecoration);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) adapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) adapter).deleteItem(index);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) adapter).setOnItemClickListener(new
                                                                         MyRecyclerViewAdapter.MyClickListener() {
                                                                             @Override
                                                                             public void onItemClick(int position, View v) {
                                                                                 Log.i(LOG_TAG, " Clicked on Item " + position);
                                                                             }
                                                                         });
    }


    private ArrayList<player> getDataSet() {
        ArrayList results = new ArrayList<player>();

            player obj = null;
        results.add(new player("Kitu", "21", "1"));
        results.add(new player("Soumya", "21", "2"));
        results.add(new player("rithambhra", "20", "3"));
        results.add(new player("zolo", "20", "3"));
        results.add(new player("barrymore", "18", "4"));
        results.add(new player("frank", "19", "5"));
        results.add(new player("kenshire", "20", "6"));
        results.add(new player("auta", "22", "7"));
        results.add(new player("osho", "22", "8"));
        results.add(new player("zane", "21", "9"));
        results.add(new player("merrylap", "21", "10"));
        results.add(new player("uncle sam", "20", "11"));
        results.add(new player("fishtale", "24", "12"));
        results.add(new player("remy", "22", "13"));
        results.add(new player("joron", "21", "14"));
        results.add(new player("max", "20", "15"));
        results.add(new player("kittens", "19", "16"));
        results.add(new player("fluffyball", "19", "17"));
        results.add(new player("sandstorm", "20", "18"));
        results.add(new player("shuichan", "22", "19"));
        results.add(new player("lexie", "21", "20"));


        return results;
    }
}

