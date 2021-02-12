package com.example.proyectopsp.model.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.proyectopsp.MainActivity;
import com.example.proyectopsp.R;
import com.example.proyectopsp.viewmodel.ViewModelActivity;

public class Item_coche extends AppCompatActivity {
    Button btvolver, bteliminar,bteditar, btvender;
    ImageView iv;
    TextView tv;
    ViewModelActivity viewModelActivity;
    long id;
    String foto,datos,matricula,marca,modelo,color;
    int edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_coche);
        viewModelActivity = new ViewModelProvider(this).get(ViewModelActivity.class);

        tv = findViewById(R.id.tvfotoitem);
        iv = findViewById(R.id.fotofinal);

        Intent intent = getIntent();
        foto = intent.getStringExtra("imagen");
        datos = intent.getStringExtra("coche");
        matricula = intent.getStringExtra("matricula");
        marca = intent.getStringExtra("marca");
        modelo = intent.getStringExtra("modelo");
        color = intent.getStringExtra("color");
        edad = intent.getIntExtra("edad",0);
        id = intent.getLongExtra("id",0);

        tv.setText(datos);
        Glide.with(this).load(foto).into(iv);


        btvender = findViewById(R.id.btvenderi);
        btvender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Venta venta = new Venta(marca,modelo,foto);
                viewModelActivity.añadirVenta(venta);
                Toast.makeText(getApplicationContext(),"Coche vendido correctamente",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Item_coche.this, Mostrar.class);
                startActivity(intent);
            }
        });

        bteliminar = findViewById(R.id.bteliminari);
        bteliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelActivity.eliminarCoche(id);
                Toast.makeText(getApplicationContext(),"Coche eliminado correctamente",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Item_coche.this, Mostrar.class);
                startActivity(intent);
            }
        });

        bteditar = findViewById(R.id.bteditari);
        bteditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Item_coche.this, Edit.class);
                intent.putExtra("imagen",foto);
                intent.putExtra("id",id);
                intent.putExtra("matricula",matricula);
                intent.putExtra("marca",marca);
                intent.putExtra("modelo",modelo);
                intent.putExtra("color",color);
                intent.putExtra("edad",edad);
                startActivity(intent);
            }
        });

        btvolver = findViewById(R.id.btfoto);
        btvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Item_coche.this, Mostrar.class);
                startActivity(intent);
            }
        });
    }
}