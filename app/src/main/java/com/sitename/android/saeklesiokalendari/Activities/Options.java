package com.sitename.android.saeklesiokalendari.Activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sitename.android.saeklesiokalendari.R;

public class Options extends AppCompatActivity
{

    public static String[] topics;
    public static String[] storys;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eucharist_options);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        LinearLayout layout = (LinearLayout) findViewById(R.id.option_layout);
        LinearLayout.LayoutParams lParams;
        TextView text;
        layout.removeAllViews();

        for (int i = 0; i < topics.length; i++)
        {
            lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            text = new TextView(this);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                text.setTextAppearance(android.R.style.TextAppearance_Large);
            else
                text.setTextAppearance(this, android.R.style.TextAppearance_Large);
            lParams.gravity = Gravity.CENTER;
            text.setText(topics[i]);
            text.setTextColor(getResources().getColor(android.R.color.black));
            layout.addView(text, lParams);

            lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.activity_vertical_margin);
            text = new TextView(this);
            text.setTextColor(getResources().getColor(android.R.color.black));
            text.setText(storys[i]);
            layout.addView(text, lParams);
        }
    }
}
