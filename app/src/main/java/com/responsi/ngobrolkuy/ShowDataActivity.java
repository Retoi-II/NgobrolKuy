package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class ShowDataActivity extends AppCompatActivity {

    private ImageView btn_settings;
    private Intent data, settings;
    private String username, email, password;
    private Uri uri_avatar;
    private ConstraintLayout btn_kolom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        btn_settings = findViewById(R.id.settings_btn);
        btn_kolom = findViewById(R.id.kolom1);



        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = getIntent();

                settings = new Intent(ShowDataActivity.this, SettingsActivity.class);

                username = data.getStringExtra("username");
                settings.putExtra("username", username);

                password = data.getStringExtra("password");
                settings.putExtra("password", password);

                email = data.getStringExtra("email");
                settings.putExtra("email", email);

                if(data.hasExtra("uri_avatar")) {
                    uri_avatar = data.getParcelableExtra("uri_avatar");
                    settings.putExtra("uri_avatar", uri_avatar);
                }

                startActivity(settings);
            }
        });
    }
}