package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EmailCheckActivity extends AppCompatActivity {

    private ImageView btn_back;
    private CardView btn_back_login;
    private Intent back, back_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_check);

        btn_back = findViewById(R.id.back_btn);
        btn_back_login = findViewById(R.id.back_login_btn);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back = new Intent(EmailCheckActivity.this, ForgetPassActivity.class);

                startActivity(back);
            }
        });

        btn_back_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back_login = new Intent(EmailCheckActivity.this, LoginActivity.class);

                startActivity(back_login);
            }
        });
    }
}