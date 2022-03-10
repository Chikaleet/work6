package com.geektech.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText tvEmail, tvPassword;
    private Button btnLogin;
    private TextView login, tezsat, tvForget, tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvEmail = findViewById(R.id.geektech);
        tvPassword = findViewById(R.id.chika);
        btnLogin = findViewById(R.id.suerkulov);
        login = findViewById(R.id.login);
        tezsat = findViewById(R.id.tezsat);
        tvForget = findViewById(R.id.tvForget);
        tv1 = findViewById(R.id.tv1);
        chekEditText();
        initListeners();
    }

    private void initListeners() {
        btnLogin.setOnClickListener(view -> {
            if (tvEmail.getText().toString().equals("admin@gmail.com")) {
                if (tvPassword.getText().toString().equals("admin")) {
                    tvEmail.setVisibility(View.GONE);
                    tvPassword.setVisibility(View.GONE);
                    btnLogin.setVisibility(View.GONE);
                    tvForget.setVisibility(View.GONE);
                    tezsat.setVisibility(View.GONE);
                    login.setVisibility(View.GONE);
                    tv1.setVisibility(View.GONE);
                }
            } else {
                Toast.makeText(this, "Вы не правильно ввели пароль или логин", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void chekEditText() {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (tvEmail.getText().toString().length() > 0) {
                    if (tvPassword.getText().toString().length() > 0) {
                        btnLogin.setBackgroundResource(R.color.orange);
                    }
                } else {
                    btnLogin.setBackgroundResource(R.color.grey);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
        tvEmail.addTextChangedListener(textWatcher);
        tvPassword.addTextChangedListener(textWatcher);
    }
}