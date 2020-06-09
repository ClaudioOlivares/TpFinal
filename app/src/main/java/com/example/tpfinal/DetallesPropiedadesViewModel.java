package com.example.tpfinal;

import android.content.Context;
import android.os.IInterface;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpfinal.models.Inmueble;
import com.example.tpfinal.request.ApiClient;
import com.example.tpfinal.sharedprefs.Sharedprefs;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetallesPropiedadesViewModel extends ViewModel {

   private MutableLiveData<Inmueble> inmuebleMutableLiveData;

   private Sharedprefs sp;



    public DetallesPropiedadesViewModel()
    {
    }
    public LiveData<Inmueble> getInmueblesMutableLiveData()
    {
        if(inmuebleMutableLiveData == null)
        {
            inmuebleMutableLiveData = new MutableLiveData<>();
        }
        return inmuebleMutableLiveData;
    }

    public void CargarDatosPropiedad(int id, final Context ctx)
    {
        String token = "Bearer " + sp.leerToken(ctx);

        Call<List<Inmueble>> res = ApiClient.getMyApiClient().ObtenerInmueble(token,id);

        res.enqueue(new Callback<List<Inmueble>>() {
            @Override
            public void onResponse(Call<List<Inmueble>> call, Response<List<Inmueble>> response)
            {
                if(response.isSuccessful())
                {
                    List<Inmueble> i = response. body();
                    inmuebleMutableLiveData.postValue(i.get(0));
                }
                else
                {
                    try
                    {
                        Toast.makeText(ctx, response.errorBody().string(), Toast.LENGTH_SHORT).show();

                    } catch (IOException e)
                    {
                        Toast.makeText(ctx, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Inmueble>> call, Throwable t)
            {
                Toast.makeText(ctx, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public  void completarDatos(EditText direccion, EditText precio, EditText tipoinmueble, EditText cantAmbientes, CheckBox estado, Context ctx, Inmueble i)
    {
        direccion.setText(i.getDireccion());

        precio.setText(Double.toString(i.getPrecio()));

        tipoinmueble.setText(i.getTipoInmueble().getNombreTipo());

        cantAmbientes.setText(Integer.toString(i.getCantAmbientes()));

        if(i.getEstado() == false)
        {
            estado.setChecked(false);
        }
        else
        {
            estado.setChecked(true);
        }
    }
}
