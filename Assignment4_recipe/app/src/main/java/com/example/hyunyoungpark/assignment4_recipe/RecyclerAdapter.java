package com.example.hyunyoungpark.assignment4_recipe;

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


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Food> food_list;
    private static int viewHolderCount;
    CardView cardView;
    boolean[] checkBoxState;
    public static int[] checkedFood = new int[8];
    public static int count = 0;

    public RecyclerAdapter(List<Food> food_list) {

        this.food_list = food_list;
        checkBoxState = new boolean[food_list.size()];
        viewHolderCount = 0;
    }


//    private String[] titles = {
//            "1",
//            "2",
//            "3",
//            "4",
//            "5",
//            "6",
//            "7",
//            "8"
//
//    };
//
//    private String[] details = {
//            "1 details",
//            "2 details",
//            "3 details",
//            "4 details",
//            "5 details",
//            "6 details",
//            "7 details",
//            "8 details"
//    };
//
//    private int[] images = {
//            R.drawable.bibimbab,
//            R.drawable.bulgogi,
//            R.drawable.chicken,
//            R.drawable.japchae,
//            R.drawable.jjeon,
//            R.drawable.jjimdak,
//            R.drawable.samgyeopsal,
//            R.drawable.tteokbokki
//    };


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list_row, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(itemview);
        int bg = ColorUtils.getViewHolderBackgroundColorFromInstance(context, viewHolderCount);
        viewHolder.itemView.setBackgroundColor(bg);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Food food = food_list.get(position);

        holder.foodName.setText(food_list.get(position).getFoodName());
        holder.foodIngredient.setText(food_list.get(position).getFoodIngredient());
        holder.foodDescription.setText(food_list.get(position).getFoodDescription());
        holder.cast.setText(food_list.get(position).getCast());
        holder.foodImage.setImageResource(food.getThumbnail());
        holder.foodCheck.setChecked(food_list.get(position).isSelected());
        holder.foodCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food_list.get(position).setSelected(true);
                checkedFood[count] = position;
                count++;
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

        return food_list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView foodImage;
        public TextView foodName;
        public TextView foodIngredient;
        public TextView foodDescription;
        public TextView cast;
        public CheckBox foodCheck;


        public MyViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.card_view);

            foodImage = (ImageView) itemView.findViewById(R.id.food_image);
            foodName = (TextView) itemView.findViewById(R.id.food_name);
            foodIngredient = (TextView) itemView.findViewById(R.id.food_ingredient);
            foodDescription = (TextView) itemView.findViewById(R.id.food_description);

            foodImage = (ImageView)view.findViewById(R.id.food_image);
            foodCheck = (CheckBox) view.findViewById(R.id.checkBox);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickedPosition = getAdapterPosition();
                    Toast.makeText(v.getContext(), "you have clicked an item: " + clickedPosition, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}

