package com.example.hyunyoungpark.myfavoriterestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContentActivity1 extends AppCompatActivity {
    EditText etName, etTel, etMenu1, etMenu2, etMenu3, etaddr;

    RadioButton radio1, radio2, radio3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("My Favorite Restaurant");

        init();
    }

    void init(){
        etName = (EditText) findViewById(R.id.etname);

        etTel = (EditText) findViewById(R.id.ettel);

        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio2 = (RadioButton) findViewById(R.id.radio2);
        radio3 = (RadioButton) findViewById(R.id.radio3);

        etMenu1 = (EditText) findViewById(R.id.etmenu1);
        etMenu2 = (EditText) findViewById(R.id.etmenu2);
        etMenu3 = (EditText) findViewById(R.id.etmenu3);

        etaddr = (EditText) findViewById(R.id.etaddr);



    }

    public void onClick(View v){
        if(v.getId() == R.id.btnCancel){
            finish();
        }else if(v.getId() == R.id.btnAdd){
            Intent intent = new Intent();

            int n;

            if(radio1.isChecked())  n = 1;
            else if(radio2.isChecked()) n = 2;
            else    n = 3;

            String name =etName.getText().toString();
            String tel = etTel.getText().toString();
            String[] menu = {etMenu1.getText().toString(), etMenu2.getText().toString(), etMenu3.getText().toString()};
            String h = etaddr.getText().toString();

            restaurant temp = new restaurant(name, h, tel, getTime(), menu, n);

            intent.putExtra("restaurant", temp);
            setResult(RESULT_OK, intent);
            finish();

        }
    }
    String getTime(){
        String time;

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        time = sdf.format(date);

        return time;
    }
}
