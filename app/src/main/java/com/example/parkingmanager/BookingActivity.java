package com.example.parkingmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class BookingActivity extends AppCompatActivity {

    private ImageView A1, A2, B1, B2, C1,C2, D1, D2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);


        A1 = (ImageView) findViewById(R.id.A1);
        A2 = (ImageView) findViewById(R.id.A2);
        B1 = (ImageView) findViewById(R.id.B1);
        B2 = (ImageView) findViewById(R.id.B2);
        C1 = (ImageView) findViewById(R.id.C1);
        C2 = (ImageView) findViewById(R.id.C2);
        D1 = (ImageView) findViewById(R.id.D1);
        D2 = (ImageView) findViewById(R.id.D2);



        C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookingActivity.this, BkActivity.class);
                startActivity(intent);
            }
        });

    }
}