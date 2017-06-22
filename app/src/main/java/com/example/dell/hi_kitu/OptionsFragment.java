package com.example.dell.hi_kitu;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dell on 12-Jun-17.
 */

public class OptionsFragment extends Fragment {

    private Context mContext;
    int count = 1;
    String gun;
    String mode;
    private TextView noofplayers;
    private TextView gameNameTextview;
    private RadioGroup rdg1;
    private RadioGroup rdg2;
    private int selectedId2;
    private int selectedId1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag1, container, false);

        gameNameTextview = (TextView) view.findViewById(R.id.name_of_game);
        String gameName = ((Fragment_Main_Activity) mContext).getIntent().getStringExtra("MESSAGE");
        gameNameTextview.setText(gameName);

        noofplayers = (TextView) view.findViewById(R.id.no_of_player_txt);
        Button upbtn = (Button) view.findViewById(R.id.up_btn);
        Button downbtn = (Button) view.findViewById(R.id.down_btn);
        upbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++count;
                noofplayers.setText(Integer.toString(count) + " Player");
            }
        });
        downbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count <= 1) {
                    Toast.makeText(mContext, "Player cant be less than one.", Toast.LENGTH_SHORT).show();
                    return;
                }
                --count;
                noofplayers.setText(Integer.toString(count) + " Player");
            }
        });

        rdg1 = (RadioGroup) view.findViewById(R.id.rdgroup1);
        rdg2 = (RadioGroup) view.findViewById(R.id.rdgroup2);

        final Button gamechoicesubmit = (Button) view.findViewById(R.id.gamechoice_submitbtn);
        gamechoicesubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    selectedId1 = rdg1.getCheckedRadioButtonId();
                    selectedId2 = rdg2.getCheckedRadioButtonId();
                    if (validate())
                    {
                        RadioButton rdbtn1 = (RadioButton) view.findViewById(selectedId1);
                        gun = (String) rdbtn1.getText();
                        RadioButton rdbtn2 = (RadioButton) view.findViewById(selectedId2);
                        mode = (String) rdbtn2.getText();
                        ChoiceFragment fr = new ChoiceFragment();
                        Bundle args = new Bundle();
                        args.putString("NOOFPLAYERS", Integer.toString(count));
                        args.putString("GUNS", gun);
                        args.putString("MODE", mode);
                        fr.setArguments(args);
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        Fragment fragment = getFragmentManager().findFragmentById(R.id.frag1);
                        if (fragment != null) {
                            transaction.hide(fragment);
                        }
                        transaction.add(R.id.activity_fragment_main, fr);
                        transaction.addToBackStack(OptionsFragment.class.getSimpleName());
                        transaction.commit();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private boolean validate() {
        if (selectedId1 == -1) {
            Toast.makeText(mContext, "Please select a gun", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (selectedId2 == -1) {
            Toast.makeText(mContext, "Please select a mode", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}



