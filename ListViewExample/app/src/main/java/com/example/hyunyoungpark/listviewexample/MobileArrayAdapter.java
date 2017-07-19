package com.example.hyunyoungpark.listviewexample;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class MobileArrayAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;

    //Create a constructor
    public MobileArrayAdapter(Context context, String[] values) {
        super(context, R.layout.activity_listmobile_ex, values);
        this.context = context;
        this.values = values;
    }
    //CALL A SERVICE TO CREATE A View DYNAMICALLY

    @Override
    public View getView(int position,View convertView,  ViewGroup parent) {
        LayoutInflater l = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = l.inflate(R.layout.activity_listmobile_ex,parent);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        textView.setText(values[position]);
        //used to change icon based on Mobile OS
        String s = values[position];
        if(s.equals("Android"))
            imageView.setImageResource(R.drawable.android_logo);
        else if(s.equals("iOS"))
            imageView.setImageResource(R.drawable.ios_logo);
        else if (s.equals("Blackberry"))
            imageView.setImageResource(R.drawable.blackberry_logo);
        else
            imageView.setImageResource(R.drawable.android_logo);

        return rowView;

    }

}
