package com.app.mylibrary;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.app.mylibrary.BroadCast.AlarmManagerHelper;
import com.app.mylibrary.DB.DataBaseS;
import com.app.mylibrary.Modle.Reminder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class ReminderActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvChooseTheTime, mTvChooseTheDate;
    private ImageView mImageBack;
    private Button mBtnReminder;


    private int hour, minute;
    private String name_book;
    private DataBaseS dataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        findView();

    }

    private void findView() {

        name_book = getIntent().getExtras().getString("name_book");
        dataBase = DataBaseS.getInstance(ReminderActivity.this);

        mImageBack = findViewById(R.id.image_back);
        mTvChooseTheTime = findViewById(R.id.tv_choose_the_time);
        mTvChooseTheDate = findViewById(R.id.tv_choose_the_date);
        mBtnReminder = findViewById(R.id.btn_reminder);


        mTvChooseTheTime.setOnClickListener(this);
        mTvChooseTheDate.setOnClickListener(this);
        mImageBack.setOnClickListener(this);
        mBtnReminder.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                onBackPressed();
                break;

            case R.id.tv_choose_the_time:
                TimePickerDialog timePickerDialog = new TimePickerDialog(ReminderActivity.this, R.style.datepicker, (timePicker, i, i1) -> {
                    mTvChooseTheTime.setText(i + ":" + i1);
                }, hour, minute, true);
                timePickerDialog.show();
                break;
            case R.id.tv_choose_the_date:
                showCalendarDialog();
                break;
            case R.id.btn_reminder:
                if (validation()) {
                    long p = dataBase.getReminderDao().addNewReminder(new Reminder(name_book, mTvChooseTheTime.getText().toString(), mTvChooseTheDate.getText().toString()));

                    if (p > 0) {
                        Intent intent = new Intent(this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                        AlarmManagerHelper.setAlarm(this);
                        Toast.makeText(this, "Reminder Added Successfully", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }


    private void showCalendarDialog() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(Objects.requireNonNull(ReminderActivity.this), R.style.datepicker,
                (view, year, monthOfYear, dayOfMonth) -> {

                    c.setTimeInMillis(0);
                    c.set(year, monthOfYear, dayOfMonth, 0, 0, 0);
                    Date chosenDate = c.getTime();

                    mTvChooseTheDate.setText(FormatDate(chosenDate));


                }, mYear, mMonth, mDay);
        datePickerDialog.setTitle("");
        datePickerDialog.getDatePicker().setMinDate((System.currentTimeMillis()));
        datePickerDialog.show();
    }

    public static String FormatDate(Date date) {
        if (date == null) {
            return null;
        }
        String dateFormat = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        return simpleDateFormat.format(date);
    }


    private boolean validation() {
        if (mTvChooseTheTime.getText().toString().equals("Choose The Time")) {
            Toast.makeText(this, "Please Choose The Time", Toast.LENGTH_LONG).show();
            return false;
        } else if (mTvChooseTheDate.getText().toString().equals("Choose The Date")) {
            Toast.makeText(this, "Please Choose The Date", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }


}