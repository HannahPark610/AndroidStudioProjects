package com.example.hyunyoungpark.action;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by hyunyoungpark on 2017-07-27.
 */

public class DataTimePicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);

        Button buttonTime = (Button) findViewById(R.id.buttonTime);
        Button buttonDate = (Button) findViewById(R.id.buttonDate);

        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.buttonTime:
                        break;
                    case R.id.buttonDate:
                        break;
                }
            }
        };

        buttonTime.setOnClickListener(listener);
        buttonDate.setOnClickListener(listener);

    public void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
