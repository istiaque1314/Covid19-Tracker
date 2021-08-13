package com.istiaque.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class StateActivity extends AppCompatActivity {

    String url = "https://corona.lmao.ninja/v2/countries/";
    RecyclerView recState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);
    }
}