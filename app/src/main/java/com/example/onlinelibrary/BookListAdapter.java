package com.example.onlinelibrary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookItemView> {

    private ArrayList<BookItem> bookItem =new ArrayList<>();
    BookListAdapter(ArrayList<BookItem> items){
        bookItem.addAll(items);
    }

    @NonNull
    @Override
    public BookListAdapter.BookItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,null,false);
        return new BookItemView(item);
    }

    @Override
    public void onBindViewHolder(@NonNull BookListAdapter.BookItemView holder, int position) {
        BookItem book=bookItem.get(position);
        holder.img.setImageResource(book.getImg());
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
