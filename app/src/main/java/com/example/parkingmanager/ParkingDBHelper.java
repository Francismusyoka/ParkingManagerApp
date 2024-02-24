package com.example.parkingmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ParkingDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "ParkingBookings.db";

    public ParkingDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE parking_bookings (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "slot TEXT," +
                "name TEXT," +
                "car_number TEXT," +
                "booking_time TEXT," +
                "status INTEGER DEFAULT 0" + // 0 for available, 1 for booked
                ")");

        // Populate the parking slots table
        for (char c = 'A'; c <= 'D'; c++) {
            for (int i = 1; i <= 9; i++) {
                String slot = String.format("%c%d", c, i);
                ContentValues values = new ContentValues();
                values.put("slot", slot);
                db.insert("parking_bookings", null, values);
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS parking_bookings");
        onCreate(db);
    }

    public boolean bookParkingSlot(String slot, String name, String carNumber, String bookingTime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("car_number", carNumber);
        values.put("booking_time", bookingTime);
        values.put("status", 1); // Mark slot as booked
        int updatedRows = db.update("parking_bookings", values, "slot = ? AND status = 0", new String[]{slot});
        return updatedRows > 0;
    }

    public boolean cancelParkingBooking(String slot) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "");
        values.put("car_number", "");
        values.put("booking_time", "");
        values.put("status", 0); // Mark slot as available
        int updatedRows = db.update("parking_bookings", values, "slot = ?", new String[]{slot});
        return updatedRows > 0;
    }

    public Cursor getAllParkingBookings() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM parking_bookings", null);
    }

    public boolean isSlotAvailable(String slot) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM parking_bookings WHERE slot=? AND status=0", new String[]{slot});
        return cursor.getCount() > 0;
    }


}
