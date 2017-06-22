package com.example.dell.hi_kitu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;

public class Dual_Display_Fragment extends FragmentActivity implements buttonclicked {
    int count = 1;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dual_display_fragment);
    }

    public void changinginteger(Button btn) {
            int value=0;
            if (btn.getId()==R.id.plus_btn) {
                value=1;
            }
            if(btn.getId()==R.id.minus_btn) {
                value=-1;
            }

        BottomFragment bf = (BottomFragment) getFragmentManager().findFragmentById(R.id.bottom_fragment);
        bf.onbuttonclick(Integer.toString(value));
        }

}


