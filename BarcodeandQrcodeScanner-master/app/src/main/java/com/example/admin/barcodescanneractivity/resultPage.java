package com.example.admin.barcodescanneractivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LauncherActivity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

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
    private static final String URL = "https://barcodeapi.azurewebsites.net/api/barcodes/";


    public void onScanPressed(View view){
        finish();
        startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
    }

    public void onCheckoutPressed(View view){

        int price = 0 ;
        for(ListItem it : updatedListItems){
            price += it.getPrice()*it.getCount();
        }

        Intent checkout = new Intent(this,checkout.class);
        checkout.putExtra("finalPrice" , Integer.toString(price));
        Log.i("mylogs"," on checkout presses " + Integer.toString(price));
        startActivity(checkout);
    }


//    public void updateFinalPrice(){
//
//        int price = 0 ;
//        for(ListItem it : updatedListItems){
//            price += it.getPrice()*it.getCount();
//        }
//
//        TextView finalPrice = findViewById(R.id.finalPrice);
//        finalPrice.setText(Integer.toString(price));
//    }

    public void addItemtoList(String barCode){

        updatedListItems.add(new ListItem(barCode,"Item not added in database",0,1,"loading"));
        Toast.makeText(this,barCode,Toast.LENGTH_LONG).show();


        // code to put listitems into recylerView
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(updatedListItems,this);
        recyclerView.setAdapter(adapter);


        //-----------------------------------------------------------------------------------
        // Call API to find info for the "barCode" and then modify and append to list view
        String completeURL = URL + barCode;
        Log.i("mylogs",completeURL);


        JsonObjectRequest jobjreq = new JsonObjectRequest(Request.Method.GET, completeURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i("mylogs",response.toString());
                try {

                    updatedListItems.remove(updatedListItems.size() - 1);
                    updatedListItems.add( new ListItem(response.getString("name"),response.getString("desc"),response.getInt("price"),1,response.getString("imageUrl")));
                    Log.i("mylogs","added to updated list");
                    adapter = new MyAdapter(updatedListItems,getApplicationContext());
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.i("mylogs","we got response but error while parsing in try catch ");
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("mylogs","some error occured");
            }
        });

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(jobjreq);
        //------------------------------------------------------------------------------------------
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
