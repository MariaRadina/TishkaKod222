package com.example.tishka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tishka.Model.InfoPO;
import com.example.tishka.ViewHolder.InfoViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SpisokInfoPO extends AppCompatActivity {
    DatabaseReference InfoRef;
    private RecyclerView  recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spisok_info_po);


        InfoRef= FirebaseDatabase.getInstance().getReference().child("Info");
        recyclerView = findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<InfoPO> options = new FirebaseRecyclerOptions.Builder<InfoPO>().setQuery(InfoRef, InfoPO.class).build();

        FirebaseRecyclerAdapter<InfoPO, InfoViewHolder> adapter = new FirebaseRecyclerAdapter<InfoPO, InfoViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull InfoViewHolder holder, int position, @NonNull InfoPO model) {
                holder.txtInfo.setText(model.getInfo());
            }

            @NonNull
            @Override
            public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vidrykovodstvo, parent,false);
                InfoViewHolder holder = new InfoViewHolder(view);
                return holder;
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();


    }

}