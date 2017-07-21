package com.example.hyunyoungpark.action;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private int[] selectedMovies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        prepareMovieData();

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void prepareMovieData() {
        Movie movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);
        movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);
        movie = new Movie("Titanic", "Romantic-Disaster-Drama", "1997");
        movieList.add(movie);
        movie = new Movie("Toy Story", "Animation, Buddy-Comedy", "2010");
        movieList.add(movie);
        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);
        movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);
        movie = new Movie("Titanic", "Romantic-Disaster-Drama", "1997");
        movieList.add(movie);
        movie = new Movie("Toy Story", "Animation, Buddy-Comedy", "2010");
        movieList.add(movie);
        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);
        movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);
        movie = new Movie("Titanic", "Romantic-Disaster-Drama", "1997");
        movieList.add(movie);
        movie = new Movie("Toy Story", "Animation, Buddy-Comedy", "2010");
        movieList.add(movie);
        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);
        movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);
        movie = new Movie("Titanic", "Romantic-Disaster-Drama", "1997");
        movieList.add(movie);
        movie = new Movie("Toy Story", "Animation, Buddy-Comedy", "2010");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }

    public void selectAll(View view) {
        for (Movie m : movieList) {
            m.setSelected(true);
            mAdapter.notifyDataSetChanged();
        }
    }

    public void clearAll(View view) {
        for (Movie m : movieList) {
            m.setSelected(false);
            mAdapter.notifyDataSetChanged();
        }
    }

    public void deleteMovie(View view) {
         for (int i=0;i<movieList.size();i++) {
         if(movieList.get(i).isSelected()) { movieList.remove(i);
           }

         }
            mAdapter.notifyDataSetChanged();
        }

    }
