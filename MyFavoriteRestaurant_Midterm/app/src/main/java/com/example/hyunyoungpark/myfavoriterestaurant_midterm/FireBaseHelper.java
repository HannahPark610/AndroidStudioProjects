package com.example.hyunyoungpark.myfavoriterestaurant_midterm;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by hyunyoungpark on 2017-08-26.
 */

public class FireBaseHelper {
    public static FirebaseDatabase database;
    public static DatabaseReference databaseReference;

    public static DatabaseReference getDatabaseReference() {
        if (databaseReference == null) {
            database = FirebaseDatabase.getInstance();
            databaseReference = database.getReference("stores");
        }

        return databaseReference;
    }

    public static void add(Store store) {

        getDatabaseReference().push().setValue(store);
        // getDatabaseReference().setValue(store);
    }
}
