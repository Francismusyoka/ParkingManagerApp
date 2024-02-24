package com.example.parkingmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.parkingmanager.R.id;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomepageActivity extends AppCompatActivity {

    private CardView library, lbb, spd, eca, bikes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        library = (CardView) findViewById(R.id.library);
        spd = (CardView) findViewById(R.id.spd);
        lbb = (CardView) findViewById(R.id.lbb);
        eca = (CardView) findViewById(id.eca);
        bikes = (CardView) findViewById(id.bikes);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.currentdate);
        textViewDate.setText(currentDate);

        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, BkActivity.class);
                startActivity(intent);
            }
        });

        spd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, BkActivity.class);
                startActivity(intent);
            }
        });

        lbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, BkActivity.class);
                startActivity(intent);
            }
        });

        eca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, BkActivity.class);
                startActivity(intent);
            }
        });

        bikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, BkActivity.class);
                startActivity(intent);
            }
        });

    }
}