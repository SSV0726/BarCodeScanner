package com.example.admin.barcodescanneractivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void onScanPressed(View view){
        startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
    }

    public void firestore(View view){
        //startActivity(new Intent(getApplicationContext(),addtofirebase.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("myLogs"," Inside Main Acitivity ");

    }
}
