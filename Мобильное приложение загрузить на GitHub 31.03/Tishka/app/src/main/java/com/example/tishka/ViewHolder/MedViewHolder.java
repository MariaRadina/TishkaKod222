package com.example.tishka.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tishka.Interface.ItemClickListner2;
import com.example.tishka.R;

public class MedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView Textname,Textkol,Textzak,Textprod, Textpostav, Textsrokgodn;
    public ItemClickListner2 listner;

    public MedViewHolder(View itemView)
    {
        super(itemView);

        Textname= itemView.findViewById(R.id.editTextInstr2);
        Textkol= itemView.findViewById(R.id.editTextInstr3);
        Textzak= itemView.findViewById(R.id.editTextInstr4);
        Textprod= itemView.findViewById(R.id.editTextInstr5);
        Textpostav= itemView.findViewById(R.id.editTextInstr6);
        Textsrokgodn= itemView.findViewById(R.id.editTextInstr7);

    }
    public void setItemClickListner(ItemClickListner2 listner){this.listner=listner;}
    @Override
    public void onClick(View view){
        listner.onClick(view, getAdapterPosition(), false);
    }
}

