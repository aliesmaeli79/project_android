package com.example.onlinelibrary;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;



public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookItemView> {



    private ArrayList<Books> bookItem;

    BookListAdapter(ArrayList<Books> bookItem){

       this.bookItem=bookItem;
    }

    @NonNull
    @Override
    public BookListAdapter.BookItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,null,false);
        return new BookItemView(item);
    }

    @Override
    public void onBindViewHolder(@NonNull BookListAdapter.BookItemView holder, int position) {
        Books book=bookItem.get(position);


//        holder.img.setImageResource(book.getIndividual_book());

        Picasso.get().load(book.getPic_link()).into(holder.img);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),book_page.class);
                intent.putExtra("name_book",book.getName());
                intent.putExtra("name_author",book.getAuthor());
                intent.putExtra("genre",book.getGenre());
                intent.putExtra("price",book.getPrice());
                intent.putExtra("explanation",book.getDescription());
                intent.putExtra("rate",book.getRate());
                intent.putExtra("image",book.getPic_link());
                intent.putExtra("link",book.getDownload_link());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return bookItem.size();
    }

    class  BookItemView extends  RecyclerView.ViewHolder{

        protected ImageView img;
        protected LinearLayout linearLayout;

        public BookItemView(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.img_book);
            linearLayout=itemView.findViewById(R.id.Linear_book);
        }
    }
}
