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

public class MainActivity extends AppCompatActivity {

    public static TextView resulttextview;
    public static String scanned;

    Button scanbutton;

    private RecyclerView recyclerView;
    private  RecyclerView.Adapter adapter;
    public static List<ListItem>  listItems = new ArrayList<>();



    public void onScanPressed(View view){

        startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));

//
//        Intent res = getIntent();
//        String barCode = res.getStringExtra("barCode");
//
//        Toast.makeText(this,barCode,Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resulttextview = findViewById(R.id.barcodetextview);
        scanbutton = findViewById(R.id.scanbutton);

//        scanbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
//            }
//        });


//---------------------------------------------------
//        // TO populate recyler view with dummy data
//        for(int i=0;i<10;i++){
//            listItems.add(new ListItem("head"+ (i+1) , "lorem ispum description ") );
//        }


        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(listItems,this);
        recyclerView.setAdapter(adapter);



    }
}
