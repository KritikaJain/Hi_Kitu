package com.example.dell.hi_kitu;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListOfGames extends AppCompatActivity {

   Button rview;
    Button vol;
    //int a[]=new int[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_games);
        final String[] games={"Call of duty","house of the dead","need for speed","wwe","teen patti","carrom",
                "Temple run","Candy crush","subway surfer","hill climb racing","ludo","chess","mario",
                "snake and ladder","word rush","chota bheem","brain dots","bahubali"};

        ListView myList= (ListView) findViewById(R.id.listofgames);
        ArrayAdapter adapter= new ArrayAdapter(this,R.layout.single_game_view,R.id.txt_game_name,games);
        myList.setAdapter(adapter);

        rview= (Button) findViewById(R.id.goto_rview);
        vol= (Button) findViewById(R.id.goto_vol);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {

                Intent frag = new Intent(getApplicationContext(),Fragment_Main_Activity.class);

                String message=games[position];
                frag.putExtra("MESSAGE",message);
                startActivity(frag);
            }
        });

            rview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(getApplicationContext(),RecyclePage.class);
                startActivity(r);

            }

        });
        vol.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent volley = new Intent(getApplicationContext(),VolleyPage.class);
                startActivity(volley);
            }
        });
}
}
