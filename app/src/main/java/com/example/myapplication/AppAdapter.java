package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder> {

    List<App> appList;
    Context context;

    public AppAdapter(Context context, List<App> apps){
        this.context = context;
        appList = apps;
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, @SuppressLint("RecyclerView") int position) {
        App app = appList.get(position);
        Glide.with(context).load(app.getImage()).into(holder.image);
        holder.name.setText(app.getName());
        holder.currentPrice.setText(app.getCurrent_price());
        holder.symbol.setText(app.getSymbol());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ShowActivity.class);
                intent.putExtra("Show",appList.get(position));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    public class AppViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name,currentPrice,symbol;
        public AppViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgImage);
            name = itemView.findViewById(R.id.txtName);
            currentPrice = itemView.findViewById(R.id.txtCurrentPrice);
            symbol = itemView.findViewById(R.id.txtSymbol);
        }
    }

}
