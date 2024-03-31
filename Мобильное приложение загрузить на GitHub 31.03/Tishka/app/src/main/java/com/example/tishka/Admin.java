package com.example.tishka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Admin extends AppCompatActivity {
    private ImageView strelka;
    private Button loginBtn, loginBtn2,loginBtn3, loginBtn4,zadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        strelka=(ImageView) findViewById(R.id.strelka);
        strelka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(Admin.this, MainActivity.class);
                startActivity(regIntent);
            }
        });
        loginBtn=(Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(Admin.this, ypravlenzapasami.class);
                startActivity(regIntent);
            }
        });
        loginBtn2=(Button) findViewById(R.id.login_btn2);
        loginBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(Admin.this, Klientandzakaz.class);
                startActivity(regIntent);
            }
        });
        loginBtn3=(Button) findViewById(R.id.login_btn3);
        loginBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(Admin.this, ObychaMater.class);
                startActivity(regIntent);
            }
        });
        loginBtn4=(Button) findViewById(R.id.login_btn4);
        loginBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(Admin.this, Registr.class);
                startActivity(regIntent);
            }
        });
    }
}