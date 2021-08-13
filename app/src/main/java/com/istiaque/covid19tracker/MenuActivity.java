package com.istiaque.covid19tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MenuActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;


    NavigationView navigationView;
    ActionBarDrawerToggle toggle;   // No use in xml
    DrawerLayout drawerLayout;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        navBar();
        bottomBar();
    }

    private void bottomBar() {

        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setItemIconTintList(null);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

//                    case R.id.home_menu:
//
//                        Intent intent13 = new Intent(MenuActivity.this, MenuActivity.class);
//                        startActivity(intent13);
//                        break;

                    case R.id.world_menu:

                        Intent intent3 = new Intent(MenuActivity.this,WorldActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.india_menu:

                        Intent intent4 = new Intent(MenuActivity.this,IndiaActivity.class);
                        startActivity(intent4);
                        break;

                    case R.id.bedsmenu:

                        Intent intent5 = new Intent(MenuActivity.this,BedsActivity.class);
                        startActivity(intent5);
                        break;
                }


                return true;
            }
        });

    }

    private void navBar() {
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navMenu);
        drawerLayout = findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.help:

                        Intent intent = new Intent(MenuActivity.this,HelpActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.awareness:

                        Intent intent2 = new Intent(MenuActivity.this,AwareActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.about:
//
//                        Intent intent5 = new Intent(MainActivity.this,BedsActivity.class);
//                        startActivity(intent5);
//                        break;
                }


                return true;
            }
        });

    }


}