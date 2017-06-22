package com.example.dell.hi_kitu;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dell on 14-Jun-17.
 */

public class BottomFragment extends Fragment {
    String answer;
    private TextView final_text;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.bottom_fragment,container, false);
        final_text = (TextView) view.findViewById(R.id.bottom_frag_text_view);
        return view;
    }
    public void onbuttonclick(String value)
    {
        int data= Integer.parseInt(final_text.getText().toString());
        int valueInt=Integer.parseInt(value);

        if(data==1 && valueInt==-1){
            Toast.makeText(mContext,"Value cant be less than 1",Toast.LENGTH_SHORT).show();
            return;
        }
        final_text.setText(Integer.toString(data+(valueInt)));
    }
    public int getData(){
        String data=final_text.getText().toString();
        return Integer.parseInt(data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }
}