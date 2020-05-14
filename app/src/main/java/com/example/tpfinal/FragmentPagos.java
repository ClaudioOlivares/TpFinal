package com.example.tpfinal;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/*instance of this fragment.
 */
public class FragmentPagos extends Fragment {

    private View fragmentView;
    private ListView lv;
    private ArrayList<Pago> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_pagos, container, false);
        fragmentView = root;
        datos();
        generarVista();
        return root;
    }

    public void datos()
    {
        list.add(new Pago("7500","1","NO PAGADO"));
    }
    public void generarVista()
    {
        ArrayAdapter<Pago> adapter = new ListaAdapter(fragmentView.getContext(),R.layout.item_pago,list,getLayoutInflater());
        lv = fragmentView.findViewById(R.id.listPagos);
        lv.setAdapter(adapter);
    }
    public class ListaAdapter extends ArrayAdapter<Pago>
    {
        Context ct;
        List<Pago> lista;
        LayoutInflater li;
        public ListaAdapter(@NonNull Context context, int resource, @NonNull List<Pago> objects,LayoutInflater li) {
            super(context, resource, objects);
            this.ct = context;
            this.lista = objects;
            this.li = li;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
           View itemView = convertView;
           if(itemView == null)
           {
               itemView = li.inflate(R.layout.item_pago,parent,false);
           }
            Pago p =  lista.get(position);
            TextView importe = itemView.findViewById(R.id.tvImportePago);
            TextView fechaPago = itemView.findViewById(R.id.tvFechaPago);
            TextView  nroPago = itemView.findViewById(R.id.tvNumeroPago);
            importe.setText(p.importe);
            fechaPago.setText(p.fechaPago);
            nroPago.setText(p.nroPago);

            return itemView;

        }
    }
}
