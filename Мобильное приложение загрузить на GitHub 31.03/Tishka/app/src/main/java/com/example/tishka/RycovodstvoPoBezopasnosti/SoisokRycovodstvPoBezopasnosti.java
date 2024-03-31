package com.example.tishka.RycovodstvoPoBezopasnosti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.tishka.DobMaterObych.SpisokObychMaterial;
import com.example.tishka.Model.ObechMater;
import com.example.tishka.Model.RykovodstvoPObezopasnostimodel;
import com.example.tishka.ObyhMaterKasir;
import com.example.tishka.R;
import com.example.tishka.ViewHolder.ObychMaterialViewHolder;
import com.example.tishka.ViewHolder.RylovodsBezop;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SoisokRycovodstvPoBezopasnosti extends AppCompatActivity {
    private DatabaseReference myRef;
    DatabaseReference Inref;
    private RecyclerView recyclerView;

    RecyclerView.LayoutManager layoutManager;
    private ImageView strelka;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soisok_rycovodstv_po_bezopasnosti);

        Inref = FirebaseDatabase.getInstance().getReference().child("RykovtstvoPoBezopastnosti");
        recyclerView = findViewById(R.id.recc);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        strelka=(ImageView) findViewById(R.id.strelka);
        strelka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(SoisokRycovodstvPoBezopasnosti.this, ObyhMaterKasir.class);
                startActivity(regIntent);
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<RykovodstvoPObezopasnostimodel> options = new FirebaseRecyclerOptions.Builder<RykovodstvoPObezopasnostimodel>().setQuery(Inref, RykovodstvoPObezopasnostimodel.class).build();
        FirebaseRecyclerAdapter<RykovodstvoPObezopasnostimodel, RylovodsBezop> adapter = new FirebaseRecyclerAdapter<RykovodstvoPObezopasnostimodel, RylovodsBezop>(options) {
            @Override
            protected void onBindViewHolder(@NonNull RylovodsBezop holder, int position, @NonNull RykovodstvoPObezopasnostimodel Model) {
                holder.TextInfo.setText(Model.getInfo());
            }

            @NonNull
            @Override
            public RylovodsBezop onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vidrykovodstvo, parent, false);
                RylovodsBezop holder = new RylovodsBezop(view);
                return holder;
            }
        };

        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

}

