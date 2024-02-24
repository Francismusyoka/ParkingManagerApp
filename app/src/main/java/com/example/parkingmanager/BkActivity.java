package com.example.parkingmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BkActivity extends AppCompatActivity {

    private RadioButton optionlib, optionspd, optionlbb, optioneca, optionbikes;
    private EditText name, phoneno, car_reg, parkingslot;
    private Button btnsubmit, btnbookdetails;
    private ParkingDBHelper parkinghelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bk);

        optionlib = (RadioButton) findViewById(R.id.optionlib);
        optioneca = (RadioButton) findViewById(R.id.optioneca);
        optionlbb = (RadioButton) findViewById(R.id.optionlbb);
        optionspd = (RadioButton) findViewById(R.id.optionspd);
        optionbikes = (RadioButton) findViewById(R.id.optionbikes);

        name = (EditText) findViewById(R.id.name);
        car_reg = (EditText) findViewById(R.id.car_reg);
        phoneno = (EditText) findViewById(R.id.phoneno);
        parkingslot = (EditText) findViewById(R.id.parkingslot);


        btnsubmit = (Button) findViewById(R.id.btnsubmit);
        btnbookdetails = (Button) findViewById(R.id.btnbookdetails);
        parkinghelper = new ParkingDBHelper(this);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String names = name.getText().toString();
                String carnumber = car_reg.getText().toString();
                String slot = parkingslot.getText().toString();

                if (names.isEmpty() || carnumber.isEmpty() || slot.isEmpty()) {
                    Toast.makeText(BkActivity.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!parkinghelper.isSlotAvailable(slot)) {
                    Toast.makeText(BkActivity.this, "Slot " + slot + " is not available", Toast.LENGTH_SHORT).show();
                    return;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                String bookingTime = sdf.format(new Date());

                boolean booked = parkinghelper.bookParkingSlot(slot, names, carnumber, bookingTime);
                if (booked) {
                    Toast.makeText(BkActivity.this, "Parking slot booked successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BkActivity.this, "Failed to book parking slot", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnbookdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

}