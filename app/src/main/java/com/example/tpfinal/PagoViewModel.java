package com.example.tpfinal;

import android.widget.TextView;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class PagoViewModel extends ViewModel {

public ArrayList<Pago> datos()
{
    ArrayList<Pago> list = new ArrayList<>();
    list.add(new Pago("7500","1","NO PAGADO"));
    return  list;

}

public void CargarDatos(TextView importe, TextView fechaPago, TextView nroPago, Pago p)
{
    importe.setText(p.importe);
    fechaPago.setText(p.fechaPago);
    nroPago.setText(p.nroPago);
}


}
