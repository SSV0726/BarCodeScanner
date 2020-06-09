package com.example.admin.barcodescanneractivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class addtofirebase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtofirebase);

  FirebaseFirestore db = FirebaseFirestore.getInstance();



        Map<String, Object> barcode = new HashMap<>();
        barcode.put("idd", "1");
        barcode.put("barcode", "8902519009845");
        barcode.put("name", "Classmate Long Notebook");
        barcode.put("price", 75);
        barcode.put("imageURL", "https://images-na.ssl-images-amazon.com/images/I/61WeQOf7d6L._SX466_.jpg");

        // Add a new document with a generated ID
        db.collection("barcodes")
                .add(barcode)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"Successfully uploaded barcode",Toast.LENGTH_SHORT).show();
                        Log.d("mylog", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("mylog", "Error adding document", e);
                    }
                });
    }
}
