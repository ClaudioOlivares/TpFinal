package com.example.tpfinal.ui.Inquilino;

import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpfinal.Inquilino;

import java.util.ArrayList;

public class InquilinoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InquilinoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }


    public void datos(Inquilino inqui, TextView dni,  TextView apellido, TextView nombre,  TextView trabajo)
    {
        dni.setText(inqui.getDni());
        apellido.setText(inqui.getApellido());
        nombre.setText(inqui.getNombre());
        trabajo.setText(inqui.getTrabajo());

    }
    public ArrayList<Inquilino> cargarDatosInquilinos()
    {
        ArrayList<Inquilino> lista = new ArrayList<>();

        lista.add(new Inquilino("Alberto","Samid","23445556","Avalador de Bombas"));


        return lista;
    }
}
