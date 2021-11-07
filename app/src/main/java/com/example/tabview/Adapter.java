package com.example.tabview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<ModalClass> modalClassArrayList;

    public Adapter(Context context, ArrayList<ModalClass> modalClassArrayList) {
        this.context = context;
        this.modalClassArrayList = modalClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,webView.class);
                intent.putExtra("url",modalClassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });
        holder.heading.setText(modalClassArrayList.get(position).getTitle());
        holder.author.setText(modalClassArrayList.get(position).getAuthor());
        holder.content.setText(modalClassArrayList.get(position).getDescription());
        holder.time.setText("Published At:-"+modalClassArrayList.get(position).getPublishedAt());
        Picasso.with(context).load(modalClassArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modalClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView author,content,heading,time;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            author=itemView.findViewById(R.id.tvauthor);
            heading=itemView.findViewById(R.id.tvheading);
            content=itemView.findViewById(R.id.tvcontent);
            time=itemView.findViewById(R.id.tvtime);
            cardView=itemView.findViewById(R.id.cardView);
            imageView=itemView.findViewById(R.id.ivimageView);
        }
    }
}
