package com.example.admin.barcodescanneractivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class resultPage extends AppCompatActivity{



    Button scanbutton;
    public static String scanned;
    public static TextView resulttextview;
    private RecyclerView recyclerView;
    private  RecyclerView.Adapter adapter;
    public static List<ListItem>  listItems = new ArrayList<>();
    public static List<ListItem>  updatedListItems = new ArrayList<>();
    private static final String URL = "https://api.github.com/users";


    public void onScanPressed(View view){
        finish();
        startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
    }

    public void addItemtoList(String barCode){

        listItems.add(new ListItem(barCode,"new Item"));
        Toast.makeText(this,barCode,Toast.LENGTH_LONG).show();


        // code to put listitems into recylerView
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(listItems,this);
        recyclerView.setAdapter(adapter);


        //-----------------------------------------------------------------------------------
        // Call API to find info for the "barCode" and then modify and append to list view
        StringRequest req = new StringRequest(URL, new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {

                Log.i("api",response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                users[] users = gson.fromJson(response , users[].class);
                updatedListItems.add( new ListItem(users[0].getLogin(),users[0].getNodeId()));
                Log.i("api","added to updated list");

                adapter = new MyAdapter(updatedListItems,getApplicationContext());
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Some error Occured",Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(req);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);


        Intent res = getIntent();
        String barCode = res.getStringExtra("barCode");

        addItemtoList(barCode);

    }
}
