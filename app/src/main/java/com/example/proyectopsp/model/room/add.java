package com.example.proyectopsp.model.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectopsp.MainActivity;
import com.example.proyectopsp.R;
import com.example.proyectopsp.viewmodel.ViewModelActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class add extends AppCompatActivity {
    Button btvolver,btañadir;
    EditText etmatricula, etmarca, etmodelo, etcolor,etfoto,etedad;
    CocheInterface cocheI;
    ViewModelActivity viewModelActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        viewModelActivity = new ViewModelProvider(this).get(ViewModelActivity.class);

        etmatricula = findViewById(R.id.etmatricula);
        etmarca = findViewById(R.id.etmarca);
        etmodelo = findViewById(R.id.etmodelo);
        etcolor = findViewById(R.id.etcolor);
        etfoto = findViewById(R.id.etfoto);
        etedad = findViewById(R.id.etedad);


        btvolver = findViewById(R.id.btvolverf);
        btañadir = findViewById(R.id.btaddf);

        btvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(add.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btañadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // control de errores
                if(etmatricula.getText().toString().isEmpty()){
                    etmatricula.setError("No puedes dejar este campo vacío");
                } else if(etmarca.getText().toString().isEmpty()){
                    etmarca.setError("No puedes dejar este campo vacío");
                } else if(etmodelo.getText().toString().isEmpty()){
                    etmodelo.setError("No puedes dejar este campo vacío");
                } else if(etcolor.getText().toString().isEmpty()){
                    etcolor.setError("No puedes dejar este campo vacío");
                } else if(etfoto.getText().toString().isEmpty()){
                    etfoto.setError("No puedes dejar este campo vacío");
                }else if(etedad.getText().toString().isEmpty()){
                    etedad.setError("No puedes dejar este campo vacío");
                } else {
                    String matricula = etmatricula.getText().toString();
                    String marca = etmarca.getText().toString();
                    String modelo = etmodelo.getText().toString();
                    String color = etcolor.getText().toString();
                    String foto = etfoto.getText().toString();
                    int edad = Integer.valueOf(etedad.getText().toString());
                     Coche coche = new Coche(matricula,marca,modelo,color,foto,edad);
                     viewModelActivity.añadirCoche(coche);
                    Intent intent = new Intent(add.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}