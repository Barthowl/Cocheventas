package com.example.proyectopsp.model.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.proyectopsp.MainActivity;
import com.example.proyectopsp.R;

public class item_coche extends AppCompatActivity {
    Button btvolver;
    ImageView iv;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_coche);

        tv = findViewById(R.id.tvfotoitem);
        iv = findViewById(R.id.fotofinal);

        Intent intent = getIntent();
        String foto = intent.getStringExtra("imagen");
        String datos = intent.getStringExtra("coche");

        tv.setText(datos);
        Glide.with(this).load(foto).into(iv);

        btvolver = findViewById(R.id.btfoto);
        btvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(item_coche.this, mostrar.class);
                startActivity(intent);
            }
        });
    }
}