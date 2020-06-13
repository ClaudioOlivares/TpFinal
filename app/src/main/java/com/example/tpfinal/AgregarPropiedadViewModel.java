package com.example.tpfinal;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpfinal.models.Inmueble;
import com.example.tpfinal.models.TipoInmueble;
import com.example.tpfinal.request.ApiClient;
import com.example.tpfinal.sharedprefs.Sharedprefs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgregarPropiedadViewModel extends ViewModel {

    private MutableLiveData<ArrayList<String>> spinnerMutableLiveData;

    private Sharedprefs sp;


    public LiveData<ArrayList<String>> getSpinnerMutableLiveData()
    {
        if(spinnerMutableLiveData == null)
        {
            spinnerMutableLiveData = new MutableLiveData<>();
        }
        return spinnerMutableLiveData;
    }


    public void tomarTiposInmuebles(final Context ctx)
    {

        String token ="Bearer " + sp.leerToken(ctx);

        Call<List<TipoInmueble>> res = ApiClient.getMyApiClient().TraerTipoInmueble(token);

        res.enqueue(new Callback<List<TipoInmueble>>() {
            @Override
            public void onResponse(Call<List<TipoInmueble>> call, Response<List<TipoInmueble>> response) {
                if(response.isSuccessful())
                {
                    List<TipoInmueble> list ;

                    list = response.body();

                    ArrayList<String> listaSpinner = new ArrayList<String>();

                    for (int x=0;x < list.size();x++)
                    {
                        listaSpinner.add(list.get(x).getNombreTipo());
                    }
                /*    for (TipoInmueble item: list)
                    {

                    }*/

                    spinnerMutableLiveData.postValue(listaSpinner);
                }
                else
                {
                    try {
                        Toast.makeText(ctx, response.errorBody().string(), Toast.LENGTH_LONG).show();
                    }
                    catch (IOException e) {
                        Toast.makeText(ctx, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<TipoInmueble>> call, Throwable t) {
                Toast.makeText(ctx, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void CrearInmueble(final Context ctx, EditText direccion, EditText precio, EditText cantAmbientes, CheckBox estado, Spinner spinner)
    {
        String token = "Bearer " + sp.leerToken(ctx);

        Inmueble i = new Inmueble();

        i.setDireccion(direccion.getText().toString());

        i.setPrecio(Double.parseDouble(precio.getText().toString()));

        i.setCantAmbientes(Integer.parseInt(cantAmbientes.getText().toString()));

        i.setIdTipoInmueble((int)spinner.getSelectedItemId() +10);

        if(estado.isChecked() == false)
        {
            i.setEstado(false);
        }
        else
        {
            i.setEstado(true);
        }

        Call<Inmueble>res = ApiClient.getMyApiClient().CrearInmueble(token,i);

        res.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if(response.isSuccessful())
                {
                    Toast.makeText(ctx, "Propiedad Creada", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable t) {
                Toast.makeText(ctx, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
