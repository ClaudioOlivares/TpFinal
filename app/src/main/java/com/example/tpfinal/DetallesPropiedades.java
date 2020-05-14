package com.example.tpfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class DetallesPropiedades extends Fragment {
private Button btnGuardarCambios;
View root ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_detalles_propiedades, container, false);
        // Inflate the layout for this fragment

        btnGuardarCambios = root.findViewById(R.id.btnGuardarDetallesProp);
        btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(root.getContext(), "Datos Guardados Correctamente", Toast.LENGTH_LONG).show();
                Navigation.findNavController(v).navigate(R.id.nav_propiedades);

            }
        });
        return root;
    }
}
