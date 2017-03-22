package com.sitename.android.saeklesiokalendari.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.sitename.android.saeklesiokalendari.R;

public class Daily extends Fragment {

    public static int year;
    public static int month;
    public static int day;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_daily, container, false);

        v.findViewById(R.id.d_pref).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {FirstPage.settingButtonClicked();}
        });

        return v;
    }


}
