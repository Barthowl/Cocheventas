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

public class remove extends AppCompatActivity {
    Button btremover, btvolver;
    EditText etid;
    CocheInterface cocheI;
    ViewModelActivity viewModelActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);
        viewModelActivity = new ViewModelProvider(this).get(ViewModelActivity.class);

        etid = findViewById(R.id.etidrem);

        btremover = findViewById(R.id.bteliminar2);
        btremover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etid.getText().toString().isEmpty()){
                    etid.setError("No puedes dejar este campo vacío");
                } else {
                    int id = Integer.valueOf(etid.getText().toString());
                    viewModelActivity.eliminarCoche(id);
                    Intent intent = new Intent(remove.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        btvolver = findViewById(R.id.btcancelar);
        btvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(remove.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}