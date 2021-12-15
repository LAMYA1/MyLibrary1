package com.app.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.mylibrary.Adapter.AdapterHome;
import com.app.mylibrary.DB.DataBaseS;
import com.app.mylibrary.Modle.Books;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView mRvHome;
    private Button mBtnAllReminder;

    private List<Books> all_books;
    private AdapterHome adapterHome;
    private DataBaseS database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();


    }

    private void findView() {

        all_books = new ArrayList<>();
        database = DataBaseS.getInstance(this);
        mRvHome = findViewById(R.id.rv_home);
        mBtnAllReminder = findViewById(R.id.btn_all_reminder);


        mBtnAllReminder.setOnClickListener(this);

        all_books = database.getBooksDao().getAllBooks();
        mRvHome.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        adapterHome = new AdapterHome(MainActivity.this, all_books);
        mRvHome.setAdapter(adapterHome);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_all_reminder:
                startActivity(new Intent(MainActivity.this, AllReminderActivity.class));
                break;
        }
    }
}