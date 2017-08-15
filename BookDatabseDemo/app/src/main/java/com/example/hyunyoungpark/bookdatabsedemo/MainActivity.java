package com.example.hyunyoungpark.bookdatabsedemo;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    Button addBook;
    EditText booktitle, bookauthor;
    ListView lv_books;
    BookAdapter bookAdapter;
    List<Book> listbooks;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBook = (Button) findViewById(R.id.button_add);
        booktitle = (EditText)findViewById(R.id.titleEdit);
        bookauthor = (EditText) findViewById(R.id.author_book);
        lv_books = (ListView) findViewById(R.id.List_book)
        addBook.setOnClickListener();

        listbooks = ab.getAllBooks();
        List<Integer> listID = new ArrayList<Integer>();
        List<String> listTitle = new ArrayList<String>();
        List<String> listAuthor = new ArrayList<String>();

        for(int i=0; i<listbooks.size(); i++) {
            listID.add(i, listbooks.get(i).getTitle());
            listAuthor.add(i, listbooks.get(i).getAuthor());

        }
        bookAdapter = new BookAdapter(this, listID, listTitle, listAuthor);
        lv_books.setAdapter(bookAdapter);
    }
}