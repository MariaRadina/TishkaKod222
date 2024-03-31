package com.example.tishka.YprMedekamentami;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tishka.DobMaterObych.ObyyychDobmat;
import com.example.tishka.Model.Med;
import com.example.tishka.Model.ObechMater;
import com.example.tishka.ObychaMater;
import com.example.tishka.R;
import com.example.tishka.ViewHolder.MedViewHolder;
import com.example.tishka.ViewHolder.ObychMaterialViewHolder;
import com.example.tishka.ypravlenzapasami;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class DobTableMedekament extends AppCompatActivity {

    private String Textname,Textkol,Textzak,Textprod, Textpostav, Textsrokgodn,  saveCurrentDate, saveCurrentTime, InfoRandomKey;
    private ImageView strelka;
    private EditText name,kol, zak, prod, postav, srogodn;
    private Button addInfo;

    private DatabaseReference MRef;
    private ProgressDialog loadingBar;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dob_table_medekament);

        init();

        MRef = FirebaseDatabase.getInstance().getReference().child("Medicines");
        recyclerView = findViewById(R.id.rect);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        strelka=(ImageView) findViewById(R.id.strelka);
        strelka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(DobTableMedekament.this, ypravlenzapasami.class);
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
        Textname = name.getText().toString();
        Textkol = kol.getText().toString();
        Textzak = zak.getText().toString();
        Textprod = prod.getText().toString();
        Textpostav = postav.getText().toString();
        Textsrokgodn = srogodn.getText().toString();

        if(TextUtils.isEmpty(Textname)){
            Toast.makeText(this, "Добавте название препарата", Toast.LENGTH_SHORT).show();
        }
       else if(TextUtils.isEmpty(Textkol)){
            Toast.makeText(this, "Добавте количество препарата", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(Textzak)){
            Toast.makeText(this, "Добавте закупочную цену", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(Textprod)){
            Toast.makeText(this, "Добавте цену продажи", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(Textpostav)){
            Toast.makeText(this, "Добавте поставщика", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(Textsrokgodn)){
            Toast.makeText(this, "Добавте срок годности препарата", Toast.LENGTH_SHORT).show();
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
        productMap.put("name", Textname);
        productMap.put("kol", Textkol);
        productMap.put("zak", Textzak);
        productMap.put("prod", Textprod);
        productMap.put("postav", Textpostav);
        productMap.put("srokgodn", Textsrokgodn);


        MRef.child(InfoRandomKey).updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

                    loadingBar.dismiss();
                    Toast.makeText(DobTableMedekament.this, "Товар добавлена", Toast.LENGTH_SHORT).show();

                    Intent regIntent= new Intent(DobTableMedekament.this, DobTableMedekament.class);
                    startActivity(regIntent);
                }
                else {
                    String message = task.getException().toString();
                    Toast.makeText(DobTableMedekament.this, "Ошибка:" + message, Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                }
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Med> options = new FirebaseRecyclerOptions.Builder<Med>().setQuery(MRef, Med.class).build();

        FirebaseRecyclerAdapter<Med, MedViewHolder> adapter = new FirebaseRecyclerAdapter<Med, MedViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MedViewHolder holder, int position, @NonNull Med Model) {
                holder.Textname.setText("Название препарата: " +Model.getName());
                holder.Textkol.setText("Количество: " +Model.getKol());
                holder.Textzak.setText("Цена закупки: " +Model.getZak()+" Руб");
                holder.Textprod.setText("Цена продажи: " +Model.getProd()+ " Руб");
                holder.Textpostav.setText("Поставщик: " +Model.getPostav());
                holder.Textsrokgodn.setText("Срок годности: " +Model.getSrokgodn());
            }

            @NonNull
            @Override
            public MedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vidmed, parent, false);
                MedViewHolder holder = new MedViewHolder(view);
                return holder;
            }
        };

        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

    private void init(){
        name= findViewById(R.id.editTextInstr);
        kol= findViewById(R.id.editTextInstr2);
        zak= findViewById(R.id.editTextInstr3);
        prod= findViewById(R.id.editTextInstr4);
        postav= findViewById(R.id.editTextInstr5);
        srogodn= findViewById(R.id.editTextInstr6);
        addInfo= findViewById(R.id.login_btn4);
        MRef= FirebaseDatabase.getInstance().getReference().child("Medicines");
        loadingBar =new ProgressDialog(this);

    }
}