package com.example.dell.hi_kitu;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dell on 12-Jun-17.
 */

public class ChoiceFragment extends Fragment {

    String playersno;
    String gun;
    String mode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag2, container, false);

        playersno = this.getArguments().getString("NOOFPLAYERS");
        gun = this.getArguments().getString("GUNS");
        mode = this.getArguments().getString("MODE");

        TextView noofplayers = (TextView) view.findViewById(R.id.choice_noofplayers);
        noofplayers.setText(playersno + " player");
        TextView guns = (TextView) view.findViewById(R.id.choice_guns);
        guns.setText(gun);
        TextView modes = (TextView) view.findViewById(R.id.choice_mode);
        modes.setText(mode);
        return view;
    }
}