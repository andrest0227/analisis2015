package com.numericos.proyectofinal.views.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.views.util.ListViewAdapter;

/**
 * Created by JU on 10/14/2014.
 */

public class Fragment_About extends Fragment {

    View rootView;

    ListViewAdapter adapter;

    String[] titulo = new String[]{
             "Ana Maria Ramirez",
            "David Alejandro Rivera",
            "Andres Felipe Tirado"
    };

    String[] description = new String[]{

            "Developer ",
            "Developer",
            "Developer"
    };

    int[] imagenes = {
            R.drawable.ana,
            R.drawable.juanda,
            R.drawable.juanda
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_about, container, false);

        final ListView lista = (ListView) rootView.findViewById(R.id.listView1);
        adapter = new ListViewAdapter(getActivity(), titulo, imagenes, description);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "selected " + i, Toast.LENGTH_SHORT).show();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "selected LARGO " + i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return rootView;
    }
}
