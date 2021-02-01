package com.example.onlinelibrary;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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


//        holder.image.setImageResource(item.getImage_subject());

//        if (position % 11 == 0) {
//            holder.linearLayout.setBackgroundColor(Color.parseColor("#38ada8"));
//        } else if (position % 11 == 1) {
//            holder.linearLayout.setBackgroundColor(Color.parseColor("#efc41d"));
//        } else if (position % 11 == 2) {
//            holder.linearLayout.setBackgroundColor(Color.parseColor("#736357"));
//        } else if (position % 11 == 3) {
//            holder.linearLayout.setBackgroundColor(Color.parseColor("#d77a27"));
//        } else if (position % 11 == 4) {
//            holder.linearLayout.setBackgroundColor(Color.parseColor("#23a0da"));
//        } else if (position % 11 == 5) {
//            holder.linearLayout.setBackgroundColor(Color.parseColor("#6abd96"));
//        } else if (position % 11 == 6) {
//            holder.linearLayout.setBackgroundColor(Color.parseColor("#ec1a23"));
//        } else if (position % 11 == 7) {
//            holder.linearLayout.setBackgroundColor(Color.parseColor("#005e60"));
//        } else if (position % 11 == 8) {
//            holder.linearLayout.setBackgroundColor(Color.parseColor("#ec6051"));
//        } else if (position % 11 == 9) {
//            holder.linearLayout.setBackgroundColor(Color.parseColor("#006699"));
//        }else if (position % 11 == 10) {
//            holder.linearLayout.setBackgroundColor(Color.parseColor("#ff6838"));
//        }

                holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
