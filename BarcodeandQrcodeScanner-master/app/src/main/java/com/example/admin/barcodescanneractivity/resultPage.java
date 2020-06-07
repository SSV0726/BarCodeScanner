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

import java.util.ArrayList;
import java.util.List;

public class resultPage extends AppCompatActivity{

    public static TextView resulttextview;
    public static String scanned;

    Button scanbutton;

    private RecyclerView recyclerView;
    private  RecyclerView.Adapter adapter;
    public static List<ListItem>  listItems = new ArrayList<>();



    public void onScanPressed(View view){
        finish();
        startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        resulttextview = findViewById(R.id.barcodetextview);
        scanbutton = findViewById(R.id.scanbutton);


        Intent res = getIntent();
        String barCode = res.getStringExtra("barCode");
        Toast.makeText(this,barCode,Toast.LENGTH_LONG).show();

        listItems.add(new ListItem(barCode,"new Item"));
        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(listItems,this);
        recyclerView.setAdapter(adapter);



    }
}
