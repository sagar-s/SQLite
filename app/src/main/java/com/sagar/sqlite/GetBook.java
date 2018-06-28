package com.sagar.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GetBook extends AppCompatActivity {

    int id;
    Button button;
    EditText idInput;
    MySQLiteHelper db = new MySQLiteHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_book);

        idInput = (EditText) findViewById(R.id.idInput);
        String text = idInput.getText().toString();
        id = Integer.parseInt(text);
        final Book book = db.getBook(id);

        button = (Button) findViewById(R.id.idButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GetBook.this, DisplayBook.class);
                intent.putExtra("book", book);
            }
        });


    }



}
