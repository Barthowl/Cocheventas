package com.example.proyectopsp.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.proyectopsp.model.room.Coche;
import com.example.proyectopsp.model.room.Mostrar;
import com.example.proyectopsp.model.room.Venta;

public class VentaRecyclerAdapter extends ListAdapter<Venta, VentaViewHolder> {
    Mostrar m;
    public VentaRecyclerAdapter(@NonNull DiffUtil.ItemCallback<Venta> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public VentaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return VentaViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull VentaViewHolder holder, int position) {
        Venta current = getItem(position);
        if(!current.getFoto().contains("https://")){
            current.setFoto("https://i.imgur.com/aA1BoNb.png");
        }
        holder.bind(current.toString(), current.getFoto());
    }

    public static class VentaDiff extends DiffUtil.ItemCallback<Venta> {

        @Override
        public boolean areItemsTheSame(@NonNull Venta oldItem, @NonNull Venta newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Venta oldItem, @NonNull Venta newItem) {
            return oldItem.getModelo().equals(newItem.getModelo());
        }
    }

}
