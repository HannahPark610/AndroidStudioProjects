package com.example.hyunyoungpark.assignment3;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        TextView tv;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.context_menu_example);
            tv = (TextView)findViewById(R.id.tv_context);
            registerForContextMenu(tv);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Drawable num_icon = getResources().getDrawable(R.drawable.ic_face);
        menu.add("Face").setIcon(num_icon);  //setShowAsAction(1);
        menu.add("Favorite").setIcon(R.drawable.ic_favorite);
        menu.add("Star").setIcon(R.drawable.ic_grade);


        return true;
    }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater mi = getMenuInflater();
            mi.inflate(R.menu.menu_main,menu);
        }

        @Override
        public boolean onContextItemSelected(MenuItem item) {
            switch (item.getItemId()) {

                case (R.id.menu_face):
                    Toast.makeText(this,"Face is clicked", Toast.LENGTH_SHORT).show();
                    break;
                case (R.id.menu_favorite):
                    Toast.makeText(this,"Favorite is clicked", Toast.LENGTH_SHORT).show();
                    break;
                case(R.id.menu_grade):
                    Toast.makeText(this,"Grade is clicked", Toast.LENGTH_SHORT).show();
                    break;
                case(R.id.menu_pan_tool):
                    Toast.makeText(this,"Pan is clicked", Toast.LENGTH_SHORT).show();
                    break;
            }
            return super.onOptionsItemSelected(item);
        }
}