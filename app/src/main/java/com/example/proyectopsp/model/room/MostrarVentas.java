package com.example.proyectopsp.model.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyectopsp.MainActivity;
import com.example.proyectopsp.R;
import com.example.proyectopsp.viewmodel.ViewModelActivity;

public class MostrarVentas extends AppCompatActivity {
    Button btvolver;
    ViewModelActivity viewModelActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_ventas);
        viewModelActivity = new ViewModelProvider(this).get(ViewModelActivity.class);

        viewModelActivity.mostrarVenta(this);

        btvolver = findViewById(R.id.btvolverv);
        btvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MostrarVentas.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}