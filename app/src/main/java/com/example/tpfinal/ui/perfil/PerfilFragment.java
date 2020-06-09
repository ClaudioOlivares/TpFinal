package com.example.tpfinal.ui.perfil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tpfinal.R;
import com.example.tpfinal.models.Propietario;

public class PerfilFragment extends Fragment{

    private PerfilViewModel perfilViewModel;
    private EditText dni,apellido,nombre,telefono,email,pass;
    private Button btn;
    private View root;
    private int id;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perfilViewModel = ViewModelProviders.of(this).get(PerfilViewModel.class);
        root = inflater.inflate(R.layout.fragment_perfil, container, false);
         vista();
        perfilViewModel.getPropietarioMutableLiveData().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
             @Override
             public void onChanged(Propietario propietario) {
                cargarDatosUsuario(propietario);
             }
         });
        perfilViewModel.cargarDatos(getContext());

        return root;

    }

    @Override
    public void onResume() {

        super.onResume();
    }

    private void vista()
    {
        dni = root.findViewById(R.id.etDni);

        apellido = root.findViewById(R.id.etApellido);

        nombre = root.findViewById(R.id.etName);

        telefono = root.findViewById(R.id.etTelefono);

        email = root.findViewById(R.id.etEmail);

        pass = root.findViewById(R.id.etPassword);

        btn = root.findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               perfilViewModel.ModificarPropietario(nombre,apellido,dni,telefono,email,pass,getContext(),id);
            }
        });
    }

    public void cargarDatosUsuario(Propietario p)
    {
        id = p.getIdPropietario();

        dni.setText(p.getDni());

        apellido.setText(p.getDni());

        nombre.setText(p.getNombre());

        telefono.setText(p.getTelefono());

        email.setText(p.getEmail());

        //pass.setText(p.getClave());
    }


}
