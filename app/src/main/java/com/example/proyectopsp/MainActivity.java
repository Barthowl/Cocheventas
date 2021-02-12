package com.example.proyectopsp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyectopsp.model.room.Add;
import com.example.proyectopsp.model.room.Edit;
import com.example.proyectopsp.model.room.Mostrar;
import com.example.proyectopsp.model.room.MostrarVentas;

public class MainActivity extends AppCompatActivity {
    Button btadd,btventas,btmostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btadd = findViewById(R.id.btañadir);

        btmostrar = findViewById(R.id.btmostrar);

        btventas = findViewById(R.id.btvender);

        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Add.class);
                startActivity(intent);
            }
        });

        btmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Mostrar.class);
                startActivity(intent);
            }
        });

        btventas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MostrarVentas.class);
                startActivity(intent);
            }
        });
    }
}