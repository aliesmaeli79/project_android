package com.example.onlinelibrary;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_home extends Fragment {

    RecyclerView list;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = view.findViewById(R.id.list_main);

        list.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<Object> listItem = generateItems();
        ListAdapter adapter = new ListAdapter(listItem);

        list.setAdapter(adapter);


    }


    private ArrayList<Object> generateItems() {
        ArrayList<Object> data = new ArrayList<>();



        ArrayList<BannerItem> bannerItems=new ArrayList<>();
        bannerItems.add(new BannerItem(R.drawable.banner));
        bannerItems.add(new BannerItem(R.drawable.banner));
        bannerItems.add(new BannerItem(R.drawable.banner));
        BannerListItem bannerListItem = new BannerListItem(bannerItems);
        data.add(bannerListItem);

        ArrayList<AppItem> appItems=new ArrayList<>();
        appItems.add(new AppItem("بيشتر بدانيد  ",R.drawable.more));
        appItems.add(new AppItem("مقالات علمی  ",R.drawable.scientific_articles));
        appItems.add(new AppItem("حلقه های     ",R.drawable.reading_circles));
        appItems.add(new AppItem("برنامه مطالعاتی",R.drawable.studyprogram));

        AppListItem appListItem=new AppListItem(appItems);
        data.add(appListItem);

        ArrayList<BookItem> bookItems =new ArrayList<>();


        bookItems.add(new BookItem(R.drawable.book_test));
        bookItems.add(new BookItem(R.drawable.book_test));
        bookItems.add(new BookItem(R.drawable.book_test));
        bookItems.add(new BookItem(R.drawable.book_test));
        bookItems.add(new BookItem(R.drawable.book_test));

        BookListItem bookListItem=new BookListItem("پربازدیدترینها",bookItems);
        data.add(bookListItem);

        ArrayList<BookItem> bookItems1 =new ArrayList<>();
        bookItems1.add(new BookItem(R.drawable.book_test));
        bookItems1.add(new BookItem(R.drawable.book_test));
        bookItems1.add(new BookItem(R.drawable.book_test));
        bookItems1.add(new BookItem(R.drawable.book_test));
        bookItems1.add(new BookItem(R.drawable.book_test));
        bookItems1.add(new BookItem(R.drawable.book_test));

        BookListItem bookListItem1=new BookListItem("پرفروش ترینها",bookItems);
        data.add(bookListItem1);

        ArrayList<BookItem> bookItems2 =new ArrayList<>();
        bookItems2.add(new BookItem(R.drawable.book_test));
        bookItems2.add(new BookItem(R.drawable.book_test));
        bookItems2.add(new BookItem(R.drawable.book_test));
        bookItems2.add(new BookItem(R.drawable.book_test));
        bookItems2.add(new BookItem(R.drawable.book_test));
        bookItems2.add(new BookItem(R.drawable.book_test));

        BookListItem bookListItem2=new BookListItem("جدید ترین ها",bookItems);
        data.add(bookListItem2);

        return data;

    }


}
