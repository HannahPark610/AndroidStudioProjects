package com.example.hyunyoungpark.action;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        
        prepareMovieData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void prepareMovieData() {
        Movie movie = new Movie("Inside Out", "Animation, Kids-Family", "2015");
        movieList.add(movie);
        movie = new Movie("Forrest Gump", "Romantic-Comedy-Drama", "1994");
        movieList.add(movie);
        movie = new Movie("Titanic", "Romantic-Disaster-Drama", "1997");
        movieList.add(movie);
        movie = new Movie("Toy Story", "Animation, Buddy-Comedy", "2010");
        movieList.add(movie);
        movie = new Movie("Inside Out", "Animation, Kids-Family", "2015");
        movieList.add(movie);
        movie = new Movie("Forrest Gump", "Romantic-Comedy-Drama", "1994");
        movieList.add(movie);
        movie = new Movie("Titanic", "Romantic-Disaster-Drama", "1997");
        movieList.add(movie);
        movie = new Movie("Toy Story", "Animation, Buddy-Comedy", "2010");
        movieList.add(movie);
        movie = new Movie("Inside Out", "Animation, Kids-Family", "2015");
        movieList.add(movie);
        movie = new Movie("Forrest Gump", "Romantic-Comedy-Drama", "1994");
        movieList.add(movie);
        movie = new Movie("Titanic", "Romantic-Disaster-Drama", "1997");
        movieList.add(movie);
        movie = new Movie("Toy Story", "Animation, Buddy-Comedy", "2010");
        movieList.add(movie);
        movie = new Movie("Inside Out", "Animation, Kids-Family", "2015");
        movieList.add(movie);
        movie = new Movie("Forrest Gump", "Romantic-Comedy-Drama", "1994");
        movieList.add(movie);
        movie = new Movie("Titanic", "Romantic-Disaster-Drama", "1997");
        movieList.add(movie);
        movie = new Movie("Toy Story", "Animation, Buddy-Comedy", "2010");
        movieList.add(movie);
    }
}
