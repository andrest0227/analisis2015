package com.numericos.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.numericos.proyectofinal.logic.Bisection;

import java.util.ArrayList;


public class Tabla extends Activity {
    private ArrayList<String> ArrayIteraciones = new ArrayList<String>();
    private Button tabla_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla);
        final Bundle parametros = this.getIntent().getExtras();


        tabla_button = (Button) findViewById(R.id.button);
        tabla_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayIteraciones = parametros.getStringArrayList("Array");
                TextView prueba = (TextView)findViewById(R.id.prueba);
                prueba.setText(ArrayIteraciones.get(3));
            }


        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabla, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
