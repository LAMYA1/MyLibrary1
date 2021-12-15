package com.app.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImageBack, mImageBook;
    private TextView mTvNameBook;
    private Button mBtnReminder;

    private String image_book, name_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        findView();

    }

    private void findView() {
        image_book = getIntent().getExtras().getString("image");
        name_book = getIntent().getExtras().getString("name");

        mImageBack = findViewById(R.id.image_back);
        mImageBook = findViewById(R.id.image_book);
        mTvNameBook = findViewById(R.id.tv_name_book);
        mBtnReminder = findViewById(R.id.btn_reminder);

        mImageBack.setOnClickListener(this);
        mBtnReminder.setOnClickListener(this);

        mImageBook.setImageResource(getResources().getIdentifier(image_book, "drawable", getPackageName()));
        mTvNameBook.setText(name_book);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.image_back :
                onBackPressed();
                break;

            case R.id.btn_reminder:
                Intent i = new Intent(DetailsActivity.this , ReminderActivity.class);
                i.putExtra("name_book", name_book);
                startActivity(i);
                break;
        }
    }
}