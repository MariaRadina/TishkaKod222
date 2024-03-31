package com.example.tishka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.tishka.DobMaterObych.SpisokObychMaterial;
import com.example.tishka.RycovodstvoPoBezopasnosti.SoisokRycovodstvPoBezopasnosti;

public class ObyhMaterKasir extends AppCompatActivity {
    private ImageView strelka;
    private Button loginBtn1,loginBtn2,loginBtn3, zadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obyh_mater_kasir);
        strelka=(ImageView) findViewById(R.id.strelka);
        strelka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(ObyhMaterKasir.this, Cashier.class);
                startActivity(regIntent);
            }
        });
        loginBtn1=(Button) findViewById(R.id.login_btn);
        loginBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(ObyhMaterKasir.this, SpisokObychMaterial.class);
                startActivity(regIntent);
            }
        });
        loginBtn2=(Button) findViewById(R.id.login_btn2);
        loginBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(ObyhMaterKasir.this, SpisokInfoPO.class);
                startActivity(regIntent);
            }
        });
        loginBtn3=(Button) findViewById(R.id.login_btn3);
        loginBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(ObyhMaterKasir.this, SoisokRycovodstvPoBezopasnosti.class);
                startActivity(regIntent);
            }
        });
    }
}