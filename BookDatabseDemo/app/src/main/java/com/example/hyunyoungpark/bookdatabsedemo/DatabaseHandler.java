package com.example.hyunyoungpark.bookdatabsedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {
    // TODO 1) Creating a database name
    public static final String DATABASE_NAME = "Bookdb";
    //TODO 2) current version of database
    private static int DATABASE_VERSION = 1;

    //TODO 3) Create a constructor
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //TODO 4) Create a Table Name
    private static final String TABLE_NAME = "book";
    // TODO 5) All keys used in table with their data types & constraints
    private static final String KEY_ID = "bookid";
    private static final String KEY_NAME = "title";
    private static final String KEY_AUTHOR = "author";

    //TODO 6) Create a query statement for creating a table in database
    private static final String CREATE_TABLE_BOOKS =
            "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER " +
                    "PRIMARY KEY AUTOINCREMENT," + KEY_NAME +
                    " TEXT," + KEY_AUTHOR +
                    " TEXT " + ");";

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO 7) Create a table Book
        db.execSQL(CREATE_TABLE_BOOKS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // if you hav echanged or added or removes columns
        //in table than this method will be called
        db.execSQL("DROP TABLE IF EXIST " + CREATE_TABLE_BOOKS);
        this.onCreate(db);
    }

    public void addBook(Book book) {
        //get the reference to writeable DB
        SQLiteDatabase db1 = this.getWritableDatabase();

        //Create  Key & value pair
        ContentValues value = new ContentValues();
        value.put(KEY_NAME, book.getTitle());
        value.put(KEY_AUTHOR, book.getAuthor());

        //insert the data into table
        db1.insert(TABLE_NAME, null, value);

        //close the database connection
        db1.close();
    }

    public List<Book> getAllBooks() {
        List<Book> books = new LinkedList<Book>();
        //TODO 8) Create a select query
        String query = "SELECT * FROM" + TABLE_NAME;
        //TODO 9) Get instance of database in READABLE mode.
        SQLiteDatabase ab = this.getReadableDatabase();
        //TODO 10) Get cursor object for result of query
        Cursor cursor = ab.rawQuery(query,null);
        //rawquery directly accepts SQL statement
        //as its input abd it returns cusor object
        //shich will point to one row of query result
        //TODO 11) Go over result and build Book object and
        //add it to the list

        Book book = null;
        if(cursor.moveToFirst()) {
            do {

                book = new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(1));
                book.setAuthor(cursor.getString(2));
                books.add(book);

            } while (cursor.moveToNext());
        }

        return books;
    }
}