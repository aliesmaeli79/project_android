package com.example.onlinelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {

    EditText name, pass;
    TextView create_account;
    AppCompatButton login;
    static DataBaseUser database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new DataBaseUser(this);

        name = findViewById(R.id.username_login);
        pass = findViewById(R.id.password_login);

        create_account = findViewById(R.id.create_account);

        login = findViewById(R.id.button_login);


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
                            Intent intent = new Intent(MainActivity.this, Activity_after_sign_in.class);
                            startActivity(intent);
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
                Intent i = new Intent(MainActivity.this, Activity_create_account.class);
                startActivity(i);
            }

        });




    }

    }