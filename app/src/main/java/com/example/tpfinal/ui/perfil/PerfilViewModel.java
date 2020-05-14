package com.example.tpfinal.ui.perfil;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PerfilViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PerfilViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
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
    public void modificacion(Context ct)
    {
        Toast.makeText(ct, "Datos Modificados Correctamente", Toast.LENGTH_LONG).show();
    }
}