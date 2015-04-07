package com.numericos.proyectofinal.views.single_variable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.Tabla;
import com.numericos.proyectofinal.logic.Bisection;

import java.util.ArrayList;


public class BisectionPrueba extends Activity {
    private Button execute_button;
    private Button tabla_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bisection_prueba);
        /*Bisection bisection;
        Bundle parametros = this.getIntent().getExtras();
        final String xibiseccion = parametros.getString("Xi");
        final String xsbiseccion = parametros.getString("Xs");
        final String tolerance = parametros.getString("Tolerance");
        final String iterations = parametros.getString("Iterations");
        final String function = parametros.getString("Fx");

        TextView Xi = (TextView)findViewById(R.id.Xi);

        Xi.setText(xibiseccion);

        TextView Xs = (TextView)findViewById(R.id.Xs);
        Xs.setText(xsbiseccion);

        TextView Tolerance = (TextView)findViewById(R.id.Tolerance);
        String Tolerancebiseccion = parametros.getString("Tolerance");
        Tolerance.setText(Tolerancebiseccion);

        TextView Iterations = (TextView)findViewById(R.id.Iterations);
        String Iterationsbiseccion = parametros.getString("Iterations");
        Iterations.setText(Iterationsbiseccion);

        TextView Fx = (TextView)findViewById(R.id.Fx);
        String Fxbiseccion = parametros.getString("Fx");
        Fx.setText(Fxbiseccion);

        execute_button = (Button) findViewById(R.id.Bisection_button);
        execute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bisection bisection;
                bisection = new Bisection();

                Double X0=Double.parseDouble(xibiseccion);
                Double X1=Double.parseDouble(xsbiseccion);
                Double TOLERANCE=Double.parseDouble(tolerance);
                Double ITERATIONS=Double.parseDouble(iterations);
                bisection.setX0(X0);
                bisection.setX1(X1);
                bisection.setTolerance(TOLERANCE);
                bisection.setIterations(ITERATIONS);
                bisection.setFx(function);


                String resultado = bisection.bisectionMethod(X0,X1,TOLERANCE,ITERATIONS);
                TextView Resultado = (TextView)findViewById(R.id.Resultado_bisection);
                Resultado.setText(resultado);

                ArrayList<Double> ArrayIteracionesAux = new ArrayList<Double>();

                ArrayIteracionesAux = bisection.getArray();
                ArrayList<String> ArrayStrings= new ArrayList<String>();
                for(int i=0;i<bisection.getArray().size(); i++)
                {
                    String aux= ArrayIteracionesAux.get(i).toString();
                    ArrayStrings.add(aux);
                }
                Context context = getApplicationContext();
                String text = ArrayStrings.get(3);
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });*/

        tabla_button = (Button) findViewById(R.id.tabla_button);
        tabla_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 ArrayList<Double> ArrayIteracionesAux = new ArrayList<Double>();
                Bisection bisection;
                bisection = new Bisection();
                ArrayIteracionesAux = bisection.getArray();
                Bundle parametros = new Bundle();
                ArrayList<String> ArrayStrings= new ArrayList<String>();
                for(int i=0;i<bisection.getArray().size(); i++)
                {
                    String aux= ArrayIteracionesAux.get(i).toString();
                    ArrayStrings.add(aux);
                }

                parametros.putStringArrayList("Array", ArrayStrings);
                Intent SingleVariable = new Intent(getApplicationContext(),Tabla.class);
                SingleVariable.putExtras(parametros);
                startActivity(SingleVariable);


            }
        });



    }

    public void ejecutar(){
    Bisection bisection;
        Bundle parametros = this.getIntent().getExtras();
        String xibiseccion = parametros.getString("Xi");
        String xsbiseccion = parametros.getString("Xs");
        String tolerance = parametros.getString("Tolerance");
        String iterations = parametros.getString("Iterations");
        String function = parametros.getString("Fx");

        bisection = new Bisection();

        Double X0=Double.parseDouble(xibiseccion);
        Double X1=Double.parseDouble(xsbiseccion);
        Double TOLERANCE=Double.parseDouble(tolerance);
        Double ITERATIONS=Double.parseDouble(iterations);
        bisection.setX0(X0);
        bisection.setX1(X1);
        bisection.setTolerance(TOLERANCE);
        bisection.setIterations(ITERATIONS);
        bisection.setFx(function);


        String resultado = bisection.bisectionMethod(X0,X1,TOLERANCE,ITERATIONS);
        TextView Resultado = (TextView)findViewById(R.id.Resultado_bisection);
        Resultado.setText(resultado);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bisection_prueba, menu);
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
