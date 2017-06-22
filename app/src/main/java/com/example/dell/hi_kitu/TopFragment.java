package com.example.dell.hi_kitu;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
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

public class TopFragment extends Fragment {
    int count=1;
    private Context mContext;
     buttonclicked ddf ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v= inflater.inflate(R.layout.top_fragment,container, false);

        final Button plus = (Button) v.findViewById(R.id.plus_btn);
        final Button minus = (Button) v.findViewById(R.id.minus_btn);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ddf.changinginteger(plus);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ddf.changinginteger(minus);
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        ddf= (buttonclicked) context;
    }
}
interface buttonclicked
{
    public void changinginteger(Button btn);
}
