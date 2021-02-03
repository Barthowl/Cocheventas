package com.example.proyectopsp.model.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
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

public class edit extends AppCompatActivity {
    Button btvolver, bteditar;
    EditText etid, etmatricula, etmarca, etmodelo, etcolor,etfoto,etedad;
    CocheInterface cocheI;
    ViewModelActivity viewModelActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        viewModelActivity = new ViewModelProvider(this).get(ViewModelActivity.class);

        etid = findViewById(R.id.etid2);
        etmatricula = findViewById(R.id.etmatricula2);
        etmarca = findViewById(R.id.etmarca2);
        etmodelo = findViewById(R.id.etmodelo2);
        etcolor = findViewById(R.id.etcolor2);
        etfoto = findViewById(R.id.etfoto2);
        etedad = findViewById(R.id.etedad2);

        btvolver = findViewById(R.id.btvolverf2);
        bteditar = findViewById(R.id.bteditarf);

        btvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(edit.this, MainActivity.class);
                startActivity(intent);
            }
        });

        bteditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String matricula, marca,modelo,color,foto;
                int edad;

                Coche coche = new Coche();

                    // control de errores
                if(etid.getText().toString().isEmpty()){
                    etid.setError("Introduzca la id que va a editar");
                }
                if(!etmatricula.getText().toString().isEmpty() && !etid.getText().toString().isEmpty()){
                    matricula = etmatricula.getText().toString();
                    coche.setMatricula(matricula);
                }
                if(!etmarca.getText().toString().isEmpty() && !etid.getText().toString().isEmpty()){
                    marca = etmarca.getText().toString();
                    coche.setMarca(marca);
                }
                if(!etmodelo.getText().toString().isEmpty() && !etid.getText().toString().isEmpty()){
                    modelo = etmodelo.getText().toString();
                    coche.setModelo(modelo);
                }
                if(!etcolor.getText().toString().isEmpty() && !etid.getText().toString().isEmpty()){
                    color = etcolor.getText().toString();
                    coche.setColor(color);
                }
                if(!etfoto.getText().toString().isEmpty() && !etid.getText().toString().isEmpty()){
                    foto = etfoto.getText().toString();
                    coche.setFoto(foto);
                }
                if(!etedad.getText().toString().isEmpty() && !etid.getText().toString().isEmpty()){
                    edad = Integer.valueOf(etedad.getText().toString());
                    coche.setEdad(edad);
                }
                if(!etid.getText().toString().isEmpty()){
                    int id = Integer.valueOf(etid.getText().toString());

                    viewModelActivity.editarCoche(id,coche);

                    Intent intent = new Intent(edit.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}