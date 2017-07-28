package com.example.hyunyoungpark.assignment4_recipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity {

    private List<Food> foodList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerAdapter fAdapter;
    private List<ArrayList<Integer>> FoodChecked;

    Button ClearButton;
    Button SelectButton;
    Button DeleteButton;

    TextView Bibimbab;
    TextView Bulgogi;
    TextView Chicken;
    TextView Japchae;
    TextView Jjeon;
    TextView Jjimdak;
    TextView Samgyeopsal;
    TextView Tteokbokki;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        fAdapter = new RecyclerAdapter(foodList);
        RecyclerView.LayoutManager fLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(fLayoutManager);
        recyclerView.setAdapter(fAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        prepareFoodData();

        ClearButton = (Button) findViewById(R.id.clearButton);
        SelectButton = (Button) findViewById(R.id.selectButton);
        DeleteButton = (Button) findViewById(R.id.deleteButton);

        Bibimbab= (TextView)findViewById(R.id.bibimbab_id);
        Bulgogi = (TextView)findViewById(R.id.bulgogi_id);
        Chicken= (TextView)findViewById(R.id.chicken_id);
        Japchae = (TextView)findViewById(R.id.japchae_id);
        Jjeon= (TextView)findViewById(R.id.jjeon_id);
        Jjimdak = (TextView)findViewById(R.id.jjimdak_id);
        Samgyeopsal= (TextView)findViewById(R.id.samgyeopsal_id);
        Tteokbokki = (TextView)findViewById(R.id.tteokbokki_id);

        Bibimbab.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardActivity.this,BibimbabActivity.class);
                startActivity(intent);
            }
        });

        Bulgogi.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardActivity.this,BulgogiActivity.class);
                startActivity(intent);
            }
        });

        Chicken.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardActivity.this,ChickenActivity.class);
                startActivity(intent);
            }
        });

        Japchae.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardActivity.this,JapchaeActivity.class);
                startActivity(intent);
            }
        });

        Jjeon.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardActivity.this,JjeonActivity.class);
                startActivity(intent);
            }
        });

        Jjimdak.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardActivity.this,JjimdakActivity.class);
                startActivity(intent);
            }
        });

        Samgyeopsal.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardActivity.this,SamgyeopsalActivity.class);
                startActivity(intent);
            }
        });

        Tteokbokki.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardActivity.this,TteokbokkiActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_main,menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override

        public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


//        private void prepareFoodData() {
//
//        Food food = new Food("Bibimbab", "Rice, Vegetable, Red Papper Source", "Bibimbam is..", R.drawable.bibimbab);
//        foodList.add(food);
//
//        food = new Food("Bulgogi", "Beef, Vegetable, Soy Source", "Bulgogi is..", R.drawable.bulgogi);
//        foodList.add(food);
//
//        food = new Food("Seasoned Spicy Chicken", "Chicken, Source", "Seasoned Spicy Chicken is..", R.drawable.chicken);
//        foodList.add(food);
//
//        food = new Food("Japchae", "Cellophane Noodles, Vegetable, Mushroom, Sesame, Source", "Japchae is..", R.drawable.japchae);
//        foodList.add(food);
//
//        food = new Food("Jjeon", "Egg, Pan Frying Powder, Mushroom, Pork, Fish", "Jjeon is..", R.drawable.jjeon);
//        foodList.add(food);
//
//        food = new Food("Jjimdak", "Chicken, Carrot, Cellophane Noodles, Onion, Soy Source ", "Jjimdak is..", R.drawable.jjimdak);
//        foodList.add(food);
//
//        food = new Food("Samgyeopsal", "Pork", "Samgyeopsal is..", R.drawable.samgyeopsal);
//        foodList.add(food);
//
//        food = new Food("Tteokbokki", "Rice Cake, Red Papper Source, Egg, Fish Cake", "Tteokbokki is..", R.drawable.tteokbokki);
//        foodList.add(food);
//
//        fAdapter.notifyDataSetChanged();
//    }


    public void selectAll(View view) {
        for (Food f : foodList) {
            f.setSelected(true);
            fAdapter.notifyDataSetChanged();
        }
    }

    public void clearAll(View view) {
        for (Food f : foodList) {
            f.setSelected(false);
            fAdapter.notifyDataSetChanged();
        }
    }

    public void deleteMovie(View view) {
        for(int i = foodList.size() - 1; i >= 0; i--) {
            if(foodList.get(i).isSelected()) {
                foodList.remove(i);
            }
        }
        fAdapter.notifyDataSetChanged();
    }

}

