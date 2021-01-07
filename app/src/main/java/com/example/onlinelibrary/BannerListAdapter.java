package com.example.onlinelibrary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BannerListAdapter extends RecyclerView.Adapter<BannerListAdapter.BannerItemView> {

    private ArrayList<BannerItem> bannerItem =new ArrayList<>();
     BannerListAdapter(ArrayList<BannerItem> items){
         bannerItem.addAll(items);
    }

    @NonNull
    @Override
    public BannerItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_item,null,false);
        return new BannerItemView(item);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerItemView holder, int position) {
         BannerItem banner=bannerItem.get(position);
         holder.img.setImageResource(banner.getImg());
    }

    @Override
    public int getItemCount() {
        return bannerItem.size();
    }
    class  BannerItemView extends  RecyclerView.ViewHolder{

        protected ImageView img;
        protected LinearLayout linearLayout;

        public BannerItemView(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_banner);
            linearLayout=itemView.findViewById(R.id.Linear_Banner);

        }
    }
}
