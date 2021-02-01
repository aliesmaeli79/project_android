package com.example.onlinelibrary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

        @GET("getData.php")
        Call<List<Books>> getdata();


}
