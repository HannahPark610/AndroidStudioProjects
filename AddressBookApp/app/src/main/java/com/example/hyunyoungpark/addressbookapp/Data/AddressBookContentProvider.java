package com.example.hyunyoungpark.addressbookapp.Data;

//extend with ContentProvider

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class AddressBookContentProvider extends ContentProvider {

    // 1. Create instance of your database
    private AddressBookDatabaseHelper dbHelper;

    // 2. URI Matcher that helps ContentProvider to determine
    // the operation to perform
    // We have two uris 1) that gives you all rows of contact
    //                  2) that gives you only row of contact based on ID

    private static final UriMatcher uriMatcher =
            new UriMatcher(UriMatcher.NO_MATCH);

    //Constant values that are used with URIMATCHER to determine the operation to performed

    private static final int CONTACTS = 2;
    private static final int ONE_CONTACT = 1;

    //static block to configure this URIMATCHER
    static {
        uriMatcher.addURI(DatabaseDescription.AUTHORITY,
                DatabaseDescription.Contact.TABLE_NAME, CONTACTS);

        //uri for contact table with specific #id value
        uriMatcher.addURI(DatabaseDescription.AUTHORITY,
                DatabaseDescription.Contact.TABLE_NAME + " /#"
                , ONE_CONTACT);
    }


    @Override
    public boolean onCreate() {
        // create the database
        dbHelper = new AddressBookDatabaseHelper(getContext());
        return true;
    }

    //select the data or query the database
    // (this one is method similar to SELECT * FROM CONTACT;
    // or SELECT * FROM CONTACT where CONTACT_ID = #value;
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        //create a sqlitebuilder for querying contact table
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        //you want to query to which table
        //that is specified by setTable()
        queryBuilder.setTables(DatabaseDescription.Contact.TABLE_NAME);

        switch (uriMatcher.match(uri))
        {
            case ONE_CONTACT :
                queryBuilder.appendWhere((DatabaseDescription.Contact._ID + "="
                + uri.getLastPathSegment()));
                break;
            case CONTACTS : //all contacys will be selecte
                // this is for all rows
                break;
            default:
                throw UnsupportedOperationException(getContext().getString(R.string.invalid_query_uri) + uri);
        }

        // Have to do
        //we just finished creating the query
        //exceution is remianed

        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
