package com.example.hyunyoungpark.assignment3_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewitem);

        ListView listView=(ListView)findViewById(R.id.listviewitem);

        ArrayList<Listviewitem> data=new ArrayList<>();
        Listviewitem linearlayout=new Listviewitem(R.drawable.ic_face,"Linear Layout");
        Listviewitem relativelayout=new Listviewitem(R.drawable.ic_favorite,"Relative Layout");
        Listviewitem tablelayout=new Listviewitem(R.drawable.ic_grade,"Table Layout");
        Listviewitem framelayout=new Listviewitem(R.drawable.ic_pan_tool,"Frame Layout");
        Listviewitem listview1=new Listviewitem(R.drawable.ic_pets,"List View");
        Listviewitem gridlview1=new Listviewitem(R.drawable.ic_thumb_up,"Grid View");
        Listviewitem recyclerview1=new Listviewitem(R.drawable.ic_shopping,"Recycler View");

        data.add(linearlayout);
        data.add(relativelayout);
        data.add(tablelayout);
        data.add(framelayout);
        data.add(listview1);
        data.add(gridlview1);
        data.add(recyclerview1);

        ListviewAdapter adapter=new ListviewAdapter(this,R.layout.listviewitem,data);
        listView.setAdapter(adapter);


    }

        /** Called when the user clicks the Send button */
        public void sendMessage(View view) {
            Intent intent = new Intent(this, SubActivity.class);
            EditText editText = (EditText) findViewById(R.id.listviewitem);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }

        public void clicked1 (View v1){
            Intent intent = new Intent(getApplicationContext(), SubActivity.class);
            startActivity(intent);
        }
}