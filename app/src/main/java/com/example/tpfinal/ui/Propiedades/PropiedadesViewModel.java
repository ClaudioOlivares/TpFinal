package com.example.tpfinal.ui.Propiedades;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpfinal.Propiedad;
import com.example.tpfinal.R;
import com.example.tpfinal.models.Inmueble;
import com.example.tpfinal.models.Propietario;
import com.example.tpfinal.request.ApiClient;
import com.example.tpfinal.sharedprefs.Sharedprefs;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropiedadesViewModel extends ViewModel {

    private MutableLiveData<List<Inmueble>> inmueblesMutableLiveData;
    private Sharedprefs sp;

    public PropiedadesViewModel() {

    }

    public LiveData<List<Inmueble>> getInmueblesMutableLiveData()
    {
        if(inmueblesMutableLiveData == null)
        {
           inmueblesMutableLiveData = new MutableLiveData<>();
        }
        return inmueblesMutableLiveData;
    }

    public void Obtenerdatos(final Context ctx)
    {
        String token = "Bearer " + sp.leerToken(ctx);
        Call<List<Inmueble>> res = ApiClient.getMyApiClient().TraerInmuebles(token);
        res.enqueue(new Callback<List<Inmueble>>() {
            @Override
            public void onResponse(Call<List<Inmueble>> call, Response<List<Inmueble>> response) {
                 if(response.isSuccessful())
                 {

                    inmueblesMutableLiveData.postValue(response.body());
                 }
                 else
                 {
                     try
                     {
                         Toast.makeText(ctx, response.errorBody().string(), Toast.LENGTH_SHORT).show();
                     }
                     catch (IOException e)
                     {
                         e.printStackTrace();
                     }
                 }
            }

            @Override
            public void onFailure(Call<List<Inmueble>> call, Throwable t) {
                Toast.makeText(ctx, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }








    public void datos( TextView precio, TextView direccion, Inmueble p)
    {
        precio.setText(Double.toString(p.getPrecio()));
        direccion.setText(p.getDireccion());
    }


    public void Borrar(final Context ctx, int id)
    {
        String token = "Bearer " + sp.leerToken(ctx);

        final Call<String> res = ApiClient.getMyApiClient().borrarInmueble(token,id);

        res.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response)
            {
                if(response.isSuccessful())
                {
                    Toast.makeText(ctx, "Propiedad Eliminada", Toast.LENGTH_LONG).show();
                }
                else
                {
                    try {
                        Toast.makeText(ctx, response.errorBody().string(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        Toast.makeText(ctx, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}