package com.example.proyectopsp.model.room;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Repository {
        GuardarAcciones guardarAcciones;


        public Repository(Context context) {
            this.guardarAcciones= new GuardarAcciones(context);
        }

        public boolean añadirCoche(Coche c) {
            return guardarAcciones.añadir(c);
        }

        public boolean editarCoche(int id,Coche c) {
            return guardarAcciones.editar(id,c);
        }

        public boolean eliminarCoche(int id) {
            return guardarAcciones.eliminar(id);
        }

        public ArrayList<Coche> mostrarCoche(mostrar v){
            return guardarAcciones.mostrar(v);
        }

}
