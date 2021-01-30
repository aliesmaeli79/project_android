package com.example.onlinelibrary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import static com.example.onlinelibrary.MainActivity.database;
import static com.example.onlinelibrary.MainActivity.userAccount;

public class Fragment_setting extends Fragment {

    EditText name_new,password_old,password_new,email_new;
    ImageView name_arrow,password_arrow, email_arrow;
    LinearLayout name_box,password_box, email_box;
    AppCompatButton name_button,password_button, email_button;

    CounterArrow counterArrow;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setting, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        counterArrow = new CounterArrow();

        name_box = view.findViewById(R.id.change_name_box);
        password_box = view.findViewById(R.id.change_password_box);
        email_box = view.findViewById(R.id.change_email_box);

        name_arrow = view.findViewById(R.id.arrow_name);
        password_arrow = view.findViewById(R.id.arrow_password);
        email_arrow = view.findViewById(R.id.arrow_email);

        name_new = view.findViewById(R.id.name_new_setting);
        password_old = view.findViewById(R.id.password_past_setting);
        password_new = view.findViewById(R.id.password_new_setting);
        email_new = view.findViewById(R.id.email_new_setting);
        
        name_button = view.findViewById(R.id.button_name_setting);
        password_button = view.findViewById(R.id.button_password_setting);
        email_button = view.findViewById(R.id.button_email_setting);



        name_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!counterArrow.isCounter_name_arrow()) {
                    counterArrow.setCounter_name_arrow(!counterArrow.isCounter_name_arrow());
                    name_box.setVisibility(View.VISIBLE);
                    name_arrow.setImageResource(R.drawable.arrow_down);
                } else {
                    counterArrow.setCounter_name_arrow(!counterArrow.isCounter_name_arrow());
                    name_box.setVisibility(View.GONE);
                    name_arrow.setImageResource(R.drawable.arrow_left);
                }
            }
        });
        password_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!counterArrow.isCounter_pass_arrow()) {
                    counterArrow.setCounter_pass_arrow(!counterArrow.isCounter_pass_arrow());
                    password_box.setVisibility(View.VISIBLE);
                    password_arrow.setImageResource(R.drawable.arrow_down);

                } else {
                    counterArrow.setCounter_pass_arrow(!counterArrow.isCounter_pass_arrow());
                    password_box.setVisibility(View.GONE);
                    password_arrow.setImageResource(R.drawable.arrow_left);
                }
            }
        });
        email_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!counterArrow.isCounter_email_arrow()) {
                    counterArrow.setCounter_email_arrow(!counterArrow.isCounter_email_arrow());
                    email_box.setVisibility(View.VISIBLE);
                    email_arrow.setImageResource(R.drawable.arrow_down);

                } else {
                    counterArrow.setCounter_email_arrow(!counterArrow.isCounter_email_arrow());
                    email_box.setVisibility(View.GONE);
                    email_arrow.setImageResource(R.drawable.arrow_left);
                }
            }
        });

        name_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name;
                if (name_new.getText().toString().length() > 0) {
                    name = name_new.getText().toString();
                    if (!name.equals(userAccount.getName())) {
                        if (database.updateNameDb(userAccount.getName(), name)) {
                            userAccount.setName(name);
                            Toast.makeText(getActivity(), "تغییر نام بت موفقیت ثبت شد", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "حسابی با این نام موجود است", Toast.LENGTH_SHORT).show();
                            name_new.setText("");
                            name_new.requestFocus();
                        }
                    } else {
                        Toast.makeText(getActivity(), "نام کاربری یکسان است", Toast.LENGTH_SHORT).show();
                        name_new.setText("");
                        name_new.requestFocus();
                    }
                } else {
                    name_new.requestFocus();
                }
            }
        });
        password_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass1 = password_old.getText().toString(), pass2 = password_new.getText().toString();
                if (!pass1.equals(pass2)) {
                    if (pass1.length() >= 5 && pass2.length() >= 5) {
                        if (pass1.equals(userAccount.getPassword())) {
                            database.updatePasswordDb(userAccount.getName(), pass2);
                            userAccount.setPassword(pass2);
                            Toast.makeText(getActivity(), "رمز جدید با موفقیت تغییر کرد", Toast.LENGTH_SHORT).show();
                        } else {
                            password_new.setText("");
                            password_old.setText("");
                            password_old.requestFocus();
                        }
                    } else {
                        Toast.makeText(getActivity(), "تعداد رمز کمتر از 5 کارکتر است", Toast.LENGTH_SHORT).show();
                        password_new.setText("");
                        password_old.setText("");
                        password_old.requestFocus();
                    }
                } else {
                    password_new.setText("");
                    password_old.setText("");
                    password_old.requestFocus();
                    Toast.makeText(getActivity(), "رمز یکسان است", Toast.LENGTH_SHORT).show();
                }
            }
        });
        email_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = email_new.getText().toString();
                if (em.length() > 10) {
                    if (database.updateEmailDb(userAccount.getName(), em)) {
                        Toast.makeText(getActivity(), "تغییر ایمیل با موفقیت انجام شد", Toast.LENGTH_SHORT).show();
                        email_new.setText("");
                    } else {
                        email_new.setText("");
                        email_new.requestFocus();
                        Toast.makeText(getActivity(), "ایمیل یکسان است", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "ایمیل وارد شده معتبر نیست", Toast.LENGTH_SHORT).show();
                }

            }
        });
        


    }
}
