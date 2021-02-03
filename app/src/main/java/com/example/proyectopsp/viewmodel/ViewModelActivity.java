package com.example.proyectopsp.viewmodel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.proyectopsp.model.room.Coche;
import com.example.proyectopsp.model.room.Repository;
import com.example.proyectopsp.model.room.mostrar;

import java.util.ArrayList;
import java.util.List;

public class ViewModelActivity extends AndroidViewModel {
    private Repository repository;

    public ViewModelActivity(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public boolean añadirCoche(Coche c) {
        return repository.añadirCoche(c);
    }

    public boolean editarCoche(int id,Coche c) {
        return repository.editarCoche(id,c);
    }

    public boolean eliminarCoche(int id) {
        return repository.eliminarCoche(id);
    }

    public ArrayList<Coche> mostrarCoche(mostrar v){
        return repository.mostrarCoche(v);
    }
}

