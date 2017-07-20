package com.example.hyunyoungpark.action;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox) ;

        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        mAdapter = new MoviesAdapter(movieList);
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
    }
}
