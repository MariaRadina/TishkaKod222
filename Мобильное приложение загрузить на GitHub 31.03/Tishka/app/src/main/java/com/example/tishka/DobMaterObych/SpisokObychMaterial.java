package com.example.tishka.DobMaterObych;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tishka.Model.ObechMater;
import com.example.tishka.ObychaMater;
import com.example.tishka.ObyhMaterKasir;
import com.example.tishka.R;
import com.example.tishka.ViewHolder.InfoViewHolder;
import com.example.tishka.ViewHolder.ObychMaterialViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SpisokObychMaterial extends AppCompatActivity {
    DatabaseReference Obref;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private ImageView strelka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spisok_obych_material);

        Obref = FirebaseDatabase.getInstance().getReference().child("ObychMater");
        recyclerView = findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        strelka=(ImageView) findViewById(R.id.strelka);
        strelka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(SpisokObychMaterial.this, ObyhMaterKasir.class);
                startActivity(regIntent);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<ObechMater> options = new FirebaseRecyclerOptions.Builder<ObechMater>().setQuery(Obref, ObechMater.class).build();

        FirebaseRecyclerAdapter<ObechMater, ObychMaterialViewHolder> adapter = new FirebaseRecyclerAdapter<ObechMater, ObychMaterialViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ObychMaterialViewHolder holder, int position, @NonNull ObechMater Model) {
                holder.TextInfo.setText(Model.getInfo());
            }

            @NonNull
            @Override
            public ObychMaterialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vidobych, parent, false);
                ObychMaterialViewHolder holder = new ObychMaterialViewHolder(view);
                return holder;
            }
        };

        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

}