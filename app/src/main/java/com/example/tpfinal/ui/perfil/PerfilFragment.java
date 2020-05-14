package com.example.tpfinal.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.tpfinal.R;

public class PerfilFragment extends Fragment{

    private PerfilViewModel perfilViewModel;
    private EditText dni,apellido,nombre,telefono,email,pass;
    private Button btn;
    private String [] perfil = {"33.444.555","Garro","Exequiel", "2664223345","123@gmail.com","123"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perfilViewModel = ViewModelProviders.of(this).get(PerfilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
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
                 perfilViewModel.modificacion(getActivity());
             }
         });
        perfilViewModel.datos(dni,apellido,nombre,telefono,email,pass,perfil);

        return root;


    }

    @Override
    public void onResume() {

        super.onResume();
    }


}
