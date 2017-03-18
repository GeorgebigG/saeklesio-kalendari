package com.sitename.android.saeklesiokalendari.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import com.sitename.android.saeklesiokalendari.R;

public class MainActivity extends AppCompatActivity {

    private Daily daily;
    private Eucharist eucharist;
    private Prayers prayers;
    private Library library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daily = new Daily();
        eucharist = new Eucharist();
        prayers = new Prayers();
        library = new Library();
        getSupportFragmentManager().beginTransaction().replace(R.id.content, daily).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_daily:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, daily).commit();
                        return true;
                    case R.id.navigation_eucharist:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, eucharist).commit();
                        return true;
                    case R.id.navigation_prayers:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, prayers).commit();
                        return true;
                    case R.id.navigation_library:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, library).commit();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.preferences){}


        return true;
    }
}




















