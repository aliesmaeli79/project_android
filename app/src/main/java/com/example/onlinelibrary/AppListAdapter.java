package com.example.onlinelibrary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.AppItemView> {

    private ArrayList<AppItem> appItem =new ArrayList<>();
    AppListAdapter(ArrayList<AppItem> items){
        appItem.addAll(items);
    }

    @NonNull
    @Override
    public AppItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.app_item,null,false);
        return new AppItemView(item);
    }

    @Override
    public void onBindViewHolder(@NonNull AppItemView holder, int position) {
        AppItem app=appItem.get(position);
        holder.textView.setText(app.getName());
        holder.img.setImageResource(app.getImg());


    }

    @Override
    public int getItemCount() {
        return appItem.size();
    }

    class  AppItemView extends  RecyclerView.ViewHolder{

        protected ImageView img;
        protected TextView textView;
        protected LinearLayout linearLayout;

        public AppItemView(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.img_app);
            textView=itemView.findViewById(R.id.text_app);
            linearLayout=itemView.findViewById(R.id.Linear_app);

        }
    }
}
