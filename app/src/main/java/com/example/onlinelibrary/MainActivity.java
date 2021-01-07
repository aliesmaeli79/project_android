package com.example.onlinelibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Object> listItem=generateItems();

        ListAdapter adapter=new ListAdapter(listItem);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Object> generateItems() {
        ArrayList<Object> data = new ArrayList<>();

        ArrayList<BannerItem> bannerItems=new ArrayList<>();
        bannerItems.add(new BannerItem(R.drawable.banner));
        bannerItems.add(new BannerItem(R.drawable.banner));
        bannerItems.add(new BannerItem(R.drawable.banner));
        BannerListItem bannerListItem = new BannerListItem("پربازديد ترين ها", bannerItems);
        data.add(bannerListItem);

        ArrayList<AppItem> appItems=new ArrayList<>();
        appItems.add(new AppItem("بيشتر بدانيد",R.drawable.item));
        appItems.add(new AppItem("مقالات علمي",R.drawable.item));
        appItems.add(new AppItem("حلقه هاي كتاب خواني",R.drawable.item));
        appItems.add(new AppItem("برنامه مطالعاتي",R.drawable.item));

        AppListItem appListItem=new AppListItem("پرفروش ترين ها",appItems);
        data.add(appListItem);

        ArrayList<BookItem> bookItems =new ArrayList<>();
        bookItems.add(new BookItem(R.drawable.book_test));
        bookItems.add(new BookItem(R.drawable.book_test));
        bookItems.add(new BookItem(R.drawable.book_test));
        bookItems.add(new BookItem(R.drawable.book_test));
        bookItems.add(new BookItem(R.drawable.book_test));
        bookItems.add(new BookItem(R.drawable.book_test));

        BookListItem bookListItem=new BookListItem(bookItems);
        data.add(bookListItem);

        return data;

    }
    }