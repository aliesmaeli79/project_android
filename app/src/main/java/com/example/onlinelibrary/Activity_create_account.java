package com.example.onlinelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Activity_create_account extends AppCompatActivity {
    AppCompatButton button_create;
    CheckBox checkBox;
    EditText name,pass,email, pass1;
    DataBaseUser dataBaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        dataBaseUser = new DataBaseUser(this);

        button_create = findViewById(R.id.button_create);
        checkBox = findViewById(R.id.checkbox_tick);

        name = findViewById(R.id.username_create);
        pass = findViewById(R.id.password_create1);
        pass1 = findViewById(R.id.password_create2);
        email = findViewById(R.id.email_create);


        if (button_create.isClickable()) {
            button_create.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name_user = name.getText().toString();
                    String pass_user = pass.getText().toString();
                    String pass1_user = pass1.getText().toString();
                    String email_user = email.getText().toString();


                    if (name_user.length() == 0 )
                        name.requestFocus();

                    else{
                        if(pass_user.length()==0)
                            pass.requestFocus();

                        else {
                            if (pass_user.length() < 5) {
                                Toast.makeText(Activity_create_account.this, "تعداد پسورد کمتر از 5 کارکتر است", Toast.LENGTH_SHORT).show();
                                pass.requestFocus();
                            } else {
                                if (pass1_user.length() == 0) {
                                    pass1.requestFocus();
                                } else {
                                    if (!pass1_user.equals(pass_user)) {
                                        Toast.makeText(Activity_create_account.this, "پسورد ها برابر نیستند", Toast.LENGTH_SHORT).show();
                                        pass.setText("");
                                        pass1.setText("");
                                        pass.requestFocus();
                                    } else {
                                        if (email_user.length() == 0) {
                                            email.requestFocus();
                                        } else {
                                            if (email_user.length() <= 10) {
                                                Toast.makeText(Activity_create_account.this, "ایمیل نامعتبر است", Toast.LENGTH_SHORT).show();
                                                email.setText("");
                                                email.requestFocus();
                                            } else {
                                                UserAccount userAccount = new UserAccount();
                                                userAccount.setName(name_user);
                                                userAccount.setPassword(pass_user);
                                                userAccount.setEmail(email_user);
                                                userAccount.setCounter("1");
                                                if (dataBaseUser.insertToDb(userAccount)) {
                                                    Toast.makeText(Activity_create_account.this, "ثبت با موفقیت انجام شد", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(Activity_create_account.this, MainActivity.class);
                                                    startActivity(intent);
                                                    finish();
                                                } else {
                                                    Toast.makeText(Activity_create_account.this, "حساب با این نام موجود است", Toast.LENGTH_LONG).show();
                                                    name.setText("");
                                                    name.requestFocus();
                                                }

                                            }
                                        }
                                    }
                                }
                            }

                        }

                    }

                }
            });
        }


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.getId() == checkBox.getId()) {
                    if (isChecked) {
                        button_create.setEnabled(true);
                    } else {
                        button_create.setEnabled(false);
                    }
                }
            }
        });
    }
}