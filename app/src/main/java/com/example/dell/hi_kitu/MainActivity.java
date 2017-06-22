package com.example.dell.hi_kitu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewFlipper;


public class MainActivity extends AppCompatActivity {
    Button login;
    Button signup;

    Animation Fade_in, Fade_out;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewFlipper = (ViewFlipper) findViewById(R.id.homepage_slideshow_view);
        Fade_in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Fade_out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        viewFlipper.setAnimation(Fade_in);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.startFlipping();
       addListenerOnButton();
    }
    public void addListenerOnButton() {
        login = (Button) findViewById(R.id.btn_login);
        signup = (Button) findViewById(R.id.btn_signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),LoginPage.class);
                startActivity(i);
            }
        });

        signup.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View v)
        {
            Intent i= new Intent(getApplicationContext(),SignupPage.class);
            startActivity(i);
        }
         });
}
}