package com.example.hyunyoungpark.action;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static com.example.hyunyoungpark.action.R.layout.activity_main;

public class MainActivity extends AppCompatActivity
        implements GreenAdapter.ListItemClickListener {

    private static final int LIST_COUNT = 100;
    private GreenAdapter mAdapter;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        rv = (RecyclerView) findViewById(R.id.rv1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);
        mAdapter = new GreenAdapter(LIST_COUNT,this);
        rv.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        else if(id == R.id.action_refresh) {
            mAdapter = new GreenAdapter(LIST_COUNT,this);
            rv.setAdapter(mAdapter);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListItemClick(int position) {
        Toast.makeText(this,"Item # "+ position+" is clicked",
                Toast.LENGTH_SHORT).show();
    }
}
