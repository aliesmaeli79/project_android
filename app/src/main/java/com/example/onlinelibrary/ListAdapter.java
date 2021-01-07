package com.example.onlinelibrary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Object> mItems =new ArrayList<>();
    ListAdapter(ArrayList<Object> items){
        mItems.addAll(items);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==0){
            View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_list_item,null,false);
            return new BannerItem(item);
        }
        else if(viewType==1){
            View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.app_list_item,null,false);
            return  new AppItem(item);
        }
        else if(viewType==2){
            View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item,null,false);
            return  new BookItem(item);
        }
        else
            return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof  BannerItem){
//            ((BannerItem) holder).img.setImageResource(R.drawable.banner);
            BannerListItem item= (BannerListItem) mItems.get(position);

            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(((BannerItem) holder).list.getContext());

            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

            ((BannerItem) holder).list.setLayoutManager(linearLayoutManager);
            BannerListAdapter bannerListAdapter=new BannerListAdapter(item.getItems());
            ((BannerItem) holder).list.setAdapter(bannerListAdapter);

        }
        else if(holder instanceof AppItem){
            AppListItem item= (AppListItem) mItems.get(position);
            ((AppItem) holder).text.setText(item.getTitle());
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(((AppItem) holder).list.getContext());

            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

            ((AppItem) holder).list.setLayoutManager(linearLayoutManager);
            AppListAdapter appListAdapter=new AppListAdapter(item.getItems());
            ((AppItem) holder).list.setAdapter(appListAdapter);

        }
        else if(holder instanceof BookItem){
            BookListItem item= (BookListItem) mItems.get(position);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(((BookItem) holder).list.getContext());

            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

            ((BookItem) holder).list.setLayoutManager(linearLayoutManager);
            BookListAdapter bookListAdapter=new BookListAdapter(item.getItems());
            ((BookItem) holder).list.setAdapter(bookListAdapter);

        }

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
    @Override
    public int getItemViewType(int position) {
        if(mItems.get(position) instanceof BannerItem)
            return 0;
        else if(mItems.get(position) instanceof AppItem)
            return 1;
        else if (mItems.get(position) instanceof BookItem)
            return 2;
        else
            return 3;
    }

    class BannerItem extends RecyclerView.ViewHolder{

        protected ImageView img;
        protected RecyclerView list;
        protected LinearLayout linearLayout;

        public BannerItem(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_banner);
            list=itemView.findViewById(R.id.banner_list);
            linearLayout=itemView.findViewById(R.id.Linear_list_banner);
        }
    }

    class AppItem extends RecyclerView.ViewHolder{

        protected TextView text;
        protected ImageView img;
        protected RecyclerView list;
        protected LinearLayout linearLayout;

        public AppItem(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_app);
            text=itemView.findViewById(R.id.text_app);
            list=itemView.findViewById(R.id.app_list);
            linearLayout=itemView.findViewById(R.id.Linear_list_app);

        }
    }

    class BookItem extends RecyclerView.ViewHolder{

        protected ImageView img;
        protected  TextView text_title;
        protected RecyclerView list;
        protected LinearLayout linearLayout;

        public BookItem(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.img_book);
            text_title=itemView.findViewById(R.id.text_title_list);
            list=itemView.findViewById(R.id.book_list);
            linearLayout=itemView.findViewById(R.id.Linear_list_book);
        }
    }
}
