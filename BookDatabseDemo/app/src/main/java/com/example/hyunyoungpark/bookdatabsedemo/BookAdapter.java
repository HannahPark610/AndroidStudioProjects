package com.example.hyunyoungpark.bookdatabsedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class BookAdapter extends BaseAdapter {
    Context context;
    List<Integer> id =  new ArrayList<Integer>();
    List<String> title = new ArrayList<String>();
    List<String> author = new ArrayList<String>();
    private static LayoutInflater inflater=null;

    public BookAdapter(MainActivity mainActivity, List<Integer> id, List<String> title, List<String> author)
    {
        this.title = title;
        this.author = author;
        this.id= id;
        context = mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return id.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //inner class for row layout
    public class Holder{
        TextView booktitle, bookauthor, bookID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        // Loading a view or attaching a view
        View rowView =inflater.inflate(R.layout.row_layout,null);
        // binding of views to variables
        holder.bookID = (TextView) rowView.findViewById(R.id.text_id);
        holder.booktitle = (TextView) rowView.findViewById(R.id.text_title);
        holder.bookauthor = (TextView)rowView.findViewById(R.id.text_author);
        holder.bookID.setText(id.get(position).toString());
        holder.booktitle.setText(title.get(position));
        holder.bookauthor.setText(author.get(position));
        return  rowView;
    }

}