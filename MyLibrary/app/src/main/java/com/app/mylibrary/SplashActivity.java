package com.app.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.app.mylibrary.DB.DataBaseS;
import com.app.mylibrary.Modle.Books;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    private DataBaseS database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        database = DataBaseS.getInstance(SplashActivity.this);

        new Handler().postDelayed(() -> {

            database.getBooksDao().deleteAllBooks();
            database.getBooksDao().addNewBooks(new Books("a1", "Oliver Twist"));
            database.getBooksDao().addNewBooks(new Books("a2", "Around The World In 80 Days"));
            database.getBooksDao().addNewBooks(new Books("a3", "Treasure Island"));
            database.getBooksDao().addNewBooks(new Books("a4", "Sherlock Holmes"));
            database.getBooksDao().addNewBooks(new Books("a5", "Crime In Three Quarters"));
            database.getBooksDao().addNewBooks(new Books("a6", "Les Miserables"));


            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();

        }, SPLASH_TIME_OUT);
    }
}