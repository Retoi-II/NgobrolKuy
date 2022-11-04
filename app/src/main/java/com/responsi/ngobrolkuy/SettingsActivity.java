package com.responsi.ngobrolkuy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class SettingsActivity extends AppCompatActivity {

    private TextView tv_username, tv_email, tv_password;
    private String username, email, password;
    private Uri uri_avatar;
    private CircleImageView profile;
    private ImageView btn_back, btn_profile;
    private Intent data, back;
    private CardView back_btn, pass_ch;

    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        tv_username = findViewById(R.id.username_tv);
        tv_email = findViewById(R.id.email_tv);
        tv_password = findViewById(R.id.password_tv);
        profile = findViewById(R.id.profilePic);
        btn_back = findViewById(R.id.back_btn);
        back_btn = findViewById(R.id.back_login_btn);
        btn_profile = findViewById(R.id.pinkCircle);
        pass_ch = findViewById(R.id.ganti_pass);

        data = getIntent();
        username = data.getStringExtra("username");
        email = data.getStringExtra("email");
        password = data.getStringExtra("password");

        tv_username.setText(username);
        tv_email.setText(email);
        tv_password.setText(password);


        if(data.hasExtra("uri_avatar")) {
            uri_avatar = data.getParcelableExtra("uri_avatar");
            try {
                Bitmap avatarBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri_avatar);
                profile.setImageBitmap(avatarBitmap);
            } catch(IOException e) {
                Toast.makeText(SettingsActivity.this,
                        "Tidak bisa memuat gambar",
                        Toast.LENGTH_SHORT).show();
                Log.e(TAG, e.getMessage());
            }
        }

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back = new Intent(SettingsActivity.this, ShowDataActivity.class);

                startActivity(back);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, ShowDataActivity.class));
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), GALLERY_REQUEST_CODE);
            }
        });

        pass_ch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, GantiPasswordActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_CANCELED) {
            Toast.makeText(SettingsActivity.this,
                    "Batal menambahkan gambar",
                    Toast.LENGTH_SHORT).show();

            return;
        } else if(requestCode == GALLERY_REQUEST_CODE) {
            if(!Objects.equals(data, null)) {
                try {
                    uri_avatar = data.getData();
                    Bitmap bitmap_avatar = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri_avatar);
                    profile.setImageBitmap(bitmap_avatar);
                } catch (IOException e) {
                    Toast.makeText(SettingsActivity.this,
                            "Tidak bisa memuat gambar",
                            Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
}