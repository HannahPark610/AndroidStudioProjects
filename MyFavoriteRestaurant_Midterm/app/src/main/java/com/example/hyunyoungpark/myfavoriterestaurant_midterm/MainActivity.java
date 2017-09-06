package com.example.hyunyoungpark.myfavoriterestaurant_midterm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

//  need setExtra here
//    https://stackoverflow.com/questions/5265913/how-to-use-putextra-and-getextra-for-string-data
                emptyListView();
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                for (DataSnapshot snapshot : children) {
                    Store store = snapshot.getValue(Store.class);
                    data_store.add(store);
                    data_name.add(store.getName());
                }
//                Store store = dataSnapshot.getValue(Store.class);
//                data_store.add(store);
//                    String rname = String.valueOf(store.getName());
//                    data_name.add(rname);
             //   tv.setText("Restaurants List (" + data_store.size() + ")");
                setListView();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void emptyListView() {
        data_store.clear();
        data_name.clear();
    }

    public void setListView() {

        lv = (ListView) findViewById(R.id.listview);
        tv = (TextView) findViewById(R.id.tv);

        //read data from database just store name
        //add the store name in arraylist data_name
        // assign arraylist to adapter.


        tv.setText("Restaurants List (" + data_name.size() + ")");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data_name);
        lv.setAdapter(adapter);
        Log.d("size ", "no " + adapter.getCount());

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent = new Intent(MainActivity.this, MainActivity3.class);
                Log.d("size of list ", " i " + data_store.size());

                intent.putExtra("store_main3", data_store.get(i));
                startActivity(intent);
            }
        });

    }

    public void onClick(View v) {
        if (v.getId() == R.id.addStore) {
            intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivityForResult(intent, _REQ);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data_) {
        super.onActivityResult(requestCode, resultCode, data_);
        if (requestCode == _REQ) {
            if (resultCode == RESULT_STORE) {
                Store store = data_.getParcelableExtra("store");
                //FireBaseHelper.add(store);
                FireBaseHelper.add(store);
//                data_store.add(store);
//                data_name.add(store.name);
                adapter.notifyDataSetChanged();
            } else if (resultCode == RESULT_CANCLED) {

            }
        }
    }


}