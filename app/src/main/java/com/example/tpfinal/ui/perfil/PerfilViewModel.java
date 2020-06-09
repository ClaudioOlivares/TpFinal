package com.example.tpfinal.ui.perfil;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.example.tpfinal.models.Propietario;
import com.example.tpfinal.request.ApiClient;
import com.example.tpfinal.sharedprefs.Sharedprefs;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends ViewModel {

    private MutableLiveData<Propietario> propietarioMutableLiveData;

    private Sharedprefs sp;

    public PerfilViewModel() {

    }

   public LiveData<Propietario> getPropietarioMutableLiveData()
   {
        if(propietarioMutableLiveData == null)
        {
            propietarioMutableLiveData = new MutableLiveData<>();
        }
        return propietarioMutableLiveData;
   }

    public void datos(EditText dni,EditText apellido,EditText nombre, EditText telefono,EditText email,EditText pass, String[] perfil)
    {

            dni.setText(perfil[0]);

            apellido.setText(perfil[1]);

            nombre.setText(perfil[2]);

            telefono.setText(perfil[3]);

            email.setText(perfil[4]);

            pass.setText(perfil[5]);

    }

    public void cargarDatos(final Context ctx)
    {

           String token = "Bearer " + sp.leerToken(ctx);

           Call<List<Propietario>> res = ApiClient.getMyApiClient().TraerPropietario(token);

           res.enqueue(new Callback<List<Propietario>>() {
               @Override
               public void onResponse(Call<List<Propietario>> call, Response<List<Propietario>> response)
               {
                   if(response.isSuccessful()) {
                       List<Propietario> p = response.body();

                       propietarioMutableLiveData.postValue(p.get(0));
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
               public void onFailure(Call<List<Propietario>> call, Throwable t)
               {
                   Toast.makeText(ctx, t.getMessage(), Toast.LENGTH_SHORT).show();
               }
           });


    }

    public void ModificarPropietario(EditText nombre, EditText apellido, EditText dni, EditText tel, EditText mail, EditText clave, final Context ctx, int id)
    {
        Propietario p = new Propietario();
        p.setIdPropietario(id);
        p.setNombre(nombre.getText().toString());
        p.setApellido(apellido.getText().toString());
        p.setDni(dni.getText().toString());
        p.setTelefono(tel.getText().toString());
        p.setEmail(mail.getText().toString());
        p.setClave(clave.getText().toString());

        String token = "Bearer " + sp.leerToken(ctx);

        Call<Propietario> res = ApiClient.getMyApiClient().ActualizarPropietario(token, p);

        res.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if(response.isSuccessful())
                {
                    Toast.makeText(ctx, "Datos Actualizados", Toast.LENGTH_LONG).show();

                }
                else
                {
                    try
                    {
                        Toast.makeText(ctx, response.errorBody().string(), Toast.LENGTH_SHORT).show();
                    }
                    catch (IOException e)
                    {
                        Toast.makeText(ctx, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {

                Toast.makeText(ctx, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void modificacion(Context ct)
    {
        Toast.makeText(ct, "Datos Modificados Correctamente", Toast.LENGTH_LONG).show();
    }
}