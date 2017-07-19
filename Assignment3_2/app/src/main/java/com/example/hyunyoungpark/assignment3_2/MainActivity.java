package com.example.hyunyoungpark.assignment3_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomListAdapter whatever = new CustomListAdapter(this, nameArray, imageArray);
        listView = (ListView) findViewById(R.id.listviewID);
        listView.setAdapter(whatever);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                String message = nameArray[position];
                intent.putExtra("Menu", message);
                startActivity(intent);

            }
        });

    }

    String[] nameArray = {"LinearLayout", "RelativeLayout", "TableLayout", "FrameLayout", "ListView", "GridView", "RecyclerView"};
    Integer[] imageArray = {R.drawable.ic_face,
            R.drawable.ic_favorite,
            R.drawable.ic_grade,
            R.drawable.ic_pan_tool,
            R.drawable.ic_pets,
            R.drawable.ic_shopping,
            R.drawable.ic_thumb_up};


}