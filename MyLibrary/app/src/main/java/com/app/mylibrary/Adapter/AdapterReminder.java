package com.app.mylibrary.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.mylibrary.DetailsActivity;
import com.app.mylibrary.Modle.Books;
import com.app.mylibrary.Modle.Reminder;
import com.app.mylibrary.R;

import java.util.List;

public class AdapterReminder extends RecyclerView.Adapter<AdapterReminder.ViewHolder> {

    Activity context;
    List<Reminder> list;

    public AdapterReminder(Activity context, List<Reminder> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_reminders, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int p) {
        Reminder data = list.get(p);

        holder.tv_name_book.setText(data.getName_book());
        holder.tv_time.setText(data.getTime());
        holder.tv_date.setText(data.getDate());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView  tv_name_book , tv_time , tv_date ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name_book = itemView.findViewById(R.id.tv_name_book);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_date = itemView.findViewById(R.id.tv_date);


        }
    }


}