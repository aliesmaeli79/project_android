package com.example.onlinelibrary;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.onlinelibrary.GlobalRequestItem.RESPONSE_ITEM;
import static com.example.onlinelibrary.Subject_to_Book.SPECIFIC_BOOKS;

public class SubjectListAdapter extends RecyclerView.Adapter<SubjectListAdapter.CardItem> {

    private ArrayList<SubjectListItem> mItems =new ArrayList<>();
    SubjectListAdapter(ArrayList<SubjectListItem> items){
        mItems.addAll(items);
    }

    @NonNull
    @Override
    public SubjectListAdapter.CardItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_item,null,false);
        return new CardItem(item);
    }

    @Override
    public void onBindViewHolder(@NonNull CardItem holder, int position) {
        SubjectListItem item=mItems.get(position);


        holder.text.setImageResource(item.getText_image());



        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(SPECIFIC_BOOKS.size()!=0) {
                    SPECIFIC_BOOKS.clear();
                }
                for(int i=0; i<RESPONSE_ITEM.size();i++){
                    if(RESPONSE_ITEM.get(i).getGenre().equals(item.getName_subject())){
                        SPECIFIC_BOOKS.add(RESPONSE_ITEM.get(i));
                    }

                }
                Intent intent=new Intent(v.getContext(),contents_book.class);
                v.getContext().startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return mItems.size();
    }
    class CardItem extends RecyclerView.ViewHolder{

        protected ImageView image;
        protected ImageView text;
        protected LinearLayout linearLayout;
        protected CardView cardView;
        public CardItem(@NonNull View itemView) {
            super(itemView);
//            image=itemView.findViewById(R.id.image_subject);
            text=itemView.findViewById(R.id.text_subject);
            linearLayout=itemView.findViewById(R.id.linear_subject);
            cardView=itemView.findViewById(R.id.cardview_subject);

        }
    }
}
