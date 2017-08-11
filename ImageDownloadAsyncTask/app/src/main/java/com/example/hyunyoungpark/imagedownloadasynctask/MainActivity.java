package com.example.hyunyoungpark.imagedownloadasynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    }

    public void downloadImage(View view) {
        if (selectiontext.getText().toString() != null
                && (selectiontext.getText().toString().length()) > 0) {
            // create instance of subClass (MyTask).
            MyTask1 task1 = new MyTask1();
            // call method execute() on it and it accepts text read from textview as parameter.
            task1.execute(selectiontext.getText().toString());

        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectiontext.setText(listofImages[position]);
    }

    class MyTask1 extends AsyncTask<String,Integer,Boolean> {


        @Override
        protected void onPreExecute() {
            downloadImageProgress.setVisibility(View.VISIBLE);
        }

        @Override
        protected Boolean doInBackground(String... params) {

            // Ceate an instance of URL, HttpURLConnection, InputStream, FileOutputStream,File class

            URL url = null;
            HttpURLConnection urlCon = null;
            InputStream input = null;
            FileOutputStream output = null;
            String saveFileName = new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());
            File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile() + "/" + saveFileName);
            boolean success = false;
            try {
                url = new URL(params[0].toString());
                urlCon = (HttpURLConnection) url.openConnection();
                urlCon.connect();

                // Create a boolean variable successfull and set its intial value to false

                if(urlCon.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return false;
                }
                int fileLength = urlCon.getContentLength();

                input = urlCon.getInputStream();
                output = openFileOutput(file.getName(), Context.MODE_APPEND);

                byte[] b = new byte[2048];
                int length;
                long total = 0;

                while ((length = input.read(b)) != -1) {
                    total += length;
                    if(fileLength > 0) {
                        publishProgress((int)(total * 100/ fileLength));
                    }
                    output.write(b, 0, length);
                }
                input.close();
                output.close();
                success = true;

            } catch (Exception e) {
                e.printStackTrace();
                success = false;
            }

                // if image download succesfully set it to true. return a boolean value of success
                // Write a code that download the image from internet
                // count how many bytes are downloded for that image and use this count to show the progress
            return success;

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //calculate the progress and show it on progressbar
            downloadImageProgress.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            //set visibility of progessbar to gone
            downloadImageProgress.setVisibility(View.GONE);
        }
    }
}