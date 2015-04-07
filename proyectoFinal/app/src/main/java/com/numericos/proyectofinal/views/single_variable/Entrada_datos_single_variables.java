package com.numericos.proyectofinal.views.single_variable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.views.util.ListViewAdapter;


public class Entrada_datos_single_variables extends Activity {
    ListViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_datos_single_variables);

    }

    public void Hacer(View v) {
        EditText Xi = (EditText)findViewById(R.id.datoXi_single_variables);
        EditText Xs = (EditText)findViewById(R.id.datoXs_single_variables);
        EditText Fx = (EditText)findViewById(R.id.datoFx_single_variables);
        EditText Tolerance = (EditText)findViewById(R.id.datoTolerance_single_variables);
        EditText Iterations = (EditText)findViewById(R.id.datoIterations_single_variables);
        EditText Delta = (EditText)findViewById(R.id.datoDelta_single_variables);
        EditText Gx = (EditText)findViewById(R.id.datoGx_single_variables);
        EditText FxP = (EditText)findViewById(R.id.datoFxP_single_variables);


        String Xi2 = Xi.getText().toString();
        String Xs2 = Xs.getText().toString();
        String Fx2 = Fx.getText().toString();
        String Tolerance2 = Tolerance.getText().toString();
        String Iterations2 = Iterations.getText().toString();
        String Delta2 = Delta.getText().toString();
        String Gx2 = Gx.getText().toString();
        String FxP2 = FxP.getText().toString();

        Bundle parametros = new Bundle();
        parametros.putString("Xi", Xi2);
        parametros.putString("Xs", Xs2);
        parametros.putString("Fx", Fx2);
        parametros.putString("Tolerance", Tolerance2);
        parametros.putString("Iterations", Iterations2);
        parametros.putString("Delta", Delta2);
        parametros.putString("Gx", Gx2);
        parametros.putString("FxP", FxP2);


        finish();
        Intent SingleVariable = new Intent(this,Fragment_Single_Variable.class);
        SingleVariable.putExtras(parametros);
        startActivity(SingleVariable);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entrada_datos_single_variables, menu);
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
