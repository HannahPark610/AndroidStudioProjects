package com.example.hyunyoungpark.assignment4_recipe;

import android.content.Context;
import android.content.Intent;
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
    public static int[] checkedFood = new int[20];
    public static int count = 0;

    public RecyclerAdapter(List<Food> food_list) {

        this.food_list = food_list;
        checkBoxState = new boolean[food_list.size()];
        viewHolderCount = 0;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

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
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Food food = food_list.get(position);

        holder.foodName.setText(food_list.get(position).getFoodName());
        holder.foodIngredient.setText(food_list.get(position).getFoodIngredient());
        holder.foodDescription.setText(food_list.get(position).getFoodDescription());
        holder.thumbnail.setImageResource(food.getThumbnail());

        holder.foodCheck.setChecked(food_list.get(position).isSelected());

        holder.foodCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCheck = ((CheckBox)v).isChecked();
                if (isCheck) {
                    food_list.get(position).setSelected(true);

                } else {

                    food_list.get(position).setSelected(false);
                }

                food_list.get(position).setSelected(true);
                checkedFood[count] = position;
                count++;
            }
        });

        holder.foodName.setOnClickListener(new View.OnClickListener() {
            Intent intent= null;

            @Override
            public void onClick(View view) {
                Context c = view.getContext();
                switch(position)
                {
                    case 0: intent = new Intent(view.getContext(), BibimbabActivity.class);
                        intent.putExtra("MENU","aa");
                            c.startActivity(intent);
                            break;

                    case 1: intent = new Intent(view.getContext(),BulgogiActivity.class);
                        intent.putExtra("MENU","aa");
                        c.startActivity(intent);
                            break;

                    case 2: intent = new Intent(view.getContext(),ChickenActivity.class);
                        intent.putExtra("MENU","aa");
                        c.startActivity(intent);
                            break;

                    case 3: intent = new Intent(view.getContext(),JapchaeActivity.class);
                        intent.putExtra("MENU","aa");
                        c.startActivity(intent);
                            break;

                    case 4: intent = new Intent(view.getContext(),JjeonActivity.class);
                        intent.putExtra("MENU","aa");
                        c.startActivity(intent);
                            break;

                    case 5: intent = new Intent(view.getContext(),JjimdakActivity.class);
                        intent.putExtra("MENU","aa");
                        c.startActivity(intent);
                            break;

                    case 6: intent = new Intent(view.getContext(),SamgyeopsalActivity.class);
                        intent.putExtra("MENU","aa");
                        c.startActivity(intent);
                            break;

                    default: intent = new Intent(view.getContext(),TteokbokkiActivity.class);
                        intent.putExtra("MENU","aa");
                        c.startActivity(intent);
                }
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

        public ImageView thumbnail;
        public TextView foodName;
        public TextView foodIngredient;
        public TextView foodDescription;
        public CheckBox foodCheck;


        public MyViewHolder(View view) {

            super(view);
            cardView = (CardView) view.findViewById(R.id.card_view);

            thumbnail = (ImageView) itemView.findViewById(R.id.food_image);
            foodName = (TextView) itemView.findViewById(R.id.food_name);
            foodIngredient = (TextView) itemView.findViewById(R.id.food_ingredient);
            foodDescription = (TextView) itemView.findViewById(R.id.food_description);

            thumbnail = (ImageView)view.findViewById(R.id.food_image);
            foodCheck = (CheckBox) view.findViewById(R.id.checkBox);
        }
    }
}

