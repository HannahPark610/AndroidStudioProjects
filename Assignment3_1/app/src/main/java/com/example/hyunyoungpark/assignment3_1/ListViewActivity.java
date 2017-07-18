package com.example.hyunyoungpark.assignment3_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;


public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewitem);

        ListView listView=(ListView)findViewById(R.id.listviewitem);

        ArrayList<ListViewItem> data=new ArrayList<>();
        ListViewItem linearlayout=new ListViewItem(R.drawable.ic_face,"Linear Layout");
        ListViewItem relativelayout=new ListViewItem(R.drawable.ic_favorite,"Relative Layout");
        ListViewItem tablelayout=new ListViewItem(R.drawable.ic_grade,"Table Layout");
        ListViewItem framelayout=new ListViewItem(R.drawable.ic_pan_tool,"Frame Layout");
        ListViewItem listview1=new ListViewItem(R.drawable.ic_pets,"List View");
        ListViewItem gridview1=new ListViewItem(R.drawable.ic_thumb_up,"Grid View");
        ListViewItem recyclerview1=new ListViewItem(R.drawable.ic_shopping,"Recycler View");

        data.add(linearlayout);
        data.add(relativelayout);
        data.add(tablelayout);
        data.add(framelayout);
        data.add(listview1);
        data.add(gridview1);
        data.add(recyclerview1);

        ListViewAdapter adapter=new ListViewAdapter(this,R.layout.listviewitem,data);
        listView.setAdapter(adapter);


    }

        /** Called when the user clicks the Send button */
        public void clicked1 (View v1){
            Intent intent = new Intent(getApplicationContext(), SubActivity.class);
            startActivity(intent);
        }
}