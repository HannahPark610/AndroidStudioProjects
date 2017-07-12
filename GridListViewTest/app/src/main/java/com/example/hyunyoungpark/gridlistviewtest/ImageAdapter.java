package com.example.hyunyoungpark.gridlistviewtest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{


    private Context c;
    //constructor
    public ImageAdapter(Context c)
    {
        this.c = c;
    }
    //create an array for Images
    private  Integer[] mImages =
            {
                    R.drawable.android_logo,
                    R.drawable.blackberry_logo,
                    R.drawable.ios_logo,
                    R.drawable.windowsmobile_logo,
                    R.drawable.android_logo,
                    R.drawable.blackberry_logo,
                    R.drawable.ios_logo,
                    R.drawable.windowsmobile_logo,
                    R.drawable.android_logo,
                    R.drawable.blackberry_logo,
                    R.drawable.ios_logo,
                    R.drawable.windowsmobile_logo

            };

    //gives you the count of item in your collection
    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    //Create a new Imageview for ech item referenced by adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv;
        if(convertView==null){
            iv = new ImageView(c);
            iv.setLayoutParams(new GridView.LayoutParams(200,200));
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iv.setPadding(8,8,8,8);
        }
        else
        {
            iv = (ImageView) convertView;
        }
        iv.setImageResource(mImages[position]);
        return iv;
    }
}

