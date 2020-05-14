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

import com.example.tpfinal.ui.Propiedades.PropiedadesViewModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class nav_Contratos extends Fragment {
 private ContratoViewModel vm;
 private ListView lv;
 private ArrayList<Contrato> list = new ArrayList<>();
 private View fragmentView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vm = ViewModelProviders.of(this).get(ContratoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_nav__contratos, container, false);
        fragmentView = root;
        list = vm.cargarDatosContrato();
        generarVista();
        return  root;
    }


    public void generarVista()
    {
        ArrayAdapter<Contrato> adapter = new ListaAdapter(fragmentView.getContext(),R.layout.item_contratos,list,getLayoutInflater());
        lv = fragmentView.findViewById(R.id.listContratos);
        lv.setAdapter(adapter);
    }


    public class ListaAdapter extends ArrayAdapter<Contrato>
    {
        Context ct ;
        List<Contrato> lista;
        LayoutInflater li;
        public ListaAdapter(@NonNull Context context, int resource, @NonNull List<Contrato> objects, LayoutInflater li) {
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
                itemView = li.inflate(R.layout.item_contratos,parent,false);
            }

            Contrato con = lista.get(position);
            Button btnPagos = itemView.findViewById(R.id.btnPagosContrato);
            btnPagos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(v).navigate(R.id.fragmentPagos);

                }
            });
            Button btnInquilinos = itemView.findViewById(R.id.btnInquilinoContrato);
            btnInquilinos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(v).navigate(R.id.nav_inquilinos);

                }
            });


            TextView direccion = itemView.findViewById(R.id.tvDireccionContrato);
            TextView precio = itemView.findViewById(R.id.tvPrecioContrato);
            TextView fechaInicio = itemView.findViewById(R.id.tvFechaInicioContrato);
            TextView fechaFinal = itemView.findViewById(R.id.tvFechaFinalContrato);
            vm.datos(direccion,precio,fechaInicio,fechaFinal,con);


            return  itemView;
        }
    }
}

