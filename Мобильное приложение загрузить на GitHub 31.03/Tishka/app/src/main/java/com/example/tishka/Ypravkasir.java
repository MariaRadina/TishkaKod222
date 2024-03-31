package com.example.tishka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Ypravkasir extends AppCompatActivity {
    private ImageView strelka;
    private Button loginBtn,loginBtn2, zadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ypravkasir);

        strelka=(ImageView) findViewById(R.id.strelka);
        strelka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(Ypravkasir.this, Cashier.class);
                startActivity(regIntent);
            }
        });
    }
}