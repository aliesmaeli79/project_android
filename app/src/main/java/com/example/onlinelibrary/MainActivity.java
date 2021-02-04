package com.example.onlinelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.onlinelibrary.GlobalRequestItem.RESPONSE_ITEM;
import static com.example.onlinelibrary.GlobalRequestItem.RESPONSE_ITEM1;

public class MainActivity extends AppCompatActivity {

    EditText name, pass;
    TextView create_account;
    AppCompatButton login;
    static DataBaseUser database;
    static UserAccount userAccount;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new DataBaseUser(this);

        name = findViewById(R.id.username_login);
        pass = findViewById(R.id.password_login);




        create_account = findViewById(R.id.create_account);

        login = findViewById(R.id.button_login);


        ApiInterface request;

        String url="http://uniproject.freecloudsite.com/data/";
        request=ApiClient.getApiClient(url).create(ApiInterface.class);

        request.getdata().enqueue(new Callback<List<Books>>() {
            @Override
            public void onResponse(Call<List<Books>> call, Response<List<Books>> response) {
                RESPONSE_ITEM =response.body();
            }

            @Override
            public void onFailure(Call<List<Books>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("ERROR",t.getMessage()+"");
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_user = name.getText().toString();
                String pass_user = pass.getText().toString();

                if (pass_user.length() == 0 ) {
                    if (name_user.length() > 0) {
                        Toast.makeText(MainActivity.this, "لطفا پسورد را وارد کنید", Toast.LENGTH_SHORT).show();
                        pass.requestFocus();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "لطفا نام کاربری و پسورد را وارد کنید", Toast.LENGTH_SHORT).show();
                        name.requestFocus();
                    }
                }

                if (pass_user.length() > 0 && pass_user.length() < 5) {
                    if (name_user.length() == 0) {
                        Toast.makeText(MainActivity.this, "لطفا نام کاربری را وارد کنید", Toast.LENGTH_SHORT).show();
                        pass.setText("");
                        name.requestFocus();
                    } else {
                        Toast.makeText(MainActivity.this, "تعداد پسورد کمتر از 5 کارکتر است", Toast.LENGTH_SHORT).show();
                        pass.setText("");
                        pass.requestFocus();
                    }

                }

                if (pass_user.length() >= 5){
                    if (name_user.length() == 0) {
                        Toast.makeText(MainActivity.this, "لطفا نام کاربری را وارد کنید", Toast.LENGTH_SHORT).show();
                        name.setText("");
                        name.requestFocus();
                    }
                    else {
                        String pass_sent = database.checkUserFromDb(name_user);
                        if (pass_sent.length() != 0) {
                            if (pass_sent.equals(pass_user)) {
                                userAccount = new UserAccount();
                                userAccount.setName(name_user);
                                userAccount.setPassword(pass_sent);

//                                ApiInterface request;
//
//                                String url="http://uniproject.freecloudsite.com/data/";
//                                request=ApiClient.getApiClient(url).create(ApiInterface.class);
//
//                                request.getdata().enqueue(new Callback<List<Books>>() {
//                                    @Override
//                                    public void onResponse(Call<List<Books>> call, Response<List<Books>> response) {
//                                        RESPONSE_ITEM =response.body();
//                                    }
//
//                                    @Override
//                                    public void onFailure(Call<List<Books>> call, Throwable t) {
//                                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//                                        Log.e("ERROR",t.getMessage()+"");
//                                    }
//                                });
                                RESPONSE_ITEM1=RESPONSE_ITEM;
                                if(RESPONSE_ITEM.size()!=0) {
                                    Intent intent = new Intent(MainActivity.this, Activity_after_sign_in.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "لطفا یک بار دیگر کلید ورود را فشار دهید", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MainActivity.this, "پسورد نامعتبر است", Toast.LENGTH_SHORT).show();
                                pass.setText("");
                                pass.requestFocus();
                            }

                        } else {
                            Toast.makeText(MainActivity.this, "اکانت وجود ندارد", Toast.LENGTH_SHORT).show();
                            name.setText("");
                            pass.setText("");
                            name.requestFocus();
                        }
                    }
                }
            }
        });


        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_create_account.class);
                startActivity(intent);
            }

        });




    }

    }