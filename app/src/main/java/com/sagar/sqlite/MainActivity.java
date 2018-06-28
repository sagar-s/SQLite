package com.sagar.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button add, getAll, get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button) findViewById(R.id.addBook);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddBook.class);
                startActivity(intent);
            }
        });

        getAll = (Button) findViewById(R.id.getAllBooks);
        getAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });

        get = (Button) findViewById(R.id.getBook);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GetBook.class);
                startActivity(intent);
            }
        });



//        MySQLiteHelper db = new MySQLiteHelper(this);

//        db.add_book(new Book("abcd", "defg"));
//        db.add_book(new Book("asdfwer", "asdgwetwesdfsg"));
//        db.add_book(new Book("asasdfasdfdfwer", "asdgweasdfqwerqerttwesdfsg"));
//
//        List<Book> list = db.getAllBooks();
//
//        Book book = db.get_book(3);




    }
}
