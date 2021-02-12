package com.example.proyectopsp.model.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.ClipData;
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

public class Edit extends AppCompatActivity {
    Button btvolver, bteditar;
    EditText etmatricula, etmarca, etmodelo, etcolor,etfoto,etedad;
    CocheInterface cocheI;
    ViewModelActivity viewModelActivity;
    long id;
    String foto,matricula,marca,modelo,color;
    int edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        viewModelActivity = new ViewModelProvider(this).get(ViewModelActivity.class);



        etmatricula = findViewById(R.id.etmatricula2);
        etmarca = findViewById(R.id.etmarca2);
        etmodelo = findViewById(R.id.etmodelo2);
        etcolor = findViewById(R.id.etcolor2);
        etfoto = findViewById(R.id.etfoto2);
        etedad = findViewById(R.id.etedad2);

        btvolver = findViewById(R.id.btvolverf2);
        bteditar = findViewById(R.id.bteditarf);

        Intent intent = getIntent();
        foto = intent.getStringExtra("imagen");
        matricula = intent.getStringExtra("matricula");
        marca = intent.getStringExtra("marca");
        modelo = intent.getStringExtra("modelo");
        color = intent.getStringExtra("color");
        edad = intent.getIntExtra("edad",0);
        id = intent.getLongExtra("id",0);



        etmatricula.setText(matricula);
        etmarca.setText(marca);
        etmodelo.setText(modelo);
        etcolor.setText(color);
        etedad.setText(String.valueOf(edad));
        etfoto.setText(foto);

        btvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Edit.this, Mostrar.class);
                startActivity(intent);
            }
        });

        bteditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String matricula, marca,modelo,color,foto;
                int edad;

                Coche coche = new Coche();
                coche.setId(id);

                if(!etmatricula.getText().toString().isEmpty()){
                    matricula = etmatricula.getText().toString();
                    coche.setMatricula(matricula);
                }
                if(!etmarca.getText().toString().isEmpty()){
                    marca = etmarca.getText().toString();
                    coche.setMarca(marca);
                }
                if(!etmodelo.getText().toString().isEmpty()){
                    modelo = etmodelo.getText().toString();
                    coche.setModelo(modelo);
                }
                if(!etcolor.getText().toString().isEmpty()){
                    color = etcolor.getText().toString();
                    coche.setColor(color);
                }
                if(!etfoto.getText().toString().isEmpty()){
                    foto = etfoto.getText().toString();
                    coche.setFoto(foto);
                }
                if(!etedad.getText().toString().isEmpty()){
                    edad = Integer.valueOf(etedad.getText().toString());
                    coche.setEdad(edad);
                }
                    viewModelActivity.editarCoche(id,coche);
                    Toast.makeText(getApplicationContext(),"Coche editado correctamente",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Edit.this, Mostrar.class);
                    startActivity(intent);

            }
        });
    }
}