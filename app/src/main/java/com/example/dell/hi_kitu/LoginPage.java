package com.example.dell.hi_kitu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    EditText edt1;
    EditText edt2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        b1 = (Button) findViewById(R.id.btn_submit);
        edt1 = (EditText) findViewById(R.id.edt_uname);
        edt2 = (EditText) findViewById(R.id.edt_pass);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().toString().equalsIgnoreCase("Kritika") && edt2.getText().toString().equalsIgnoreCase("kritika")) {
                    Toast.makeText(LoginPage.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                    Intent j = new Intent(getApplicationContext(), Navigation_Main_Activity.class);
                    String message=edt1.getText().toString();
                    j.putExtra("MESSAGE",message);
                    startActivity(j);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
