package com.example.tpfinal.ui.Propiedades;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpfinal.Propiedad;
import com.example.tpfinal.R;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PropiedadesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }


    public ArrayList<Propiedad> cargarDatosPropiedad()
    {
        ArrayList<Propiedad> list = new ArrayList<>();
        list.add(new Propiedad(R.drawable.caba1,"10000","Juana Koslay"));
        list.add(new Propiedad(R.drawable.caba2,"7500","Potrero de Los Funes"));
        list.add(new Propiedad(R.drawable.caba3,"11500","Trapiche"));

        return  list;
    }

    public void datos(ImageView foto, TextView precio, TextView direccion, Propiedad p)
    {
        precio.setText(p.getPrecio());
        direccion.setText(p.getDireccion());
        foto.setImageResource(p.getFoto());

    }
}