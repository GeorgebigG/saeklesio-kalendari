package com.sitename.android.saeklesiokalendari.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.sitename.android.saeklesiokalendari.R;

public class FirstPage extends AppCompatActivity {

    private Daily daily;
    private Prayers prayers;
    private Library library;
    private static Context context;

    private LinearLayout layout;

    BottomNavigationView tabs;

    public static int BACKGROUND_COLOR = Color.WHITE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        setTitle("");

        layout = (LinearLayout) findViewById(R.id.main_layout);

        context = this;
        daily = new Daily();
        prayers = new Prayers();
        library = new Library();
        getSupportFragmentManager().beginTransaction().replace(R.id.basic_screen, daily).commit();

        tabs = (BottomNavigationView) findViewById(R.id.tabs);
        tabs.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_daily:
                        getSupportFragmentManager().beginTransaction().replace(R.id.basic_screen, daily).commit();
                        return true;
                    case R.id.navigation_prayers:
                        getSupportFragmentManager().beginTransaction().replace(R.id.basic_screen, prayers).commit();
                        return true;
                    case R.id.navigation_library:
                        getSupportFragmentManager().beginTransaction().replace(R.id.basic_screen, library).commit();
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        layout.setBackgroundColor(BACKGROUND_COLOR);
        tabs.setBackgroundColor(BACKGROUND_COLOR);
        System.out.println(BACKGROUND_COLOR);
    }

    public static void settingButtonClicked() {
        Intent intent = new Intent(context, Settings.class);
        context.startActivity(intent);
    }
}































