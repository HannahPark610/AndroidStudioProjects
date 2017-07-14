package com.example.hyunyoungpark.menuexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //메뉴버튼 처음 눌러졌을 때 실행되는 콜백메서드
        //메뉴버튼을 눌렀을 떄 보여줄 메뉴에 대해서 정의
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case (R.id.menu_bookmark):
            Toast.makeText(this,"setting is clicked", Toast.LENGTH_SHORT).show();
                break;
            case (R.id.menu_save):
            Toast.makeText(this,"Search is clicked", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.menu_search):
            Toast.makeText(this,"Help is clicked", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.menu_share):
            Toast.makeText(this,"About is clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
