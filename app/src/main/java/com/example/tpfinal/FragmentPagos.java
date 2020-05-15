package com.example.tpfinal;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tpfinal.ui.Propiedades.PropiedadesViewModel;

import java.util.ArrayList;
import java.util.List;


/*instance of this fragment.
 */
public class FragmentPagos extends Fragment {

    private View fragmentView;
    private ListView lv;
    private ArrayList<Pago> list = new ArrayList<>();
    private PagoViewModel vm;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vm = ViewModelProviders.of(this).get(PagoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pagos, container, false);
        fragmentView = root;
        list = vm.datos();
        generarVista();
        return root;
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
            Button btnPagar = itemView.findViewById(R.id.btnPagar);
            btnPagar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(v).navigate(R.id.nav_Contratos);
                    Toast.makeText(getActivity(), "Pago Realizado", Toast.LENGTH_LONG).show();

                }
            });
            vm.CargarDatos(importe,fechaPago,nroPago,p);

            return itemView;

        }
    }
}
