package com.sagar.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBook extends AppCompatActivity {

    String title, author;

    EditText title1, author1;

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_book);

        title1 = (EditText) findViewById(R.id.titleInput);
        author1 = (EditText) findViewById(R.id.authorInput);

        submit = (Button) findViewById(R.id.button1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        MySQLiteHelper db = new MySQLiteHelper(this);

        db.addBook(new Book(title1.toString(), author1.toString()));




    }
}
