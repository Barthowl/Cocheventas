package com.example.proyectopsp.model.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.proyectopsp.dataHolder.DataHolder;
import com.example.proyectopsp.MainActivity;
import com.example.proyectopsp.R;
import com.example.proyectopsp.adapter.CocheRecyclerAdapter;
import com.example.proyectopsp.viewmodel.ViewModelActivity;

import java.util.ArrayList;
import java.util.List;

public class Mostrar extends AppCompatActivity {

    Button btvolver;
    ViewModelActivity viewModelActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        viewModelActivity = new ViewModelProvider(this).get(ViewModelActivity.class);

        viewModelActivity.mostrarCoche(this);


        btvolver = findViewById(R.id.btvolverm);

        btvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mostrar.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void irItem(Coche c){
        Intent intent = new Intent(Mostrar.this, Item_coche.class);
        String datos = " Id: " + c.getId() + " \n Matrícula:" + c.getMatricula() + " \n Marca: " + c.getMarca() + " \n Modelo: " + c.getModelo() + " \n Color: " + c.getColor() + " \n Edad: " + c.getEdad();
        intent.putExtra("coche",datos);
        intent.putExtra("imagen",c.getFoto());
        intent.putExtra("id",c.getId());
        intent.putExtra("matricula",c.getMatricula());
        intent.putExtra("marca",c.getMarca());
        intent.putExtra("modelo",c.getModelo());
        intent.putExtra("color",c.getColor());
        intent.putExtra("edad",c.getEdad());
        startActivity(intent);
    }

    public void irItem(Venta v){
        Intent intent = new Intent(Mostrar.this, Item_coche.class);
        intent.putExtra("imagen",v.getFoto());
        intent.putExtra("id",v.getId());
        intent.putExtra("marca",v.getMarca());
        intent.putExtra("modelo",v.getModelo());
        startActivity(intent);
    }

}