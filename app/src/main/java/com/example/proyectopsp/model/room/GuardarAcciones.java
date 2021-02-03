package com.example.proyectopsp.model.room;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectopsp.DataHolder.DataHolder;
import com.example.proyectopsp.R;
import com.example.proyectopsp.adapter.CocheRecyclerAdapter;

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
    ArrayList<Coche> cochelista = new ArrayList<>();
    List<Coche> listacoche = DataHolder.getInstance().listacoche;

    RecyclerView rvcoches;
    CocheRecyclerAdapter adapter;

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

    public boolean editar(int id, Coche coche){
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

    public boolean eliminar(int id){
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

    public ArrayList<Coche> mostrar(mostrar v){
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
}
