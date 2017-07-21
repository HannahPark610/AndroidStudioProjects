package com.example.hyunyoungpark.action;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by hyunyoungpark on 2017-07-19.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    private List<Movie> movie_list;
    private static int viewHolderCount;
    int lastPosition = -1;
    CardView cv;
    boolean[] checkBoxState;


    public MoviesAdapter(List<Movie> movie_list) {

        this.movie_list = movie_list;
        checkBoxState = new boolean[movie_list.size()];
        viewHolderCount = 0;
    }

    private void setAnimation(View view, int position) {
        Context c = view.getContext(); if(position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(c,android.R.anim.slide_in_left);
            view.startAnimation(animation);
            lastPosition = position; }
    }

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f); anim.setDuration(1000);
        view.startAnimation(anim);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.movie_list_row;
        LayoutInflater inflater = LayoutInflater.from(context);

        boolean shouldAttachToParentImmediately = false;
        View view;
        view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;

    }

    //바인드뷰홀더란 : 재활용 되는 뷰가 호출하여 실행되는 메소드, 뷰 홀더를 전달하고 어댑터는 position 의 데이터를 결합시킵니다
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Movie movie = movie_list.get(position);

        holder.listMovieView1.setText(movie.getTitle());
        holder.listMovieView2.setText(movie.getGenre());
        holder.listMovieView3.setText(movie.getYear());
        holder.movieCheck.setChecked(movie_list.get(position).isSelected());

        holder.listMovieView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "you have clicked an item: ", Toast.LENGTH_SHORT).show();
            }
        });
        holder.listMovieView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "you have clicked an item: ", Toast.LENGTH_SHORT).show();
            }
        });
        holder.listMovieView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "you have clicked an item: ", Toast.LENGTH_SHORT).show();
            }
        });




        holder.movieCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movie_list.get(position).setSelected(true);
            }
        });

        setAnimation(holder.itemView, position);
        setFadeAnimation (holder.itemView);
    }

    @Override
    public int getItemCount() {

        return movie_list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView listMovieView1;
        TextView listMovieView2;
        TextView listMovieView3;
        public CheckBox movieCheck;

        public MyViewHolder(View view) {

            super(view);
            cv = (CardView) view.findViewById(R.id.cv);

            listMovieView1 = (TextView) view.findViewById(R.id.text1);
            listMovieView2 = (TextView) view.findViewById(R.id.text2);
            listMovieView3 = (TextView) view.findViewById(R.id.text3);

            movieCheck = (CheckBox) view.findViewById(R.id.checkBox);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "you have clicked an item: ", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
