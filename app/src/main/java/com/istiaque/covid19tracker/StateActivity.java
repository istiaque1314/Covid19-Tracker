package com.istiaque.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StateActivity extends AppCompatActivity {

    TextView stateName;
    TextView tvConfirmedCasesIndia, tvConfirmedCasesForeign,tvDischarged, tvDeaths, tvTotalConfirmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.designstates);

        stateName = findViewById(R.id.indiaStateName);

        tvConfirmedCasesIndia = findViewById(R.id.tvConfirmedCasesIndia);
        tvConfirmedCasesForeign = findViewById(R.id.tvConfirmedCasesForeign);
        tvDischarged = findViewById(R.id.tvDischarged);
        tvDeaths = findViewById(R.id.tvDeaths);
        tvTotalConfirmed = findViewById(R.id.tvTotalConfirmed);

        Intent i = getIntent();

        String stateName1 = i.getStringExtra("state");
        stateName.setText(stateName1);
        Log.e("STATE", "onCreate: " + stateName1 );

        String url = "https://api.rootnet.in/covid19-in/stats/latest";


        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("CODE",response);
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("regional");

                    Log.e("JSON", "onResponse: "+ jsonArray );

                    for(int i  = 0; i < jsonArray.length(); i++)
                    {


                        JSONObject data = jsonArray.getJSONObject(i);

                        String state = data.getString("loc");   //Getting Only state Name
                        Log.e("DATA", "onResponse: " + state);

                        if(state.equals(stateName1)){
                            tvConfirmedCasesIndia.setText(data.getString("confirmedCasesIndian"));
                            tvConfirmedCasesForeign.setText(data.getString("confirmedCasesForeign"));
                            tvDischarged.setText(data.getString("discharged"));
                            tvDeaths.setText(data.getString("deaths"));
                            tvTotalConfirmed.setText(data.getString("totalConfirmed"));


                        }

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