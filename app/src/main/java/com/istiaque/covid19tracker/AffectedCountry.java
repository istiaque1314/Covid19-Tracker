package com.istiaque.covid19tracker;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AffectedCountry extends AppCompatActivity {

    TextView Country_Name;
    TextView tvCases,tvTodayCases,tvDeaths,tvTodayDeaths,tvRecovered,tvActive,tvCritical,tvTests,tvPopulation,tvContinent,tvUndefined;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affected_country);

        Country_Name = findViewById(R.id.Country_Name);

        tvCases = findViewById(R.id.tvCases);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvDeaths = findViewById(R.id.tvDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvActive = findViewById(R.id.tvActive);
        tvCritical = findViewById(R.id.tvCritical);
        tvTests = findViewById(R.id.tvTests);
        tvPopulation = findViewById(R.id.tvPopulation);
        tvContinent = findViewById(R.id.tvContinent);
        tvUndefined = findViewById(R.id.tvUndefined);

        Intent intentWorld = getIntent();

        String countryName = intentWorld.getStringExtra("country");
        Country_Name.setText(countryName);

        String url = "https://corona.lmao.ninja/v2/countries";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("CODE",response);

                try {

                    JSONArray jsonArray = new JSONArray(response);

                    for(int i = 0; i < jsonArray.length(); i++)
                    {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        tvCases.setText(jsonObject.getString("cases"));
                        tvTodayCases.setText(jsonObject.getString("todayCases"));
                        tvDeaths.setText(jsonObject.getString("deaths"));
                        tvTodayDeaths.setText(jsonObject.getString("todayDeaths"));
                        tvRecovered.setText(jsonObject.getString("recovered"));
                        tvActive.setText(jsonObject.getString("active"));
                        tvCritical.setText(jsonObject.getString("critical"));
                        tvTests.setText(jsonObject.getString("tests"));
                        tvPopulation.setText(jsonObject.getString("population"));
                        tvContinent.setText(jsonObject.getString("continent"));
                        tvUndefined.setText(jsonObject.getString("undefined"));

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        Volley.newRequestQueue(getApplicationContext()).add(request);

    }

}
