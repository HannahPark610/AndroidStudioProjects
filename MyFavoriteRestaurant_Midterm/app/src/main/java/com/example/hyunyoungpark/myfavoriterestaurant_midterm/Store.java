package com.example.hyunyoungpark.myfavoriterestaurant_midterm;

import android.os.Parcel;
import android.os.Parcelable;


public class Store implements Parcelable {
    String name;
    String tel;
    String [] menu;
    String homepage;
    String date_regist;
    int num_category;

    public Store(String name, String tel, String menu1, String menu2, String menu3, String homepage ,int num_category, String date_regist){
        menu = new String[3];
        this.name = name;
        this.tel = tel;
        this.menu[0] = menu1;
        this.menu[1] = menu2;
        this.menu[2] = menu3;
        this.homepage = homepage;
        this.num_category = num_category;
        this.date_regist = date_regist;
    }

    protected Store(Parcel in) {
        name = in.readString();
        tel = in.readString();
        menu = in.createStringArray();
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
        parcel.writeStringArray(menu);
        parcel.writeString(homepage);
        parcel.writeString(date_regist);
        parcel.writeInt(num_category);
    }
}