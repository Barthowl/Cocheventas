package com.example.proyectopsp.model.room;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectopsp.adapter.VentaRecyclerAdapter;
import com.example.proyectopsp.dataHolder.DataHolder;
import com.example.proyectopsp.R;
import com.example.proyectopsp.adapter.CocheRecyclerAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GuardarAcciones {
    Context context;
    CocheInterface cocheI;
    VentaInterface ventaI;

    ArrayList<Coche> cochelista = new ArrayList<>();
    ArrayList<Venta> ventalista = new ArrayList<>();

    List<Coche> listacoche = DataHolder.getInstance().listacoche;

    RecyclerView rvcoches;
    RecyclerView rvventas;
    CocheRecyclerAdapter adapter;
    VentaRecyclerAdapter adapter2;

    public GuardarAcciones(Context context) {
        this.context = context.getApplicationContext();
    }

    public boolean añadir(Coche coche){
        String url = "https://informatica.ieszaidinvergeles.org:9034/laravel/cocheventa/public/api/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cocheI = retrofit.create(CocheInterface.class);

        Call<Coche> request = cocheI.postCoche(coche);
        request.enqueue(new Callback<Coche>() {
            @Override
            public void onResponse(Call<Coche> call, Response<Coche> response) {
            }

            @Override
            public void onFailure(Call<Coche> call, Throwable t) {
                Log.v("XYZ",t.getMessage());
            }
        });
        return false;
    }

    public boolean editar(long id, Coche coche){
        String url = "https://informatica.ieszaidinvergeles.org:9034/laravel/cocheventa/public/api/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cocheI = retrofit.create(CocheInterface.class);

        Call<Boolean> request = cocheI.putCoche(id,coche);
        request.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.v("XYZ",t.getLocalizedMessage());
            }
        });
        return false;
    }

    public boolean eliminar(long id){
        String url="https://informatica.ieszaidinvergeles.org:9034/laravel/cocheventa/public/api/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cocheI = retrofit.create(CocheInterface.class);

        Call<Boolean> request = cocheI.deleteCoche(id);

        request.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.v("XYZ", t.getMessage());
            }
        });
        return false;
    }

    public ArrayList<Coche> mostrar(Mostrar v){
        String url="https://informatica.ieszaidinvergeles.org:9034/laravel/cocheventa/public/api/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cocheI = retrofit.create(CocheInterface.class);

        Call<ArrayList<Coche>> request = cocheI.getCoche();
        request.enqueue(new Callback<ArrayList<Coche>>() {
            @Override
            public void onResponse(Call<ArrayList<Coche>> call, Response<ArrayList<Coche>> response) {
                cochelista = response.body();

                rvcoches = v.findViewById(R.id.rvCoche);
                rvcoches.setHasFixedSize(true);

                adapter = new CocheRecyclerAdapter(new CocheRecyclerAdapter.CocheDiff());
                adapter.submitList(cochelista);

                rvcoches.setLayoutManager(new LinearLayoutManager(v.getApplicationContext()));
                rvcoches.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArrayList<Coche>> call, Throwable t) {
                Log.v("XYZ", t.getMessage());
            }
        });
        return cochelista;
    }

    public boolean añadirVenta(Venta ventas){
        String url="https://informatica.ieszaidinvergeles.org:9034/laravel/cocheventa/public/api/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VentaInterface ventaInterface = retrofit.create(VentaInterface.class);

        Call<Venta> request = ventaInterface.postVentas(ventas);
        request.enqueue(new Callback<Venta>() {
            @Override
            public void onResponse(Call<Venta> call, Response<Venta> response) {
            }

            @Override
            public void onFailure(Call<Venta> call, Throwable t) {
                Log.v("XYZ",t.getMessage());
            }
        });
        return false;
    }

    public ArrayList<Venta> mostrarVenta(MostrarVentas v){
        String url="https://informatica.ieszaidinvergeles.org:9034/laravel/cocheventa/public/api/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ventaI = retrofit.create(VentaInterface.class);

        Call<ArrayList<Venta>> request = ventaI.getVenta();
        request.enqueue(new Callback<ArrayList<Venta>>() {
            @Override
            public void onResponse(Call<ArrayList<Venta>> call, Response<ArrayList<Venta>> response) {
                ventalista = response.body();

                rvventas = v.findViewById(R.id.rvVentas);
                rvventas.setHasFixedSize(true);

                adapter2 = new VentaRecyclerAdapter(new VentaRecyclerAdapter.VentaDiff());
                adapter2.submitList(ventalista);

                rvventas.setLayoutManager(new LinearLayoutManager(v.getApplicationContext()));
                rvventas.setAdapter(adapter2);

            }

            @Override
            public void onFailure(Call<ArrayList<Venta>> call, Throwable t) {
                Log.v("XYZ", t.getMessage());
            }
        });
        return ventalista;
    }

}
