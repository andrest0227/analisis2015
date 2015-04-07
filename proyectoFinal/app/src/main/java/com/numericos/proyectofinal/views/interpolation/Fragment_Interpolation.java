package com.numericos.proyectofinal.views.interpolation;

import android.app.Activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.logic.Lagrange;
import com.numericos.proyectofinal.logic.Neville;
import com.numericos.proyectofinal.logic.Newton_For_Interpolation;
import com.numericos.proyectofinal.views.util.ListViewAdapter;

/**
 * Created by Sara Castrillón on 25/11/2014.
 */
public class Fragment_Interpolation extends Activity {


        ListViewAdapter adapter;

        String[] titulo = new String[]{
                "Lagrange",
                "Neville",
                "Newton"

        };

        int[] imagenes = {
                R.drawable.interpolation,
                R.drawable.interpolation,
                R.drawable.interpolation
                        };

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_interpolation);


            final ListView lista = (ListView) findViewById(R.id.listView1);
            adapter = new ListViewAdapter(getApplicationContext(), titulo, imagenes);
            lista.setAdapter(adapter);

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                    Toast.makeText(getApplicationContext(), "You selected " + position, Toast.LENGTH_SHORT).show();

                    Intent ii = null;
                    switch (position) {
                        case 0:
                            ii = new Intent(getApplicationContext(), Lagrange_Method.class);
                            startActivity(ii);
                            break;
                        case 1:
                            ii = new Intent(getApplicationContext(), Neville_Method.class);
                            startActivity(ii);
                            break;
                        case 2:
                            ii = new Intent(getApplicationContext(), Newton_For_Interpolation_Method.class);
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

