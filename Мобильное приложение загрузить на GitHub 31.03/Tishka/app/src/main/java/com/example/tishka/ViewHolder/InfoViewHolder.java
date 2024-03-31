package com.example.tishka.ViewHolder;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.tishka.Interface.ItemClickListner;
import com.example.tishka.R;

public class InfoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{

    public TextView txtInfo;
    public ItemClickListner listner;

    public InfoViewHolder(View itemView)
    {
        super(itemView);

        txtInfo= itemView.findViewById(R.id.editTextInstr);

    }
    public void setItemClickListner(ItemClickListner listner){this.listner=listner;}
    @Override
    public void onClick(View view){
        listner.onClick(
            view, getAdapterPosition(), false);
        }
    }

