package com.app.mylibrary;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.mylibrary.Adapter.AdapterHome;
import com.app.mylibrary.Adapter.AdapterReminder;
import com.app.mylibrary.DB.DataBaseS;
import com.app.mylibrary.Modle.Reminder;

import java.util.ArrayList;
import java.util.List;

public class AllReminderActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImageBack;
    private RecyclerView mRvAllReminder;

    private List<Reminder> all_reminder ;
    private AdapterReminder adapterReminder ;
    private DataBaseS database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_reminder);

        findView();

    }

    private void findView() {
        all_reminder = new ArrayList<>();
        database = DataBaseS.getInstance(this);
        mImageBack = findViewById(R.id.image_back);
        mRvAllReminder = findViewById(R.id.rv_all_reminder);

        mImageBack.setOnClickListener(this);


        all_reminder = database.getReminderDao().getAllReminder();
        mRvAllReminder.setLayoutManager(new LinearLayoutManager(AllReminderActivity.this));
        adapterReminder = new AdapterReminder(AllReminderActivity.this, all_reminder);
        mRvAllReminder.setAdapter(adapterReminder);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.image_back :
                onBackPressed();
                break;
        }
    }
}