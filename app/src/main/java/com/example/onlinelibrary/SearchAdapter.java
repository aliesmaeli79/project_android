package com.example.onlinelibrary;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.BookItem> {


    ArrayList<Books> data;

    public SearchAdapter(ArrayList<Books> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public SearchAdapter.BookItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.contents_item,null,false);
        return new SearchAdapter.BookItem(item);
    }

    @Override
    public void onBindViewHolder(@NonNull BookItem holder, int position) {
        Books items=data.get(position);

        holder.ratingBar.setRating(items.getRate());
        holder.name_book.setText(items.getName());
        holder.price_book.setText(items.getPrice());
        holder.writer_book.setText(items.getAuthor());



        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = items.getDownload_link();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                v.getContext().startActivity(browserIntent);

            }
        });

        Picasso.get().load(items.getPic_link()).into(holder.image);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    class BookItem extends RecyclerView.ViewHolder{

        protected ImageView image;
        protected TextView name_book;
        protected TextView writer_book;
        protected TextView price_book;
        protected RatingBar ratingBar;

        protected LinearLayout linearLayout;

        protected Button button;

        public BookItem(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image_book);
            name_book=itemView.findViewById(R.id.name_book);
            writer_book=itemView.findViewById(R.id.writer_book);
            ratingBar=itemView.findViewById(R.id.rating_bar);
            image=itemView.findViewById(R.id.image_book);
            price_book=itemView.findViewById(R.id.price_book);

            linearLayout=itemView.findViewById(R.id.linear_book);

            button=itemView.findViewById(R.id.btn_download);

        }
    }
}
