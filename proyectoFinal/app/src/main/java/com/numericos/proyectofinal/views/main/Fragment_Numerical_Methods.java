package com.numericos.proyectofinal.views.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.views.interpolation.Fragment_Interpolation;
import com.numericos.proyectofinal.views.numerical_integration.Fragment_Numerical_Integration;
import com.numericos.proyectofinal.views.single_variable.BisectionMethod;
import com.numericos.proyectofinal.views.single_variable.Entrada_datos_single_variables;
import com.numericos.proyectofinal.views.single_variable.FalsePositionMethod;
import com.numericos.proyectofinal.views.single_variable.Fragment_Single_Variable;
import com.numericos.proyectofinal.views.system_equations.Fragment_System_Equation;
import com.numericos.proyectofinal.views.util.ListViewAdapter;


/**
 * Created by JU on 10/14/2014.
 */

public class Fragment_Numerical_Methods extends Fragment {
    View rootView;
    ListViewAdapter adapter;

    String[] titulo = new String[]{
            "Single variables",
            "Systems of Equations",
            "Interpolation",
            "Numerical integration"
    };


    int[] imagenes = {
            R.drawable.single_variable,
            R.drawable.multiple_variables,
            R.drawable.interpolation,
            R.drawable.numerical_integration,
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_numerical_methods, container, false);

        final ListView lista = (ListView) rootView.findViewById(R.id.listView1);
        adapter = new ListViewAdapter(getActivity(), titulo, imagenes);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "Selected " + i, Toast.LENGTH_SHORT).show();

                Intent ii = null;
                switch (i) {
                    case 0:
                        ii = new Intent(getActivity(), Entrada_datos_single_variables.class);
                        startActivity(ii);
                        break;
                    case 1:
                        ii = new Intent(getActivity(), Fragment_System_Equation.class);
                        startActivity(ii);
                        break;
                    case 2:
                        ii = new Intent(getActivity(), Fragment_Interpolation.class);
                        startActivity(ii);
                        break;
                    case 3:
                        ii = new Intent(getActivity(), Fragment_Numerical_Integration.class);
                        startActivity(ii);
                        break;
                }

            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "Selected large " + i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return rootView;
    }
}
