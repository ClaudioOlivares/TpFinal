package com.example.tpfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tpfinal.models.Inmueble;
import com.example.tpfinal.ui.Propiedades.PropiedadesViewModel;


public class DetallesPropiedades extends Fragment {

private Button btnGuardarCambios;

private EditText direccion, precio, tipoinmueble,cantAmbientes;

private CheckBox estado;

private int id;

private DetallesPropiedadesViewModel vm;

View root ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
        {
            vm = ViewModelProviders.of(this).get(DetallesPropiedadesViewModel.class);

            root = inflater.inflate(R.layout.fragment_detalles_propiedades, container, false);

            id = getArguments().getInt("id");

            vista();

            vm.CargarDatosPropiedad(id,getContext());

            vm.getInmueblesMutableLiveData().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
                @Override
                public void onChanged(Inmueble inmueble) {

                    vm.completarDatos(direccion,precio,tipoinmueble,cantAmbientes,estado,getContext(),inmueble);
                }
            });

            btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  /*  Toast.makeText(root.getContext(), "Datos Guardados Correctamente", Toast.LENGTH_LONG).show();

                    Navigation.findNavController(v).navigate(R.id.nav_propiedades);*/


            }
        });

        return root;
    }



    public void vista()
    {
        direccion = root.findViewById(R.id.etDireccionDetalles);

        precio = root.findViewById(R.id.etPrecioDetalles);

        cantAmbientes = root.findViewById(R.id.etCantAmbientesDetalles);

        tipoinmueble = root.findViewById(R.id.etTipoInmuebleDetalles);

        estado = root.findViewById(R.id.cbEstadoDetalles);

        btnGuardarCambios = root.findViewById(R.id.btnGuardarDetallesProp);
    }



}
