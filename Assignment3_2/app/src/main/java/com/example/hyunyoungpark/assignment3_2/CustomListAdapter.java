package com.example.hyunyoungpark.assignment3_2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;




public class CustomListAdapter extends ArrayAdapter {

    private final Activity context;
    private final Integer[] imageIDarray;
    private final String[] nameArray;


    public CustomListAdapter(Activity context, String[] nameArrayParam, Integer[] imageIDArrayParam) {
        super(context, R.layout.image_layout, nameArrayParam);


        this.context = context;
        this.imageIDarray = imageIDArrayParam;
        this.nameArray = nameArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.image_layout, null, true);

        TextView nameTextField = (TextView) rowView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageViewID);

        nameTextField.setText(nameArray[position]);
        imageView.setImageResource(imageIDarray[position]);

        return rowView;
    }
}