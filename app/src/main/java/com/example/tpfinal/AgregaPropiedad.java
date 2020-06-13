package com.example.tpfinal;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
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

import java.util.ArrayList;
import java.util.List;


public class AgregaPropiedad extends Fragment {

    private View root;
    private EditText direccion,precio,cantAmbientes;
    private Spinner spinner;
    private CheckBox estado;
    private ArrayList<String> listaspinner = new ArrayList<>();
    private AgregarPropiedadViewModel vm;
    private Button btnCrear;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vm = ViewModelProviders.of(this).get(AgregarPropiedadViewModel.class);
        root = inflater.inflate(R.layout.fragment_agrega_propiedad, container, false);

        vista();

        vm.tomarTiposInmuebles(getContext());

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.CrearInmueble(getContext(),direccion,precio,cantAmbientes,estado,spinner);
                Navigation.findNavController(v).navigate(R.id.nav_propiedades);
            }
        });

        vm.getSpinnerMutableLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                listaspinner = strings;
                ArrayAdapter<String> adaptador = new AgregaPropiedad.SpinnerAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,listaspinner,getLayoutInflater());
                adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adaptador);

            }
        });

        return root;
    }

    public void vista()
    {
        direccion = root.findViewById(R.id.etDireccionDetalles2);
        precio = root.findViewById(R.id.etPrecioDetalles2);
        cantAmbientes = root.findViewById(R.id.etCantAmbientesDetalles2);
        spinner = root.findViewById(R.id.spTIpos2);
        estado = root.findViewById(R.id.cbEstadoDetalles2);
        btnCrear = root.findViewById(R.id.btnGuardarDetallesProp2);
    }


    public class SpinnerAdapter extends ArrayAdapter<String>
    {
        Context ctx;
        List<String> list;
        LayoutInflater li ;
        public SpinnerAdapter(@NonNull Context context, int resource, @NonNull List<String> objects, LayoutInflater li) {
            super(context, resource, objects);
            ctx = context;
            list = objects;
            this.li = li;
        }

    }
}
