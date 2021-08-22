package com.istiaque.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BedsActivity extends AppCompatActivity {

  String url = "https://api.rootnet.in/covid19-in/hospitals/beds";
  RecyclerView recState;
  ArrayList<BedsModel>arrayListBeds;
  private BedsAdapter bedsAdapter;
  Context context;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_beds);

    recState = findViewById(R.id.recBeds);
    arrayListBeds = new ArrayList<>();

    StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
      @Override
      public void onResponse(String response) {

        Log.d("CODE",response);
        try {

          JSONObject jsonObject = new JSONObject(response);
          JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("regional");

          for(int i  = 0; i < jsonArray.length(); i++)
          {
            JSONObject data = jsonArray.getJSONObject(i);

            arrayListBeds.add(new BedsModel(data.getString("state")));
          }
          recState.setLayoutManager(new LinearLayoutManager(context));
          bedsAdapter = new BedsAdapter(arrayListBeds,getApplicationContext());
          recState.setAdapter(bedsAdapter);



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

  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    getMenuInflater().inflate(R.menu.search,menu);
    MenuItem item = menu.findItem(R.id.search_menu);

    SearchView searchView = (SearchView)item.getActionView();

    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        return false;
      }

      @Override
      public boolean onQueryTextChange(String newText)
      {
        bedsAdapter.getFilter().filter(newText);

        return false;
      }
    });
    return super.onCreateOptionsMenu(menu);
  }

}