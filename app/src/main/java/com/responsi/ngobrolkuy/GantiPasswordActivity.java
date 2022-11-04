package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class GantiPasswordActivity extends AppCompatActivity {

    private EditText et_password, btn_terapkan;
    private String password;
    private Intent terapkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganti_password);

        et_password = findViewById(R.id.password_et);
        btn_terapkan = findViewById(R.id.terapkan_btn);

        btn_terapkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password = et_password.getText().toString();

                terapkan = new Intent(GantiPasswordActivity.this, GantiPasswordActivity.class);

                terapkan.putExtra("password", password);
                startActivity(terapkan);
            }
        });

    }
}