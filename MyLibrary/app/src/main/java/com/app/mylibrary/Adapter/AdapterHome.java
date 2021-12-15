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
import com.app.mylibrary.R;
import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {

    Activity context;
    List<Books> list;

    public AdapterHome(Activity context, List<Books> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int p) {
        Books data = list.get(p);

        holder.tv_name_book.setText(data.getName());
        holder.image_book.setImageResource(context.getResources().getIdentifier(data.getImage(), "drawable", context.getPackageName()));



        holder.itemView.setOnClickListener(view -> {
            Intent i = new Intent(context, DetailsActivity.class);
            i.putExtra("image",data.getImage());
            i.putExtra("name",data.getName());
            context.startActivity(i);
        });




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView  tv_name_book ;
        ImageView image_book ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_book = itemView.findViewById(R.id.image_book);
            tv_name_book = itemView.findViewById(R.id.tv_name_book);


        }
    }


}