package com.example.proyectopsp.model.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyectopsp.DataHolder.DataHolder;
import com.example.proyectopsp.MainActivity;
import com.example.proyectopsp.R;
import com.example.proyectopsp.adapter.CocheRecyclerAdapter;
import com.example.proyectopsp.viewmodel.ViewModelActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class mostrar extends AppCompatActivity {

    Button btvolver;
    RecyclerView rvcoches;
    CocheRecyclerAdapter adapter;
    CocheInterface cocheI;
    ArrayList<Coche> cochelista = new ArrayList<>();
    ViewModelActivity viewModelActivity;
    List<Coche> listacoche = DataHolder.getInstance().listacoche;

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
                Intent intent = new Intent(mostrar.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void irItem(Coche c){
        Intent intent = new Intent(mostrar.this, item_coche.class);
        String datos = " Id: " + c.getId() + " \n Matrícula:" + c.getMatricula() + " \n Marca: " + c.getMarca() + " \n Modelo: " + c.getModelo() + " \n Color: " + c.getColor() + " \n Edad: " + c.getEdad();
        intent.putExtra("coche",datos);
        intent.putExtra("imagen",c.getFoto());
        startActivity(intent);
    }

}