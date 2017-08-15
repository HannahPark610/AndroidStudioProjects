package com.example.hyunyoungpark.bookdatabsedemo;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db.addBook(new Book("WINGS OF FIRE","APJ KALAM"));
        db.addBook(new Book("THE WAVES","VIRGINIA WOOLF"));
        Toast.makeText(this, "DATABASE CREATED SUCCESFULLY",
                Toast.LENGTH_LONG).show();
    }
}