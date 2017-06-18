package com.sitename.android.saeklesiokalendari.Activities;

import android.graphics.Color;
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

    private Button choose, def;
    private LinearLayout layout;
    private RelativeLayout whole_screen;

    private AlertDialog dialog;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Daily.TOOLBAR_COLOR);
        toolbar.setSubtitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        layout = (LinearLayout) findViewById(R.id.color_picker);
        if (layout.getParent() != null)
            ((ViewGroup) layout.getParent()).removeView(layout);

        dialog = new AlertDialog.Builder(Settings.this).setView(layout).setCancelable(true).create();

        choose = (Button) findViewById(R.id.choose_color);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout.getParent() != null)
                    ((ViewGroup) layout.getParent()).removeView(layout);
                dialog = new AlertDialog.Builder(Settings.this).setView(layout).setCancelable(true).create();
                dialog.show();
            }
        });

        def = (Button) findViewById(R.id.default_color);

        whole_screen = (RelativeLayout) findViewById(R.id.main_settings_layout);
        whole_screen.setBackgroundColor(FirstPage.BACKGROUND_COLOR);
    }

    public void onClick(View v) {
        dialog.dismiss();
        try {
            FirstPage.BACKGROUND_COLOR = Daily.TOOLBAR_COLOR = getResources().getColor(Integer.parseInt(v.getTag().toString()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        toolbar.setBackgroundColor(Daily.TOOLBAR_COLOR);
        whole_screen.setBackgroundColor(FirstPage.BACKGROUND_COLOR);
    }

    public void defaultColor(View v) {
        Daily.TOOLBAR_COLOR = getResources().getColor(R.color.colorPrimary);
        FirstPage.BACKGROUND_COLOR = Color.WHITE;
        dialog.dismiss();

        toolbar.setBackgroundColor(Daily.TOOLBAR_COLOR);
        whole_screen.setBackgroundColor(FirstPage.BACKGROUND_COLOR);
    }
}







