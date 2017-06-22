package com.example.dell.hi_kitu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OtpPage extends AppCompatActivity {
    TextView txt1;
    Button b;
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_page);
        txt1 = (TextView) findViewById(R.id.text1);
       String message = getIntent().getStringExtra("MESSAGE");
        txt1.setText(message);
        b = (Button) findViewById(R.id.btn_enter);
        edt= (EditText) findViewById(R.id.otp);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=edt.getText().toString();
                if(s.equals("1234")) {
                    Intent k = new Intent(getApplicationContext(), ListOfGames.class);
                    startActivity(k);
                }

            }
        });



    }

}

