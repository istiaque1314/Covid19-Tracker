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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HelpActivity extends AppCompatActivity {

    String url = "https://api.rootnet.in/covid19-in/contacts";
    private static final String TAG = "Checking1" ;

    RecyclerView recView;
    private ArrayList<HelpModel> arrayList;
    private HelpAdapter helpAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        recView = findViewById(R.id.recView);
        arrayList = new ArrayList<>();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response -> {
            Log.d(TAG, "onResponse: "+ response);
//            Log.d("code",response);

            try {
                //x.data.contacts.regional[0]

                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONObject("contacts")
                        .getJSONArray("regional"); //point of mistake

                for (int i = 0; i< jsonArray.length(); i++)
                {

                    JSONObject data  = jsonArray.getJSONObject(i);
                    Log.d(TAG, "onCreate: "+data);

                    arrayList.add(new HelpModel(data.getString("loc"),data.getString("number")));

                }
                recView.setLayoutManager(new LinearLayoutManager(context));//point of mistake
                helpAdapter = new HelpAdapter(arrayList,getApplicationContext());
                recView.setAdapter(helpAdapter);


            } catch (JSONException e) {

                e.printStackTrace();
            }

        }, error -> Log.e("Volley", error.toString()));

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);

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
                helpAdapter.getFilter().filter(newText);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}