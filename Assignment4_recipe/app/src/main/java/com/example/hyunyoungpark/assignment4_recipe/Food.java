package com.example.hyunyoungpark.assignment4_recipe;

import java.io.Serializable;

/**
 * Created by hyunyoungpark on 2017-07-26.
 */

public class Food implements Serializable {

    private String foodName;
    private String foodIngredient;
    private String foodDescription;
    private String cast;
    private int thumbnail;
    private boolean isSelected;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodIngredient() {
        return foodIngredient;
    }

    public void setFoodIngredient(String foodIngredient) {
        this.foodIngredient = foodIngredient;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public int getThumbnail() {
        return thumbnail;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}