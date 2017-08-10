package com.example.hyunyoungpark.imagedownloadasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    EditText selectiontext;
    ListView chooseImageList;
    String[] listofImages;
    ProgressBar downloadImageProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagedownload);
        selectiontext = (EditText) findViewById(R.id.urlselectionText);
        chooseImageList = (ListView) findViewById(R.id.chooseImageList);
        downloadImageProgress = (ProgressBar) findViewById(R.id.downloadProgress);
        listofImages = getResources().getStringArray(R.array.imageuris);
        chooseImageList.setOnItemClickListener(this);
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        chooseImageList.setAdapter(a);
        new MyTask1().execute();
    }

    public void downloadImage(View view) {
        if (selectiontext.getText().toString() != null
                && (selectiontext.getText().toString().length()) > 0) {
            // create instance of subClass (MyTask).
            // call method execute() on it and it accepts text read from textview as parameter.
            class MyTask extends AsyncTask<Void,Void,Void> {

                @Override
                protected void onPreExecute() {


                }

                @Override
                protected Void doInBackground(Void... voids) {
                    return null;
                }

                @Override
                protected void onProgressUpdate(Void...voids) {
                }

                @Override
                protected void onPostExecute(Void...voids) {

                }
            }

        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectiontext.setText(listofImages[position]);
    }

    class MyTask1 extends AsyncTask<String,Integer,Boolean> {
        ArrayAdapter<String> adpter;
        private int count=0;

        @Override
        protected void onPreExecute() {
            adpter = (ArrayAdapter<String>) listofImages.getAdapter();
            downloadImageProgress.setVisibility(View.VISIBLE);
        }

        @Override
        protected Boolean doInBackground(String... params) {

            for(String item: listofImages) {
                publishProgress(item);

                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Ceate an instance of URL, HttpURLConnection, InputStream, FileOutputStream,File class
            // Create a boolean variable successfull and set its intial value to false
            // if image download succesfully set it to true. return a boolean value of success
            // Write a code that download the image from internet
            // count how many bytes are downloded for that image and use this count to show the progress
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            //calculate the progress and show it on progressbar
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            Toast.makeText(MainActivity.this,"ALL ITEMS ADDED SUCCESFULLY",
                    Toast.LENGTH_LONG).show();
            downloadImageProgress.setVisibility(View.GONE);        }
    }



}