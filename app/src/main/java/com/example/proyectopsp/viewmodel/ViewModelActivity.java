package com.example.proyectopsp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.proyectopsp.model.room.Coche;
import com.example.proyectopsp.model.room.MostrarVentas;
import com.example.proyectopsp.model.room.Repository;
import com.example.proyectopsp.model.room.Mostrar;
import com.example.proyectopsp.model.room.Venta;

import java.util.ArrayList;

public class ViewModelActivity extends AndroidViewModel {
    private Repository repository;

    public ViewModelActivity(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public boolean añadirCoche(Coche c) {
        return repository.añadirCoche(c);
    }

    public boolean editarCoche(long id,Coche c) {
        return repository.editarCoche(id,c);
    }

    public boolean eliminarCoche(long id) {
        return repository.eliminarCoche(id);
    }

    public ArrayList<Coche> mostrarCoche(Mostrar v){
        return repository.mostrarCoche(v);
    }

    public ArrayList<Venta> mostrarVenta(MostrarVentas v){
        return repository.mostrarVenta(v);
    }

    public boolean añadirVenta(Venta v){
        return repository.añadirVenta(v);
    }

}

