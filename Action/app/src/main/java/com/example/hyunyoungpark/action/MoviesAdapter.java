package com.example.hyunyoungpark.action;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hyunyoungpark on 2017-07-19.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    private List<Movie> movie_list;
    private static int viewHolderCount;


    public MoviesAdapter(List<Movie> movie_list) {
        this.movie_list = movie_list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.movie_list_row;
        LayoutInflater inflater = LayoutInflater.from(context);

        boolean shouldAttachToParentImmediately = false;
        // View view =inflater.from(context).inflate(R.layout.number_list_item,shouldAttachToParentImmediately);
        View view;
        view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Movie movie = movie_list.get(position);

        holder.listMovieView1.setText(movie.getTitle());
        holder.listMovieView2.setText(movie.getTitle());
        holder.listMovieView3.setText(movie.getTitle());

    }

    @Override
    public int getItemCount() {

        return movie_list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView listMovieView1;
        TextView listMovieView2;
        TextView listMovieView3;

        MyViewHolder(View view) {

            super(view);

            listMovieView1 = (TextView) itemView.findViewById(R.id.text1);
            listMovieView2 = (TextView) itemView.findViewById(R.id.text2);
            listMovieView3 = (TextView) itemView.findViewById(R.id.text3);

            viewHolderCount++;
        }

    }
}
