package com.example.admin.barcodescanneractivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    public void onScanPressed(View view){
        startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
    }

    public void firestore(View view){
        startActivity(new Intent(getApplicationContext(),addtofirebase.class));
    }

    public void allProducts(View view){
        Log.i("mylogs","allproducts button pressed ");
        startActivity(new Intent(getApplicationContext(),allProducts.class));
    }

    public void onblescanclick(View view){

        Button bigbazzar = findViewById(R.id.bigbazaar);
        bigbazzar.setVisibility(View.VISIBLE);

        ImageView blescan = findViewById(R.id.blescan);
        Glide.with(getApplicationContext()).load(R.raw.whiteimage).into(blescan);
    }

    public void onbigbazaarclick(View view){


        Button bigbazzar = findViewById(R.id.bigbazaar);
        bigbazzar.setVisibility(View.INVISIBLE);

        ImageView blescan = findViewById(R.id.blescan);
        blescan.setVisibility(View.INVISIBLE);

        ImageView mainscan = findViewById(R.id.mainscan);
        mainscan.setVisibility(View.VISIBLE);
        Glide.with(getApplicationContext()).asGif().load(R.raw.mainactivity).into(mainscan);

        LinearLayout ll = findViewById(R.id.linearLayout);
        ll.setVisibility(View.VISIBLE);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("myLogs"," Inside Main Acitivity ");


        ConstraintLayout parent = findViewById(R.id.parentMain);
        ImageView blescan = findViewById(R.id.blescan);
        Glide.with(getApplicationContext()).asGif().load(R.raw.search).into(blescan);


    }
}
