package com.example.dell.hi_kitu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class Slideshow_All extends AppCompatActivity {
    Animation Fade_in, Fade_out;
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slideshow_all);

        viewFlipper = (ViewFlipper) findViewById(R.id.homepage_slideshow_all);
        Fade_in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Fade_out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        viewFlipper.setAnimation(Fade_in);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.startFlipping();
    }
}
