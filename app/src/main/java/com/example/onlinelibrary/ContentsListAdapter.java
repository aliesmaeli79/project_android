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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ContentsListAdapter extends RecyclerView.Adapter<ContentsListAdapter.BookItem> {



    ArrayList<Books> data;

    public ContentsListAdapter(ArrayList<Books>  data) {
        this.data = data;
    }



    @NonNull
    @Override
    public ContentsListAdapter.BookItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.contents_item,null,false);
        return new ContentsListAdapter.BookItem(item);
    }

    @Override
    public void onBindViewHolder(ContentsListAdapter.BookItem holder, int position) {
        Books items=data.get(position);

        String name_book;
        String name_author;
        String price;
        String genre;
        String explanation;
        String image;
        float rating;
        String link;

        holder.ratingBar.setRating(items.getRate());
        holder.name_book.setText(items.getName());
        holder.price_book.setText(items.getPrice());
        holder.writer_book.setText(items.getAuthor());

        name_book=items.getName();
        name_author=items.getAuthor();
        price=items.getPrice();
        genre=items.getGenre();
        explanation=items.getDescription();
        link=items.getDownload_link();

        image=items.getPic_link();

        rating=items.getRate();


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),book_page.class);
                intent.putExtra("name_book",name_book);
                intent.putExtra("name_author",name_author);
                intent.putExtra("price",price);
                intent.putExtra("genre",genre);
                intent.putExtra("explanation",explanation);
                intent.putExtra("image",image);
                intent.putExtra("rate",rating);
                intent.putExtra("link",link);
                v.getContext().startActivity(intent);
            }
        });


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
        protected TextView explanation;
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
            explanation=itemView.findViewById(R.id.text_book);

            price_book=itemView.findViewById(R.id.price_book);

            linearLayout=itemView.findViewById(R.id.linear_book);

            button=itemView.findViewById(R.id.btn_download);

        }
    }
}
