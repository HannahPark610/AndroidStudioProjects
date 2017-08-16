package com.example.hyunyoungpark.bookdatabsedemo;


import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity implements View.OnClickListener, ListView.OnItemClickListener {
    DatabaseHandler db = new DatabaseHandler(this);
    String tag = "book";
    Button addBook, updateBook,deleteBook;
    EditText booktitle, bookauthor;
    ListView lv_books;
    BookAdapter bookAdapter;
    List<Book> listbooks; //Book is the model class
    static Integer seletedID;  //global variable that stores
    // selected book's id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBook = (Button)findViewById(R.id.button_add);
        updateBook = (Button)findViewById(R.id.button_update);
        deleteBook = (Button)findViewById(R.id.button_delete);
        booktitle = (EditText)findViewById(R.id.titleEdit);
        bookauthor = (EditText)findViewById(R.id.authorEdit);
        lv_books = (ListView)findViewById(R.id.list_book);

        addBook.setOnClickListener(this);
        updateBook.setOnClickListener(this);
        deleteBook.setOnClickListener(this);
        lv_books.setOnItemClickListener(this);

        //todo 8) Read all books from database and add it into the list.
        listbooks = db.getAllBooks();
        List<Integer> listID = new ArrayList<Integer>();
        List<String> listTitle = new ArrayList<String>();
        List<String> listAuthor = new ArrayList<String>();

        for(int i=0; i<listbooks.size(); i++)
        {
            listID.add(i, listbooks.get(i).getId());
            listTitle.add(i,listbooks.get(i).getTitle());
            listAuthor.add(i,listbooks.get(i).getAuthor());
        }
        bookAdapter = new BookAdapter(this, listID,
                listTitle, listAuthor);
        lv_books.setAdapter(bookAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button_add:
                add(v);
                break;

            //create a book object with selected ID
            //Pass this book object to update method
            //to DatabaseHandler.java
            case R.id.button_update:
                //empty object of book
                Book book = new Book();
                //assign the values
                book.setId(seletedID);
                book.setTitle(booktitle.getText().toString());
                book.setAuthor(bookauthor.getText().toString());
                int rowAffected = db.updateBook(book);
                Toast.makeText(this, "ROWS" + rowAffected + "ARE UPDATED", Toast.LENGTH_SHORT).show();
                break;

            //create a book object with selected ID
            // Pass this book object to delete method
            // to DatabaseHandler.java
            case R.id.button_delete:
                //empty object of book
                Book book1 = new Book();
                //assign the values
                book1.setId(seletedID);
                book1.setTitle(booktitle.getText().toString());
                book1.setAuthor(bookauthor.getText().toString());
                int rowAffected1 = db.deleteBook(book1);
                Toast.makeText(this, "ROWS" + rowAffected1 + "ARE DELETED", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    public void add(View v)
    {
        String title = booktitle.getText().toString();
        String author = bookauthor.getText().toString();
        db.addBook(new Book(title,author));
        Toast.makeText(this, "BOOK ADDED SUCCESFULLY",
                Toast.LENGTH_LONG).show();

    }

    //when you select any book
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //intializing the value for bookID
        seletedID = listbooks.get(position).getId();
        Book b = null;
        b = db.readBook(seletedID);
        booktitle.setText( b.getTitle());
        bookauthor.setText(b.getAuthor());
        Toast.makeText(this, "BOOK READ SUCCESFULLY",
                Toast.LENGTH_LONG).show();

    }
}