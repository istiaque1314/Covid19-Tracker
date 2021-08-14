package com.istiaque.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
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

public class BedsAndHospitalActivity extends AppCompatActivity {

    TextView State_Name;
    TextView tvRuralHosp, tvRuralBeds, tvUrbanHosp, tvUrbanBeds, tvTotalHosp, tvTotalBeds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beds_and_hospital);

        State_Name = findViewById(R.id.State_Name);

        tvRuralHosp = findViewById(R.id.tvRuralHos);
        tvRuralBeds = findViewById(R.id.tvRuralBeds);
        tvUrbanHosp = findViewById(R.id.tvUrbanHosp);
        tvUrbanBeds = findViewById(R.id.tvUrbanBeds);
        tvTotalHosp = findViewById(R.id.tvTotalHosp);
        tvTotalBeds = findViewById(R.id.tvTotalBeds);

        Intent i = getIntent();

        String stateName = i.getStringExtra("state");
        State_Name.setText(stateName);



        String url = "https://api.rootnet.in/covid19-in/hospitals/beds";

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

                        String state = data.getString("state");//Getting Only state Name
                        Log.e("DATA", "onResponse: " + state);

                        if(state.equals(stateName)){
                            tvRuralHosp.setText(data.getString("ruralHospitals"));
                            tvRuralBeds.setText(data.getString("ruralBeds"));
                            tvUrbanHosp.setText(data.getString("urbanHospitals"));
                            tvUrbanBeds.setText(data.getString("urbanBeds"));
                            tvTotalHosp.setText(data.getString("totalHospitals"));
                            tvTotalBeds.setText(data.getString("totalBeds"));

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