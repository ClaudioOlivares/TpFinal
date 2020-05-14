package com.example.tpfinal;

import android.widget.TextView;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ContratoViewModel extends ViewModel {


    public void datos(TextView direccion,TextView precio,TextView fechaInicio,TextView fechaFinal,Contrato c)

    {
        direccion.setText(c.getDireccion());
        precio.setText(c.getPrecio());
        fechaInicio.setText(c.getFechaInicio());
        fechaFinal.setText(c.getFechaFinal());
    }

    public ArrayList<Contrato> cargarDatosContrato()
    {
        ArrayList<Contrato> list = new ArrayList<>();
        list.add(new Contrato("22-05-2020","22/07/2020","75000","Juana Koslay"));
        list.add(new Contrato("22-07-2020","22/10/2020","75000","Juana Koslay"));
        return  list;
    }
}
