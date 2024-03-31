package com.example.tishka.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RykovodstvAdapter extends RecyclerView.Adapter<RykovodstvAdapter.RykovodPoBezVievHolder> {


    @NonNull
    @Override
    public RykovodPoBezVievHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RykovodPoBezVievHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static final class RykovodPoBezVievHolder extends RecyclerView.ViewHolder{

        public RykovodPoBezVievHolder(View itemView){
            super(itemView);
        }

    }
}
