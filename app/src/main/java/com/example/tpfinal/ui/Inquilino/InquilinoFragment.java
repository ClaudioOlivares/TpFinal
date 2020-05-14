package com.example.tpfinal.ui.Inquilino;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.tpfinal.Inquilino;
import com.example.tpfinal.R;

import java.util.ArrayList;
import java.util.List;

public class InquilinoFragment extends Fragment {

    private InquilinoViewModel inquiViewModel;
    private ArrayList<Inquilino> list = new ArrayList<>();
    private  ListView lv;
    private View fragmentView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        inquiViewModel = ViewModelProviders.of(this).get(InquilinoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inquilinos, container, false);
        fragmentView = root;
        list = inquiViewModel.cargarDatosInquilinos();
        generarVista();

        return root;
    }
    public void generarVista()
    {
        ArrayAdapter<Inquilino> adapter = new ListaAdapter(fragmentView.getContext(),R.layout.item_inquilinos,list,getLayoutInflater());
        ListView lv = fragmentView.findViewById(R.id.listInquilinos);

        lv.setAdapter(adapter);
    }

    public class ListaAdapter extends ArrayAdapter<Inquilino>
    {
        private Context ct;
        private List<Inquilino> lista;
        private LayoutInflater li;
        public ListaAdapter(@NonNull Context context, int resource, @NonNull List<Inquilino> objects, LayoutInflater li) {
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
                itemView = li.inflate(R.layout.item_inquilinos,parent,false);
            }
            Inquilino inqui = lista.get(position);

            TextView dni = itemView.findViewById(R.id.tvDniInquilino);
            TextView apellido = itemView.findViewById(R.id.tvApellidoInquilino);
            TextView nombre = itemView.findViewById(R.id.tvNombreInquilino);
            TextView trabajo = itemView.findViewById(R.id.tvTrabajoInquilino);

            inquiViewModel.datos(inqui,dni,apellido,nombre,trabajo);
            return  itemView;
        }
    }
}
