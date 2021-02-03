package com.example.proyectopsp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyectopsp.adapter.CocheRecyclerAdapter;
import com.example.proyectopsp.model.room.Coche;
import com.example.proyectopsp.model.room.add;
import com.example.proyectopsp.model.room.edit;
import com.example.proyectopsp.model.room.mostrar;
import com.example.proyectopsp.model.room.remove;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btadd,btedit,btrem,btmostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btadd = findViewById(R.id.btañadir);
        btedit = findViewById(R.id.bteditar);
        btrem = findViewById(R.id.bteliminar);
        btmostrar = findViewById(R.id.btmostrar);

        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, add.class);
                startActivity(intent);
            }
        });

        btedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, edit.class);
                startActivity(intent);
            }
        });

        btrem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, remove.class);
                startActivity(intent);
            }
        });

        btmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, mostrar.class);
                startActivity(intent);
            }
        });
    }
}