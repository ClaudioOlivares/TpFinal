package com.example.tpfinal;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.tpfinal.models.Inmueble;
import com.example.tpfinal.ui.Propiedades.PropiedadesViewModel;

import java.util.ArrayList;
import java.util.List;


public class DetallesPropiedades extends Fragment {

private Button btnGuardarCambios;

private EditText direccion, precio, tipoinmueble,cantAmbientes;

private CheckBox estado;

private int id;

private DetallesPropiedadesViewModel vm;

private Spinner sp;

private ArrayList<String> listaspinner = new ArrayList<>();


View root ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
        {
            vm = ViewModelProviders.of(this).get(DetallesPropiedadesViewModel.class);

            root = inflater.inflate(R.layout.fragment_detalles_propiedades, container, false);

            id = getArguments().getInt("id");

            vista();

            vm.tomarTiposInmuebles(getContext());

            vm.getSpinnerMutableLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<String>>() {
                @Override
                public void onChanged(ArrayList<String> strings) {
                    listaspinner = strings;
                }
            });

            vm.CargarDatosPropiedad(id,getContext());

            vm.getInmueblesMutableLiveData().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
                @Override
                public void onChanged(Inmueble inmueble) {

                    ArrayAdapter<String> adaptador = new SpinnerAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,listaspinner,getLayoutInflater());
                    adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp.setAdapter(adaptador);

                    vm.completarDatos(direccion,precio,tipoinmueble,cantAmbientes,estado,getContext(),inmueble,sp);
                }
            });

            btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  /*  Toast.makeText(root.getContext(), "Datos Guardados Correctamente", Toast.LENGTH_LONG).show();

                    Navigation.findNavController(v).navigate(R.id.nav_propiedades);*/
                  vm.ActualizarInmueble(direccion,precio,cantAmbientes,sp,estado,getContext(),id);

            }
        });

        return root;
    }



    public void vista()
    {
        direccion = root.findViewById(R.id.etDireccionDetalles);

        precio = root.findViewById(R.id.etPrecioDetalles);

        cantAmbientes = root.findViewById(R.id.etCantAmbientesDetalles);

       // tipoinmueble = root.findViewById(R.id.etTipoInmuebleDetalles);

        sp = root.findViewById(R.id.spTIpos);

        estado = root.findViewById(R.id.cbEstadoDetalles);

        btnGuardarCambios = root.findViewById(R.id.btnGuardarDetallesProp);
    }


    public class SpinnerAdapter extends ArrayAdapter<String>
    {
        Context ctx;
        List<String> list;
        LayoutInflater li ;
        public SpinnerAdapter(@NonNull Context context, int resource, @NonNull List<String> objects,LayoutInflater li) {
            super(context, resource, objects);
            ctx = context;
            list = objects;
            this.li = li;
        }


    }




}
