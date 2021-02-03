package com.example.proyectopsp.model.room;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CocheInterface {

    @DELETE("coche/{id}")
    Call<Boolean> deleteCoche(@Path("id") long id);

    // me da todos los coches
    @GET("coche")
    Call<ArrayList<Coche>> getCoche();

    // te da todos los coches
    /*@GET("coche")
    Call<ListaCoches> getListaCoches();*/

    // string de coches https://informatica.ieszaidinvergeles.org:9034/laravel/cocheventa/public/api/
    @GET("coche")
    Call<ResponseBody> getString();

    // añadir https://informatica.ieszaidinvergeles.org:9034/laravel/cocheventa/public/api/
    @POST("coche")
    Call<Coche> postCoche(@Body Coche coche);

    // editar coche https://informatica.ieszaidinvergeles.org:9034/laravel/cocheventa/public/api/
    @PUT("coche/{id}")
    Call<Boolean> putCoche(@Path("id") long id, @Body Coche coche);
}

