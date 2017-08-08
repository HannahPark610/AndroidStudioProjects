package com.example.hyunyoungpark.myfavoriterestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class RestaurantAdapter extends BaseAdapter {

    private Context context;
    private List<restaurant> restaurantList = new ArrayList<>();

    public RestaurantAdapter(Context context, restaurant restaurant) {
        if (restaurant != null) {
            this.restaurantList.add(restaurant);
        }
        this.context = context;

    }

    @Override
    public int getCount() {
        return restaurantList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View exampleView;
        ListView listView;
        TextView titleTextView;
        TextView typeTextView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        if(view == null) {
            view = inflater.inflate(R.layout.activity_main2, parent, false);
            listView = (ListView)view.findViewById(R.id.listview);
            titleTextView = (TextView)listView.findViewById(R.id.restaurant_name);
            typeTextView = (TextView)listView.findViewById(R.id.restaurant_type);

            titleTextView.setText(restaurantList.get(position).getName());
            typeTextView.setText(restaurantList.get(position).getType());
        }else {
         //   view = (View)view;
        }
        return view;

    }
}
