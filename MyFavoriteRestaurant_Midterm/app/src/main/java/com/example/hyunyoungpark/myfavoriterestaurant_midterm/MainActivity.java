package com.example.hyunyoungpark.myfavoriterestaurant_midterm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int _REQ = 100;
    final int RESULT_STORE = 0;
    final int RESULT_CANCLED = 50;

    ListView lv;
    TextView tv;
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

        FireBaseHelper.getDatabaseReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Store store = dataSnapshot.getValue(Store.class);
                data_store.add(store);
              //  data_name.add(store.name);
                tv.setText("Restaurants List (" + data_store.size() + ")");
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void setListView(){

        lv = (ListView)findViewById(R.id.listview);
        tv = (TextView)findViewById(R.id.tv);
        //read data from database just store name
        //add the store name in arraylist data_name
        // assign arraylist to adapter
        tv.setText("Restaurants List (0)");
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
                //FireBaseHelper.add(store);
                FireBaseHelper.add(store);
//                data_store.add(store);
//                data_name.add(store.name);
                adapter.notifyDataSetChanged();
            }
            else if(resultCode == RESULT_CANCLED){

            }
        }
    }


}