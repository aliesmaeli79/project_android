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
            return new BannerItems(item);
        }
        else if(viewType==1){
            View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.app_list_item,null,false);
            return  new AppItems(item);
        }
        else if(viewType==2){
            View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item,null,false);
            return  new BookItems(item);
        }
        else
            return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof  BannerItems){

            BannerListItem item= (BannerListItem) mItems.get(position);

            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(((BannerItems) holder).list1.getContext());

            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

            ((BannerItems) holder).list1.setLayoutManager(linearLayoutManager);
            BannerListAdapter bannerListAdapter=new BannerListAdapter(item.getItems());
            ((BannerItems) holder).list1.setAdapter(bannerListAdapter);

        }
        else if(holder instanceof AppItems){
            AppListItem item= (AppListItem) mItems.get(position);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(((AppItems) holder).list2.getContext());

            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

            ((AppItems) holder).list2.setLayoutManager(linearLayoutManager);
            AppListAdapter appListAdapter=new AppListAdapter(item.getItems());
            ((AppItems) holder).list2.setAdapter(appListAdapter);



        }
        else if(holder instanceof BookItems){
            BookListItem item= (BookListItem) mItems.get(position);
            ((BookItems) holder).text_title.setText(item.getTitle());

            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(((BookItems) holder).list3.getContext());

            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

            ((BookItems) holder).list3.setLayoutManager(linearLayoutManager);
            BookListAdapter bookListAdapter=new BookListAdapter(item.getItems());
            ((BookItems) holder).list3.setAdapter(bookListAdapter);

        }

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
    @Override
    public int getItemViewType(int position) {
        if(mItems.get(position) instanceof BannerListItem)
            return 0;
        else if(mItems.get(position) instanceof AppListItem)
            return 1;
        else if (mItems.get(position) instanceof BookListItem)
            return 2;
        else
            return 3;
    }

    class BannerItems extends RecyclerView.ViewHolder{

        protected RecyclerView list1;
        protected ImageView image;
        protected LinearLayout linearLayout;

        public BannerItems(@NonNull View itemView) {
            super(itemView);
            list1=itemView.findViewById(R.id.banner_list);
            image=itemView.findViewById(R.id.img_banner);
            linearLayout=itemView.findViewById(R.id.Linear_list_banner);
        }
    }

    class AppItems extends RecyclerView.ViewHolder{


        protected RecyclerView list2;
        protected LinearLayout linearLayout;
        protected ImageView image;

        public AppItems(@NonNull View itemView) {
            super(itemView);

            list2=itemView.findViewById(R.id.app_list);
            image=itemView.findViewById(R.id.img_app);
            linearLayout=itemView.findViewById(R.id.Linear_list_app);

        }
    }

    class BookItems extends RecyclerView.ViewHolder{


        protected TextView text_title;
        protected RecyclerView list3;
        protected ImageView image;
        protected LinearLayout linearLayout;

        public BookItems(@NonNull View itemView) {
            super(itemView);

            text_title=itemView.findViewById(R.id.text_title_list);
            list3=itemView.findViewById(R.id.book_list);
            image=itemView.findViewById(R.id.img_book);
            linearLayout=itemView.findViewById(R.id.Linear_list_book);
        }
    }
}
