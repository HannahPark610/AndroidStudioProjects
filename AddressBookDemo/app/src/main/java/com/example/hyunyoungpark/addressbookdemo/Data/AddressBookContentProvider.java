package com.example.hyunyoungpark.addressbookdemo.Data;
//extend with ContentProvider

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.hyunyoungpark.addressbookdemo.R;

public class AddressBookContentProvider  extends ContentProvider{
    //1 Create instance of your database
    private AddressBookDatabaseHelper dbHelper;

    //2. URI Matcher that helps ContentProvider to determine
    // the operation to perform
    // we have two uris 1) that gives you all rows of contact
    //                  2) That gives you only one row of contact based on ID

    private static final UriMatcher uriMatcher =
            new UriMatcher(UriMatcher.NO_MATCH);
    //Constant values that are used with URIMATCHER to
    // determine the operations to performed

    private static final int CONTACTS = 2;
    private static final int ONE_CONTACT = 1;
    //
    //static block to configure this URIMATCHER
    static{
        //URI for contact table that will return all rows
        uriMatcher.addURI(DatabaseDescription.AUTHORITY,
                DatabaseDescription.Contact.TABLE_NAME,CONTACTS);

        //uri for contact table with specific #id value
        uriMatcher.addURI(DatabaseDescription.AUTHORITY,
                DatabaseDescription.Contact.TABLE_NAME + "/#"
                ,ONE_CONTACT);

    }

    @Override
    public boolean onCreate() {
        //create the database
        dbHelper = new AddressBookDatabaseHelper(getContext());
        return true;
    }

    // select the data or query the database
    // (this one is method similar to SELECT * FROM CONTACT;
    // or SELECT * FROM CONTACT where CONTACT_ID = #value;
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        //create a sqllitebuilder for querying contact table
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        //you want to query to which table
        //that is specified by setTable()
        queryBuilder.setTables(DatabaseDescription.Contact.TABLE_NAME);

        switch(uriMatcher.match(uri))
        {
            case ONE_CONTACT :
                //contact with specific ID will be selcetd here
                // add the ID value from URI to the QueryBuilder
                queryBuilder.appendWhere
                        ((DatabaseDescription.Contact._ID + " = "
                                + uri.getLastPathSegment()));
                break;
            case CONTACTS : //all contacts will be selected
                //this is for all rows
                break;
            default:
                throw new UnsupportedOperationException(
                        getContext().getString(R.string.invalid_query_uri) +
                                uri
                );
        }
        //we just finished creating the query
        //exceution is remianed
        Cursor cursor = queryBuilder.query(dbHelper.getReadableDatabase(),
                projection, selection, selectionArgs, // Columns & rows
                null, null, sortOrder) ; // GroupBY and Having

        //configure tthe cursor that whenever data is changed
        // cursor should get updated
        //this method needs a Content provider obj
        // & URI to invoke it
        cursor.setNotificationUri(getContext().getContentResolver(),
                uri);

        return cursor;
    }
    //MIME type
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    //insert a new Contact to the database
    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        //uri it represents table in which data will be added
        //ContentValues it represents the object containg
        //key-value pair
        Uri newContact  = null;
        //Check whether uri is for contact table
        //If URI is a match for insert
        //then get the writable database, use the insert()

        switch(uriMatcher.match(uri))
        {
            //add the new data to the end of table
            // not on specific ID value .
            // CONTACTS give you a full table
            case CONTACTS :
                //insert the new contact-- success it should
                //return the id value ( a value 0r -1)
                //get the database instance
                long rowID = dbHelper.getWritableDatabase().insert(
                        DatabaseDescription.Contact.TABLE_NAME,
                        null, //nullcolumnHack
                        values
                );
                //nullColumnHack : SQLite doesn't support inserting
                //empty row in table , Instead making it illegal to pass
                // empty contentvalues it identifies a columns that
                // accept a NULL value.

                //check for success if yes create a uri for new contact
                if(rowID>0)
                {
                    newContact = DatabaseDescription.Contact.buildContactUri(rowID);

                    //notify the cursor for newly added data
                    getContext().getContentResolver().notifyChange(uri,null);
                }
                else {
                    //database operation gets fail throw insert failed exception
                    throw new SQLException(
                            getContext().getString(R.string.insert_failed));
                }
                break;
            default:
                throw new SQLException(
                        getContext().getString(R.string.insert_failed));
        }

        return newContact;
    }

    // delete an existing contact
    // URi means row to delete
    // Where clause specifyinf a row to delete
    //String[] having value for where caluse
    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int noofRowsDeleted;
        //check the uri for one contact
        switch(uriMatcher.match(uri))
        {
            case ONE_CONTACT:
                //get from the uri the id of contact for delete
                String id = uri.getLastPathSegment();
                //delete()
                // 1. Table name
                // 2. Where Clause
                // 3. Array of string subtitute into Where Cluase
                noofRowsDeleted = dbHelper.getWritableDatabase().delete(
                        DatabaseDescription.Contact.TABLE_NAME,
                        DatabaseDescription.Contact._ID + " = " + id ,
                        selectionArgs
                );
                break;
            default:
                throw new SQLException(
                        getContext().getString(R.string.invalid_delete_uri)
                );
        }
        //if delete is successful notify the cursor about
        // database change
        if(noofRowsDeleted >0)
        {
            getContext().getContentResolver().notifyChange(uri,null);
        }
        return noofRowsDeleted;
    }

    //change the existing value of contact
    @Override
    //uri : row
    // ContentValues : key-value pair
    // Selection: where clause
    // SelectionArgs : a string array for Where clause
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int noOfRowsUpdated;
        //we need uri matcher for one contact
        switch ((uriMatcher.match(uri)))
        {
            case ONE_CONTACT:
                //get the id from uri using getlastpathsegmemt
                String id = uri.getLastPathSegment();
                //update the data
                // 1. tablename
                // 2. contentvalue
                // 3. where clause
                // 4. values
                noOfRowsUpdated = dbHelper.getWritableDatabase().update(
                        DatabaseDescription.Contact.TABLE_NAME,
                        values,
                        DatabaseDescription.Contact._ID + " = " + id , // e.g. where id = 50
                        selectionArgs
                );
                break;
            default:
                throw  new SQLException(
                        getContext().getString(R.string.invalid_update_uri)
                );
        }
        //if changes are succcessful notify the
        // changes in cursor
        if(noOfRowsUpdated > 0)
        {
            getContext().getContentResolver().notifyChange(uri,null);
        }

        return noOfRowsUpdated;
    }
}