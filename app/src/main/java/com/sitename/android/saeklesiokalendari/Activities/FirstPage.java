package com.sitename.android.saeklesiokalendari.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.sitename.android.saeklesiokalendari.R;

public class FirstPage extends AppCompatActivity {

    private Daily daily;
    private Eucharist eucharist;
    private Prayers prayers;
    private Library library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");

        daily = new Daily();
        eucharist = new Eucharist();
        prayers = new Prayers();
        library = new Library();
        getSupportFragmentManager().beginTransaction().replace(R.id.basic_screen, daily).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.tabs);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_daily:
                        getSupportFragmentManager().beginTransaction().replace(R.id.basic_screen, daily).commit();
                        return true;
                    case R.id.navigation_eucharist:
                        getSupportFragmentManager().beginTransaction().replace(R.id.basic_screen, eucharist).commit();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}































