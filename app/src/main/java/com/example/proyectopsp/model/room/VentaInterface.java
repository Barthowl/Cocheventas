package com.example.proyectopsp.model.room;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface VentaInterface {

    // me da todas las ventas
    @GET("venta")
    Call<ArrayList<Venta>> getVenta();

    @POST("venta")
    Call<Venta> postVentas(@Body Venta ventas);
}
