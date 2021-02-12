package com.example.proyectopsp.model.room;

import android.content.Context;

import java.util.ArrayList;

public class Repository {
        GuardarAcciones guardarAcciones;


        public Repository(Context context) {
            this.guardarAcciones= new GuardarAcciones(context);
        }

        public boolean añadirCoche(Coche c) {
            return guardarAcciones.añadir(c);
        }

        public boolean editarCoche(long id,Coche c) {
            return guardarAcciones.editar(id,c);
        }

        public boolean eliminarCoche(long id) {
            return guardarAcciones.eliminar(id);
        }

        public ArrayList<Coche> mostrarCoche(Mostrar v){
            return guardarAcciones.mostrar(v);
        }

        public boolean añadirVenta(Venta v){
            return guardarAcciones.añadirVenta(v);
        }

        public ArrayList<Venta> mostrarVenta(MostrarVentas v){
            return guardarAcciones.mostrarVenta(v);
        }



}
