package com.sitename.android.saeklesiokalendari.Activities;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sitename.android.saeklesiokalendari.R;

import java.util.ArrayList;

public class Settings extends AppCompatActivity {

    Button choose, def;
    LinearLayout layout;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        layout = (LinearLayout) findViewById(R.id.color_picker);
        if (layout.getParent() != null)
            ((ViewGroup) layout.getParent()).removeView(layout);

        builder = new AlertDialog.Builder(Settings.this);
        builder.setView(layout).setCancelable(true);

        choose = (Button) findViewById(R.id.choose_color);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout.getParent() != null)
                    ((ViewGroup) layout.getParent()).removeView(layout);
                builder.create().show();
            }
        });

        def = (Button) findViewById(R.id.default_color);

        System.out.println(
                android.R.color.holo_red_dark + "\n"
                + android.R.color.holo_red_dark + "\n"
        );
    }

    public void onClick(View v) {
        try {
            FirstPage.BACKGROUND_COLOR = Integer.parseInt(v.getTag().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        builder.create().dismiss();
    }
}







