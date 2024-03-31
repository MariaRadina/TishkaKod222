package com.example.tishka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class Instrukcia extends AppCompatActivity {
    private String TextInfo, saveCurrentDate, saveCurrentTime, InfoRandomKey;
    private ImageView strelka;
    private EditText info;
    private Button addInfo;

    private DatabaseReference InfoRef;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrukcia);

        init();


        strelka=(ImageView) findViewById(R.id.strelka);
        strelka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(Instrukcia.this, ObychaMater.class);
                startActivity(regIntent);
            }
        });

        addInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateInfoData();
            }
        });

    }

    private void ValidateInfoData() {
        TextInfo = info.getText().toString();

        if(TextUtils.isEmpty(TextInfo)){
            Toast.makeText(this, "Добавте текст", Toast.LENGTH_SHORT).show();
        }
        else {
            StoreProductInformation();
        }
    }

    private void StoreProductInformation() {
        Calendar calendar = Calendar.getInstance();

        loadingBar.setTitle("Загрузка данных");
        loadingBar.setMessage("Пожалуйста, подождите...");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();

        SimpleDateFormat currentDate = new SimpleDateFormat("ddMMyyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HHmmss");
        saveCurrentTime = currentTime.format(calendar.getTime());

        InfoRandomKey = saveCurrentDate + saveCurrentTime;

SaveInfoDataBase();
    }

    private void SaveInfoDataBase() {
        HashMap<String, Object> productMap = new HashMap<>();

        productMap.put("pid", InfoRandomKey);
        productMap.put("date", saveCurrentDate);
        productMap.put("time", saveCurrentTime);
        productMap.put("info", TextInfo);

        InfoRef.child(InfoRandomKey).updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

                    loadingBar.dismiss();
                    Toast.makeText(Instrukcia.this, "Информация добавлена", Toast.LENGTH_SHORT).show();

                    Intent regIntent= new Intent(Instrukcia.this, ObychaMater.class);
                    startActivity(regIntent);
                }
                else {
                    String message = task.getException().toString();
                    Toast.makeText(Instrukcia.this, "Ошибка:" + message, Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                }
            }
        });

    }

    private void init(){
        info= findViewById(R.id.editTextInstr);
        addInfo= findViewById(R.id.login_btn4);
        InfoRef= FirebaseDatabase.getInstance().getReference().child("Info");
        loadingBar =new ProgressDialog(this);

    }
}