package com.example.hyunyoungpark.action;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


/**
 * Created by hyunyoungpark on 2017-07-27.
 */

public class DataTimePicker extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner, spinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);

        Spinner spinner = (Spinner) findViewById(R.id.sp_planets);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(DataTimePicker.this,R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

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
    }

    public void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
