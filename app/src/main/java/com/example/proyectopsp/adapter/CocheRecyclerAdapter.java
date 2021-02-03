package com.example.proyectopsp.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.proyectopsp.MainActivity;
import com.example.proyectopsp.model.room.Coche;
import com.example.proyectopsp.model.room.mostrar;

public class CocheRecyclerAdapter extends ListAdapter<Coche, CocheViewHolder> {
    mostrar m;
    public CocheRecyclerAdapter( @NonNull DiffUtil.ItemCallback<Coche> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public CocheViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return CocheViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull CocheViewHolder holder, int position) {
        Coche current = getItem(position);
        if(!current.getFoto().contains("https://")){
            current.setFoto("https://i.imgur.com/aA1BoNb.png");
        }
        holder.bind(current.toString(), current.getFoto());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m = (mostrar) view.getContext();
                m.irItem(current);
            }
        });
    }

    public static class CocheDiff extends DiffUtil.ItemCallback<Coche> {

        @Override
        public boolean areItemsTheSame(@NonNull Coche oldItem, @NonNull Coche newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Coche oldItem, @NonNull Coche newItem) {
            return oldItem.getMatricula().equals(newItem.getMatricula());
        }
    }

}
