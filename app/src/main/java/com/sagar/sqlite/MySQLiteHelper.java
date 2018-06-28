package com.sagar.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "BookDB";
    public static final int DB_VERSION = 1;

    public MySQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BOOK_TABLE = "CREATE TABLE books( id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, author TEXT)";
        db.execSQL(CREATE_BOOK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private static final String TABLE_BOOKS = "books";
    private static final String KEY_ID = "id";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_TITLE = "title";

    private static final String[] columns = {KEY_ID, KEY_AUTHOR, KEY_TITLE};

    public void addBook(Book book) {
        Log.d("add_book", book.toString());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(KEY_ID, book.getId());
        values.put(KEY_TITLE, book.getTitle());
        values.put(KEY_AUTHOR, book.getAuthor());

        db.insert(TABLE_BOOKS, null, values);
        db.close();
    }

    public Book getBook(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_BOOKS, columns, "id=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Book book = new Book();
        book.setId(Integer.parseInt(cursor.getString(0)));
        book.setAuthor(cursor.getString(2));
        book.setTitle(cursor.getString(1));

        Log.d("get_book(" + id + ")", book.toString());

        return book;
    }

    public List<Book> getAllBooks(){
        List<Book> books = new LinkedList<Book>();
        String query = "SELECT * FROM " + TABLE_BOOKS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Book book = null;
        if(cursor.moveToFirst()){
            do{
                book = new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(2));
                book.setAuthor(cursor.getString(1));
            }while(cursor.moveToNext());

            Log.d("getAllBooks()", books.toString());

            return books;
        }

        return books;
    }
}

