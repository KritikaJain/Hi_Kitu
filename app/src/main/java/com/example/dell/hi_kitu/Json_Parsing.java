package com.example.dell.hi_kitu;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.dell.hi_kitu.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static android.R.attr.data;

public class Json_Parsing extends AppCompatActivity implements MyJsonParsingAdapter.MyClickListener {
    private RecyclerView jsrv;
    private RecyclerView.Adapter jsad;
    private RecyclerView.LayoutManager jslm;
    private static String LOG_TAG = "JsonParsing";

     ArrayList<jsontext> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json__parsing);

            jsrv = (RecyclerView) findViewById(R.id.js_rview);
            jsrv.setHasFixedSize(true);
            jslm = new LinearLayoutManager(getApplicationContext());
            jsrv.setLayoutManager(jslm);
            jsad = new MyJsonParsingAdapter(processingByVolley(),this);
             jsrv.setAdapter(jsad);
            RecyclerView.ItemDecoration itemDecoration =
                    new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
            jsrv.addItemDecoration(itemDecoration);

            // Code to Add an item with default animation
            //((MyJsonParsingAdapter) adapter).addItem(obj, index);

            // Code to remove an item with default animation
            //((MyJsonParsingAdapter) adapter).deleteItem(index);
        }

    @Override
        protected void onResume () {
            super.onResume();

        }

    public ArrayList<jsontext> processingByVolley() {
        String url = "https://jsonplaceholder.typicode.com/posts";
         data = new ArrayList<>();
        JsonArrayRequest jreq = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    public void onResponse(JSONArray response) {
                        try {

                            try {
                                String result = response.toString();
                                JSONArray jArray = new JSONArray(result);

                                for (int i = 0; i < jArray.length(); i++) {
                                    JSONObject obj = jArray.getJSONObject(i);
                                    jsontext urldata = new jsontext();
                                    urldata.userId = obj.getString("userId");
                                    urldata.id = obj.getString("id");
                                    urldata.title = obj.getString("title");
                                    urldata.body = obj.getString("body");
                                    data.add(urldata);
                                }

                            } catch (JSONException e) {
                                Toast.makeText(Json_Parsing.this, e.toString(), Toast.LENGTH_LONG).show();
                                e.printStackTrace();
                            }
                        } catch (Exception ee) {
                            ee.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(jreq);
        return data;
    }

    @Override
    public void onRightClick(int position) {
            Toast.makeText(this,"you clicked on right : "+data.get(position).getId(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onWrongClick(int position) {
        Toast.makeText(this,"you clicked on wrong : "+data.get(position).getId(),Toast.LENGTH_SHORT).show();
    }
    }
