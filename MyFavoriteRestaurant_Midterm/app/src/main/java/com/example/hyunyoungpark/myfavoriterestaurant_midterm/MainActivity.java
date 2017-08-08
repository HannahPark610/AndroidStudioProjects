package com.example.hyunyoungpark.myfavoriterestaurant_midterm;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int _REQ = 100;
    final int RESULT_STORE = 0;
    final int RESULT_CANCLED = 50;

    ListView lv;
    ArrayList<Store> data_store = new ArrayList<Store>();
    ArrayList<String> data_name = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    Store store;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListView();


    }
    public void setListView(){

        lv = (ListView)findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data_name);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent = new Intent(MainActivity.this, MainActivity3.class);
                intent.putExtra("store_main3", data_store.get(i));
                startActivity(intent);
            }
        });

      }

    public void onClick(View v){
        if(v.getId() == R.id.addStore){
            intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivityForResult(intent, _REQ);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data_) {
        super.onActivityResult(requestCode, resultCode, data_);
        if(requestCode == _REQ){
            if(resultCode ==  RESULT_STORE){
                Store store = data_.getParcelableExtra("store");
                data_store.add(store);
                data_name.add(store.name);
                adapter.notifyDataSetChanged();
            }
            else if(resultCode == RESULT_CANCLED){

            }
        }
    }


}