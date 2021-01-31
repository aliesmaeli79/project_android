package com.example.onlinelibrary;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Activity_after_sign_in extends AppCompatActivity {

    BottomNavigationView navigation;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sign_in);


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
                 }
                 getSupportFragmentManager().beginTransaction()
                         .replace(R.id.frame_for_fragment, currentFragment).commit();


                 return true;
             }
         });

    }

}