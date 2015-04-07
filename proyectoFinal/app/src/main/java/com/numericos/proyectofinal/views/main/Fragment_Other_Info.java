package com.numericos.proyectofinal.views.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import com.numericos.proyectofinal.R;

/**
 * Created by JU on 10/14/2014.
 */

public class Fragment_Other_Info extends Fragment {

    View rootView;
    int contador = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_other_info, container, false);
        TextView texto = (TextView) rootView.findViewById(R.id.texto_pedidos);
        ImageView image = (ImageView) rootView.findViewById(R.id.imageView);;

        image.setImageResource(R.drawable.savi);

        texto.setText("Numerical methods");
        contador++;

        return rootView;
    }
}
