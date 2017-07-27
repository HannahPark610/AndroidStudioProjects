package com.example.hyunyoungpark.assignment4_recipe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity {

    private List<Food> foodList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerAdapter fAdapter;
    private List<ArrayList<Integer>> FoodChecked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        recyclerView.setHasFixedSize(true);

        fAdapter = new RecyclerAdapter(foodList);
        RecyclerView.LayoutManager fLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(fLayoutManager);
        recyclerView.setAdapter(fAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        prepareFoodData();
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


        private void prepareFoodData() {

        Food food = new Food("Bibimbab", "Rice, Vegetable, Red Papper Source", "Bibimbam is..", R.drawable.bibimbab);
        foodList.add(food);

        food = new Food("Bulgogi", "Beef, Vegetable, Soy Source", "Bulgogi is..", R.drawable.bulgogi);
        foodList.add(food);

        food = new Food("Seasoned Spicy Chicken", "Chicken, Source", "Seasoned Spicy Chicken is..", R.drawable.chicken);
        foodList.add(food);

        food = new Food("Japchae", "Cellophane Noodles, Vegetable, Mushroom, Sesame, Source", "Japchae is..", R.drawable.japchae);
        foodList.add(food);

        food = new Food("Jjeon", "Egg, Pan Frying Powder, Mushroom, Pork, Fish", "Jjeon is..", R.drawable.jjeon);
        foodList.add(food);

        food = new Food("Jjimdak", "Chicken, Carrot, Cellophane Noodles, Onion, Soy Source ", "Jjimdak is..", R.drawable.jjimdak);
        foodList.add(food);

        food = new Food("Samgyeopsal", "Pork", "Samgyeopsal is..", R.drawable.samgyeopsal);
        foodList.add(food);

        food = new Food("Tteokbokki", "Rice Cake, Red Papper Source, Egg, Fish Cake", "Tteokbokki is..", R.drawable.tteokbokki);
        foodList.add(food);

//        fAdapter.notifyDataSetChanged();
    }

//    @Override
//    public void onListItemClick(int position) {
//
//        Food f = foodList.get(position);
//        String foodName = f.getFoodName();
//        String foodIngredient = f.getFoodIngredient();
//        String foodDescription = f.getFoodDescription();
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

