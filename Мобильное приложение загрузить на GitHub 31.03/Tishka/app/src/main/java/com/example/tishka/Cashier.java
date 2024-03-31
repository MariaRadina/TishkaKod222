package com.example.tishka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Cashier extends AppCompatActivity {
    private ImageView strelka;
    private Button loginBtn,loginBtn2,loginBtn3, zadBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier);

        strelka=(ImageView) findViewById(R.id.strelka);
        strelka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(Cashier.this, MainActivity.class);
                startActivity(regIntent);
            }
        });
        loginBtn=(Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(Cashier.this, Ypravkasir.class);
                startActivity(regIntent);
            }
        });
        loginBtn2=(Button) findViewById(R.id.login_btn2);
        loginBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(Cashier.this, ypravlenzapasami.class);
                startActivity(regIntent);
            }
        });
        loginBtn3=(Button) findViewById(R.id.login_btn3);
        loginBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(Cashier.this, ObyhMaterKasir.class);
                startActivity(regIntent);
            }
        });
    }
}