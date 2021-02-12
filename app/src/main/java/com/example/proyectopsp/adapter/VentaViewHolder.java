package com.example.proyectopsp.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectopsp.R;

public class VentaViewHolder extends RecyclerView.ViewHolder{

    private final ImageView foto;
    private final TextView datos;
    public final LinearLayout layout;
    private final View view;

    public VentaViewHolder(@NonNull View itemView){
        super(itemView);
        view = itemView;
        this.foto=itemView.findViewById(R.id.imagen);
        this.datos=itemView.findViewById(R.id.tvDatosCoche);
        this.layout=itemView.findViewById(R.id.parent_layout);
    }

    @SuppressLint("ResourceType")
    public void bind(String text,String coche){
        datos.setText(text);
        Glide.with(view.getContext()).load(coche).into(foto);
    }

    public static VentaViewHolder create(ViewGroup parent){
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        return new VentaViewHolder(view);
    }
}