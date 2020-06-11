package com.example.admin.barcodescanneractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class checkout extends AppCompatActivity {

    public void onPayPressed(View view){

        //Toast.makeText(this , "Payment Activity Next ", Toast.LENGTH_SHORT).show();
        Intent success = new Intent(getApplicationContext(), com.example.admin.barcodescanneractivity.success.class);
        startActivity(success);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Log.i("mylogs", "inside checkout Activity ");
        ImageView proceed = findViewById(R.id.proceedtopay);



        Intent prev = getIntent();
        String finalPrice = prev.getStringExtra("finalPrice");



        TextView amount = findViewById(R.id.amount);
        amount.setText(finalPrice + " ₹ ");
    }
}
