package com.example.onlinelibrary;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import static com.example.onlinelibrary.GlobalRequestItem.RESPONSE_ITEM;

public class Activity_after_sign_in extends AppCompatActivity {

    BottomNavigationView navigation;


    EditText search_bar;

    FrameLayout frameLayout;
    RelativeLayout relativeLayout;

    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sign_in);


        search_bar=findViewById(R.id.search_book);

        frameLayout=findViewById(R.id.frame_for_fragment);

        relativeLayout=findViewById(R.id.relative_layout_search);

        recyclerView=findViewById(R.id.recyclerview_search);

        navigation = findViewById(R.id.bottom_navigation);

        navigation.setSelectedItemId(R.id.home);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_for_fragment, new Fragment_home()).commit();

         navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                 Fragment currentFragment = null;

                 switch (item.getItemId()) {
                     case R.id.setting:
                         currentFragment = new Fragment_setting();
                         break;
                     case R.id.home:
                         currentFragment = new Fragment_home();
                         break;
                     case R.id.Contents:
                         currentFragment = new Fragment_contents();
                         break;
                     case R.id.Guide:
                         currentFragment=new Fragment_guide() ;
                         break;
                     case R.id.My_account:
                         currentFragment=new FragmentAccountMe();
                         break;
                 }
                 getSupportFragmentManager().beginTransaction()
                         .replace(R.id.frame_for_fragment, currentFragment).commit();


                 return true;
             }
         });



//         search_bar.addTextChangedListener(new TextWatcher() {
//             @Override
//             public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//             }
//
//             @Override
//             public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//             }
//
//             @Override
//             public void afterTextChanged(Editable s) {
//                 if(s.length()!=0){
//
//                     frameLayout.setVisibility(View.GONE);
//                     relativeLayout.setVisibility(View.VISIBLE);
//
//                     int size = RESPONSE_ITEM.size();
//                     ArrayList<Books> books = new ArrayList<>();
//                     Books aux ;
//                     for(int i=0;i<=size-1;i++){
//                         aux=  RESPONSE_ITEM.get(i);
//                         if(aux.getName().equals(s)){
//                             books.add(aux);
//                         }
//
//                     }
//
//                     recyclerView.setLayoutManager(new LinearLayoutManager(Activity_after_sign_in.this));
//                     SearchAdapter adapter=new SearchAdapter(books);
//
//                     recyclerView.setAdapter(adapter);
//
//                 }
//
//                 else{
//                     relativeLayout.setVisibility(View.GONE);
//                     frameLayout.setVisibility(View.VISIBLE);
//                 }
//             }
//         });


         search_bar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String name_book=search_bar.getText().toString();

                 if(name_book.length()!=0){

                     frameLayout.setVisibility(View.GONE);
                     relativeLayout.setVisibility(View.VISIBLE);

                     int size = RESPONSE_ITEM.size();
                     ArrayList<Books> books = new ArrayList<>();
                     Books aux ;
                     for(int i=0;i<=size-1;i++){
                         aux=  RESPONSE_ITEM.get(i);
                         if(aux.getName().equals(name_book)){
                             books.add(aux);
                         }

                     }

                     recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
                     SearchAdapter adapter=new SearchAdapter(books);

                     recyclerView.setAdapter(adapter);

                 }

                 else{
                     relativeLayout.setVisibility(View.GONE);
                     frameLayout.setVisibility(View.VISIBLE);
                 }
             }
         });







    }

}