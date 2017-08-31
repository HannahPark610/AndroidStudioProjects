package com.example.hyunyoungpark.myfavoriterestaurant_midterm;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.Exclude;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Store implements Parcelable {
    String[] dummy = {"", "", ""};
    public String name;
    public String tel;
    public List<String> menu = Arrays.asList(dummy);
    public String homepage;
    public String date_regist;
    public int num_category;

    public Store() {
    }

    public String getName() {
        return name;
    }

    public Store(String name, String tel, String menu1, String menu2, String menu3, String homepage , int num_category, String date_regist){
        this.name = name;
        this.tel = tel;
        this.menu.set(0, menu1);
        this.menu.set(1, menu2);
        this.menu.set(2, menu3);
        this.homepage = homepage;
        this.num_category = num_category;
        this.date_regist = date_regist;
    }

    protected Store(Parcel in) {
        name = in.readString();
        tel = in.readString();
        menu = in.createStringArrayList();
        homepage = in.readString();
        date_regist = in.readString();
        num_category = in.readInt();
    }

    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel in) {
            return new Store(in);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(tel);
        parcel.writeStringList(menu);
        parcel.writeString(homepage);
        parcel.writeString(date_regist);
        parcel.writeInt(num_category);
    }


    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("tel", tel);
        result.put("menu", menu);
        result.put("homepage", homepage);
        result.put("date_regist", date_regist);
        result.put("num_category", num_category);

        return result;
    }
}