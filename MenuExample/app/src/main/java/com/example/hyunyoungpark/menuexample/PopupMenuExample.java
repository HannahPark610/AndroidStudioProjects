package com.example.hyunyoungpark.menuexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class PopupMenuExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_menu_example);
    }

    public void showPopUpMenu(View v){
        PopupMenu m= new PopupMenu(this, v);
        MenuInflater i = m.getMenuInflater();
        i.inflate(R.menu.menu_main,m.getMenu());
        m.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menu_bookmark:
                        Toast.makeText(PopupMenuExample.this, "Bookmark is Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu_save:
                        Toast.makeText(PopupMenuExample.this, "Save is Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu_search:
                        Toast.makeText(PopupMenuExample.this, "Search is Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu_share:
                        Toast.makeText(PopupMenuExample.this, "Share is Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu_delete:
                        Toast.makeText(PopupMenuExample.this, "Delete is Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu_preferences:
                        Toast.makeText(PopupMenuExample.this, "Preferences is Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });



        m.show();//showing popup menu
    }




}
