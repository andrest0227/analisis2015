package com.numericos.proyectofinal.views.single_variable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.logic.IncrementalSearch;
import com.numericos.proyectofinal.logic.Bisection;
import com.numericos.proyectofinal.views.util.CustomKeyboard;

/**
 * Created by Sara Castrillon 10/21/2014.
 */

public class BisectionMethod extends Activity {


    private Bisection bisection;
    private Button execute_button;
    private EditText x0_editText,x1_editText, tolerance_editText, iterations_editText, function_editText, result_editText;
    private String resultado;
    private CustomKeyboard mCustomKeyboard;


    public BisectionMethod(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bisection_method);

        /*Bundle parametros = this.getIntent().getExtras();
        final String xibiseccion = parametros.getString("Xi");
        final String xsbiseccion = parametros.getString("Xs");
        final String tolerance = parametros.getString("Tolerance");
        final String iterations = parametros.getString("Iterations");
        final String function = parametros.getString("Fx");
*/


        mCustomKeyboard= new CustomKeyboard(this, R.id.keyboardview, R.xml.hexkbd );
        mCustomKeyboard.registerEditText(R.id.function_editText);
        mCustomKeyboard.registerEditText(R.id.x0_editText);
        mCustomKeyboard.registerEditText(R.id.x1_editText);
        //mCustomKeyboard.registerEditText(R.id.tolerance_editText);
        //mCustomKeyboard.registerEditText(R.id.iteraciones_editText);

        bisection = new Bisection();

        execute_button = (Button) findViewById(R.id.execute_button);
        execute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  Bisection bisection;
                bisection = new Bisection();

                Double X0=Double.parseDouble(xibiseccion);
                Double X1=Double.parseDouble(xsbiseccion);
                Double TOLERANCE=Double.parseDouble(tolerance);
                Double ITERATIONS=Double.parseDouble(iterations);

                bisection.setX0(X0);
                bisection.setX1(X1);
                bisection.setTolerance(TOLERANCE);
                bisection.setIterations(ITERATIONS);
                bisection.setFx(function);*/

                x0_editText = (EditText) findViewById(R.id.x0_editText);
                x1_editText = (EditText) findViewById(R.id.x1_editText);
                tolerance_editText = (EditText) findViewById(R.id.tolerance_editText);
                iterations_editText = (EditText) findViewById(R.id.iterations_editText);
                function_editText = (EditText) findViewById(R.id.function_editText);
                result_editText = (EditText)findViewById(R.id.result_editText);

                double x0 = Double.parseDouble(x0_editText.getText().toString());
                double x1 = Double.parseDouble(x1_editText.getText().toString());
                double tolerance = Double.parseDouble(tolerance_editText.getText().toString());
                double iterations = Double.parseDouble(iterations_editText.getText().toString());
                String funct = function_editText.getText().toString();

                bisection.setX0(x0);
                bisection.setX0(x1);
                bisection.setTolerance(tolerance);
                bisection.setIterations(iterations);
                bisection.setFx(funct);


                resultado = bisection.bisectionMethod(x0,x1,tolerance,iterations);


                //function_editText.setTextColor(Color.RED);
                String displayString = "The result is: " + resultado;


                result_editText.setText(displayString, TextView.BufferType.EDITABLE);

                Toast msg = Toast.makeText(getBaseContext(), displayString,
                        Toast.LENGTH_LONG);
                msg.show();
            }
        });

    }

    @Override public void onBackPressed() {
        // NOTE Trap the back key: when the CustomKeyboard is still visible hide it, only when it is invisible, finish activity
        if( mCustomKeyboard.isCustomKeyboardVisible() ) mCustomKeyboard.hideCustomKeyboard(); else this.finish();
    }

}
