package com.example.tishka.ViewHolder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tishka.R;
import com.example.tishka.Interface.ItemClickListner2;

public class ObychMaterialViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView TextInfo;
    public ItemClickListner2 listner;

    public ObychMaterialViewHolder(View itemView)
    {
        super(itemView);

        TextInfo= itemView.findViewById(R.id.editTextInstr2);

    }
    public void setItemClickListner(ItemClickListner2 listner){this.listner=listner;}
    @Override
    public void onClick(View view){
        listner.onClick(view, getAdapterPosition(), false);
    }
}
