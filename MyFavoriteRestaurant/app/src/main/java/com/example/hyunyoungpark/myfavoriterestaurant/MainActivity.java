package com.example.hyunyoungpark.myfavoriterestaurant;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;

    ArrayAdapter<String> adapter;

    TextView tv;

    int Addition = 1;

    ArrayList<restaurant> storage = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();


    public Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Favorite Restaurant");

        init();
    }


    void init(){
        startButton=(Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent firstButton = new Intent(MainActivity.this,ContentActivity1.class);

                startActivity(firstButton);
            }
        });


        listview = (ListView)findViewById(R.id.listview);
        tv = (TextView)findViewById(R.id.tv);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, title);

        listview.setAdapter(adapter);

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                final int position = i;
                dlg.setTitle("Delete")
                        .setMessage("Are you sure delete it?")
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                title.remove(position);
                                storage.remove(position);
                                adapter.notifyDataSetChanged();
                                tv.setText("My Favorite Restaurant List("+title.size()+")");
                            }
                        }).show();
                return true;
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ContentActivity2.class);

                intent.putExtra("restaurant", storage.get(i));

                startActivity(intent);
            }
        });
    }

    public void onClick(View v){
        Intent intent = new Intent(this,ContentActivity1.class);

        startActivityForResult(intent, Addition);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Addition){
            if(resultCode == RESULT_OK){
                restaurant r = data.getParcelableExtra("restaurant");
                title.add(r.getName());
                storage.add(r);
                adapter.notifyDataSetChanged();
                tv.setText("My Favorite Restaurants List("+title.size()+")");
            }
        }
    }
}