package com.arya.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class photo extends AppCompatActivity {

    Button sellBtn;
    RecyclerView items;
    List<med_detail> medList = new ArrayList<>();
    MedAdapter medAdapter;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        sellBtn = findViewById(R.id.sell_btn);
        items = findViewById(R.id.item_rv);
        medAdapter = new MedAdapter(medList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        items.setLayoutManager(layoutManager);
        items.setAdapter(medAdapter);

        sellBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(photo.this, upload.class));
                finish();
            }
        });

        prepareData();
    }

    private void prepareData() {
        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        ValueEventListener medListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                med_detail med = dataSnapshot.getValue(med_detail.class);
                Log.d("nuclode", med.getDetail());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("nuclode", databaseError.getMessage());
            }
        };
        db.addValueEventListener(medListener);
    }
}
