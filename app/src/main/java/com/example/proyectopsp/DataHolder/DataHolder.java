package com.example.proyectopsp.DataHolder;

import com.example.proyectopsp.model.room.Coche;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {
    public final List<Coche> listacoche = new ArrayList<Coche>();

    private DataHolder() {}

    public static DataHolder getInstance() {
        if( instance == null ) {
            instance = new DataHolder();
        }
        return instance;
    }

    private static DataHolder instance;
}
