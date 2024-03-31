package com.example.tishka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.tishka.DobMaterObych.ObyyychDobmat;
import com.example.tishka.RycovodstvoPoBezopasnosti.RykovtsvoPoBezopasnosti;

public class ObychaMater extends AppCompatActivity {
    private ImageView strelka;
    private Button loginBtn1,loginBtn2,loginBtn3, zadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obycha_mater);

        strelka=(ImageView) findViewById(R.id.strelka);
        strelka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(ObychaMater.this, Admin.class);
                startActivity(regIntent);
            }
        });
        loginBtn1=(Button) findViewById(R.id.login_btn);
        loginBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(ObychaMater.this, ObyyychDobmat.class);
                startActivity(regIntent);
            }
        });
        loginBtn2=(Button) findViewById(R.id.login_btn2);
        loginBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(ObychaMater.this, Instrukcia.class);
                startActivity(regIntent);
            }
        });
        loginBtn3=(Button) findViewById(R.id.login_btn3);
        loginBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(ObychaMater.this, RykovtsvoPoBezopasnosti.class);
                startActivity(regIntent);
            }
        });
    }
}