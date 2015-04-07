package com.numericos.proyectofinal.views.numerical_integration;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.logic.CompoundTrapeze;
import com.numericos.proyectofinal.logic.Simpson3_8;
import com.numericos.proyectofinal.views.single_variable.BisectionMethod;
import com.numericos.proyectofinal.views.single_variable.FalsePositionMethod;
import com.numericos.proyectofinal.views.single_variable.FixedPointMethod;
import com.numericos.proyectofinal.views.single_variable.IncrementalSearchMethod;
import com.numericos.proyectofinal.views.single_variable.MultipleRootsMethod;
import com.numericos.proyectofinal.views.single_variable.NewtonMethod;
import com.numericos.proyectofinal.views.single_variable.SecantMethod;
import com.numericos.proyectofinal.views.util.ListViewAdapter;

/**
 * Created by Sara Castrillón on 22/11/2014.
 */
public class Fragment_Numerical_Integration extends Activity{
    View rootView;
    ListViewAdapter adapter;

    String[] titulo = new String[]{

            "Simple trapeze",
            "Compound trapeze",
            "Simpson 1/3",
            "Compound simpson 1/3",
            "Simpson 3/8",
            "Compound simpson 3/8"

    };

    int[] imagenes = {
            R.drawable.numerical_integration,
            R.drawable.numerical_integration,
            R.drawable.numerical_integration,
            R.drawable.numerical_integration,
            R.drawable.numerical_integration,
            R.drawable.numerical_integration

    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_numerical_integration);


        final ListView lista = (ListView) findViewById(R.id.listView5);
        adapter = new ListViewAdapter(getApplicationContext(), titulo, imagenes);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Selected " + position, Toast.LENGTH_SHORT).show();

                Intent ii = null;
                switch (position) {
                    case 0:
                        ii = new Intent(getApplicationContext(), SimpleTrapezeMethod.class);
                        startActivity(ii);
                        break;
                    case 1:
                        ii = new Intent(getApplicationContext(), CompoundTrapezeMethod.class);
                        startActivity(ii);
                        break;
                    case 2:
                        ii = new Intent(getApplicationContext(), Simpson1_3Method.class);
                        startActivity(ii);
                        break;
                    case 3:
                        ii = new Intent(getApplicationContext(), CompoundSimpson1_3Method.class);
                        startActivity(ii);
                        break;
                    case 4:
                        ii = new Intent(getApplicationContext(), Simpson3_8Method.class);
                        startActivity(ii);
                        break;
                    case 5:
                        ii = new Intent(getApplicationContext(), CompoundSimpson3_8Method.class);
                        startActivity(ii);
                        break;

                }

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
