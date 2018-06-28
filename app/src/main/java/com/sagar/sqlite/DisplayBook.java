package com.sagar.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisplayBook extends AppCompatActivity {

    private TextView mAuthor = (TextView) findViewById(R.id.author2);
    private TextView mTitle = (TextView) findViewById(R.id.title2);

    Button again, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_book);

        Intent intent = getIntent();
        Book book = (Book) intent.getSerializableExtra("book");
        String title = book.getTitle();
        String author = book.getAuthor();

        mTitle.setText(title);
        mAuthor.setText(author);


        again = (Button) findViewById(R.id.again);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayBook.this, GetBook.class);
                startActivity(intent);
            }
        });

        home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayBook.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}
