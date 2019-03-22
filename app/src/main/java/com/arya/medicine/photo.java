package com.arya.medicine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class photo extends AppCompatActivity {

    Button sellBtn;
    RecyclerView items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        sellBtn = findViewById(R.id.sell_btn);
        items = findViewById(R.id.item_rv);

        sellBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(photo.this, upload.class));
                finish();
            }
        });
    }
}
