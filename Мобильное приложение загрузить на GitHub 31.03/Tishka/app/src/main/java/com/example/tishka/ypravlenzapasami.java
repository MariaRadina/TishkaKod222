package com.example.tishka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.tishka.DobMaterObych.SpisokObychMaterial;
import com.example.tishka.YprMedekamentami.DobTableMedekament;

public class ypravlenzapasami extends AppCompatActivity {
    private ImageView strelka;
    private Button loginBtn1,loginBtn2, zadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ypravlenzapasami);

        strelka=(ImageView) findViewById(R.id.strelka);
        strelka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(ypravlenzapasami.this, Admin.class);
                startActivity(regIntent);
            }
        });
        loginBtn1=(Button) findViewById(R.id.login_btn);
        loginBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(ypravlenzapasami.this, DobTableMedekament.class);
                startActivity(regIntent);
            }
        });

    }
}