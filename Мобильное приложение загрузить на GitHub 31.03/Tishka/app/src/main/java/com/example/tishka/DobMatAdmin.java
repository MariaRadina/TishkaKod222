package com.example.tishka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.List;



public class DobMatAdmin extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    private List<String> DiscrTasks;
    private ImageView strelka;
    ListView ListInstr;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dob_mat_admin);
        strelka=(ImageView) findViewById(R.id.strelka);
        strelka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(DobMatAdmin.this, ObychaMater.class);
                startActivity(regIntent);
            }
        });
        ListInstr = (ListView) findViewById(R.id.list1);
        myRef = FirebaseDatabase.getInstance().getReference();


    }
}


