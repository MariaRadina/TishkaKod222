package com.example.tishka;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tishka.databinding.ActivityMainBinding;
import com.example.tishka.databinding.ActivityRegistrBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Registr extends AppCompatActivity {
    private ActivityRegistrBinding binding;
    private Button loginBtn, zadBtn;
    private ImageView strelka;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        strelka=(ImageView) findViewById(R.id.strelka);
        strelka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(Registr.this, Admin.class);
                startActivity(regIntent);
            }
        });

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.loginPhoneImput.getText().toString().isEmpty() || binding.loginPasswordImput.getText().toString().isEmpty()) {
                    makeText(getApplicationContext(), "Поле не может быть пустое", Toast.LENGTH_SHORT).show();
                }
                else{
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.loginPhoneImput.getText().toString(),binding.loginPasswordImput.getText().toString());
                    HashMap<String,String>userInfo= new HashMap<>();
                userInfo.put("email", binding.loginPhoneImput.getText().toString());
                userInfo.put("password", binding.loginPasswordImput.getText().toString());
                FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(userInfo);


                startActivity(new Intent(Registr.this,MainActivity.class ));
                }
            }
        });



    }
}