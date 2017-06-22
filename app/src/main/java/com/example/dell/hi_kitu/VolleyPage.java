package com.example.dell.hi_kitu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class VolleyPage extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    Button b2;
    Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley_page);
        addListenerOnButton();

    }
    private void addListenerOnButton() {

        b1= (Button) findViewById(R.id.String_text);
        b2= (Button) findViewById(R.id.Json_text);
        b3= (Button) findViewById(R.id.json_parsing);





        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        }

    private void OnButtonThree() {
        Intent json = new Intent(getApplicationContext(),Json_Parsing.class);
        startActivity(json);
    }

    private void onButtonTwo() {
        String url2 = "https://jsonplaceholder.typicode.com/posts/1";
        JsonObjectRequest jreq = new JsonObjectRequest
                (Request.Method.GET, url2, null, new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        try {
                            Toast.makeText(VolleyPage.this, response.toString(), Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        Volley.newRequestQueue(getApplicationContext()).add(jreq);
    }

    private void onButtonOne() {
        String url1 = "http://www.google.co.in";
        StringRequest sreq = new StringRequest(Request.Method.GET, url1,
                new Response.Listener<String>() {
                    public void onResponse(String res) {
                        System.out.println(res.substring(0, 100));
                        Toast.makeText(VolleyPage.this, res.substring(0, 100), Toast.LENGTH_LONG).show();


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Something went wrong!");
                Toast.makeText(VolleyPage.this, error.getMessage(), Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(sreq);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.String_text:
                onButtonOne();
                break;
            case R.id.Json_text:
                onButtonTwo();
                break;
            case R.id.json_parsing :
                 OnButtonThree();
                break;

            default:

        }

    }
}

