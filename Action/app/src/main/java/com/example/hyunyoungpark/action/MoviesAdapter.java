package com.example.hyunyoungpark.action;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    private List<Movie> movie_list;
    private static int viewHolderCount;
    CardView cv;
    boolean[] checkBoxState;


    public MoviesAdapter(List<Movie> movie_list) {

        this.movie_list = movie_list;
        checkBoxState = new boolean[movie_list.size()];
        viewHolderCount = 0;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(itemview);
        int bg = ColorUtils.getViewHolderBackgroundColorFromInstance(context, viewHolderCount);
        viewHolder.itemView.setBackgroundColor(bg);
        viewHolderCount++;
        return viewHolder;
    }

    //바인드뷰홀더란 : 재활용 되는 뷰가 호출하여 실행되는 메소드, 뷰 홀더를 전달하고 어댑터는 position 의 데이터를 결합시킵니다
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Movie movie = movie_list.get(position);

        holder.listMovieView1.setText(movie.getTitle());
        holder.listMovieView2.setText(movie.getGenre());
        holder.listMovieView3.setText(movie.getYear());
        holder.moviePhoto.setImageResource(movie.getThumbnail());
        holder.movieCheck.setChecked(movie_list.get(position).isSelected());
        holder.movieCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie_list.get(position).setSelected(true);
            }
        });
        setFadeAnimation(holder.itemView);
    }

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000);
        view.startAnimation(anim);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
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
        public ImageView moviePhoto;

        public MyViewHolder(View view) {

            super(view);
            cv = (CardView) view.findViewById(R.id.cv);

            listMovieView1 = (TextView) view.findViewById(R.id.text1);
            listMovieView2 = (TextView) view.findViewById(R.id.text2);
            listMovieView3 = (TextView) view.findViewById(R.id.text3);
            moviePhoto = (ImageView)view.findViewById(R.id.movie_image);
            movieCheck = (CheckBox) view.findViewById(R.id.checkBox);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickedPosition = getAdapterPosition();
                    Toast.makeText(v.getContext(), "you have clicked an item: ", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
