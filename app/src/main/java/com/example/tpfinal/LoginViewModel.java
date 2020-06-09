package com.example.tpfinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.example.tpfinal.models.Usuario;
import com.example.tpfinal.request.ApiClient;
import com.example.tpfinal.sharedprefs.Sharedprefs;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel  {
      Sharedprefs sp;

public void validar(EditText email, EditText pass, final Intent i, final Context ct)
{

      Usuario user = new Usuario();
      user.setEmail(email.getText().toString());
      user.setClave(pass.getText().toString());
      Call<String> res =  ApiClient.getMyApiClient().logear(user);
      res.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                  if(response.isSuccessful())
                  {
                        sp.conectar(ct);
                        sp.guardarToken(ct,response.body());
                        ct.startActivity(i);
                  }
                  else
                  {
                        try {
                              Toast.makeText(ct, response.errorBody().string() , Toast.LENGTH_LONG).show();
                        } catch (IOException e) {
                              e.printStackTrace();
                        }
                  }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                  Toast.makeText(ct,  t.getMessage(), Toast.LENGTH_LONG).show();
            }
      });

}
}

