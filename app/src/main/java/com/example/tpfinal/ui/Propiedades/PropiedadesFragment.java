package com.example.tpfinal.ui.Propiedades;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.tpfinal.Propiedad;
import com.example.tpfinal.R;
import com.example.tpfinal.models.Inmueble;

import java.nio.charset.spi.CharsetProvider;
import java.util.ArrayList;
import java.util.List;

public class PropiedadesFragment extends Fragment {

    private PropiedadesViewModel PropiedadesViewModel;
    private ListView lv;
    private List<Inmueble> list = new ArrayList<>();
    private View fragmentView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PropiedadesViewModel = ViewModelProviders.of(this).get(PropiedadesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_propiedades, container, false);
        fragmentView = root;
        PropiedadesViewModel.Obtenerdatos(getContext());
        PropiedadesViewModel.getInmueblesMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                list = inmuebles;
                generarVista();
            }
        });

        generarVista();
        return root;
    }


    public void generarVista()
    {
        ArrayAdapter<Inmueble> adapter = new ListaAdapater(fragmentView.getContext(),R.layout.item_propiedad,list,getLayoutInflater());
        ListView lv = fragmentView.findViewById(R.id.listPropiedades);
        lv.setDivider(this.getResources().getDrawable(R.drawable.transperent));
        lv.setDividerHeight(16);
        lv.setAdapter(adapter);


    }

    public class ListaAdapater extends ArrayAdapter<Inmueble>
    {
        Context ct;
        List<Inmueble> lista;
        LayoutInflater li;

        public ListaAdapater(@NonNull Context context, int resource, @NonNull List<Inmueble> objects,LayoutInflater li) {
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
                itemView = li.inflate(R.layout.item_propiedad,parent,false);

            }
            final Inmueble prop = lista.get(position);

            TextView precio = itemView.findViewById(R.id.tvPrecio);
            TextView direccion = itemView.findViewById(R.id.tvDire);
            PropiedadesViewModel.datos(precio,direccion,prop);
             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("id",prop.getIdInmueble());
                    Navigation.findNavController(v).navigate(R.id.detallesPropiedades,bundle);
                 }
             });
            return itemView;

        }
    }




}
