package com.numericos.proyectofinal.views.system_equations;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.logic.SystemsOfEquations;

/**
 * Created by JU on 10/21/2014.
 */

public class SeidelMethod extends Activity {

    private Button execute_button;
    private EditText matrix_editText, indepTerms_editText, tolerance_editText, iterations_editText, initial_values_editText, lambda_editText ;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seidel_method);

        execute_button = (Button) findViewById(R.id.gaussian_button);

        execute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                matrix_editText = (EditText) findViewById(R.id.gaussianMatrix_editText);
                String mtx = matrix_editText.getText().toString();

                indepTerms_editText = (EditText) findViewById(R.id.indep_terms_editText);
                String indepTerms = indepTerms_editText.getText().toString();

                tolerance_editText = (EditText) findViewById(R.id.editText);
                double tolerance = Double.parseDouble(tolerance_editText.getText().toString());

                iterations_editText = (EditText) findViewById(R.id.editText2);
                int iterations = Integer.parseInt(iterations_editText.getText().toString());

                initial_values_editText = (EditText) findViewById(R.id.editText3);
                String initialValues = initial_values_editText.getText().toString();

                lambda_editText = (EditText) findViewById(R.id.editText4);
                double lambda = Double.parseDouble(lambda_editText.getText().toString());

                SystemsOfEquations systemOfEquations = new SystemsOfEquations();
                double [][] matrix = systemOfEquations.textToMatrix(mtx);
                double [] vector = systemOfEquations.textToVector(indepTerms);
                double [] initialVal = systemOfEquations.textToVector(initialValues);

                systemOfEquations.Seidel(matrix, vector, tolerance, iterations, initialVal, lambda);
                String resultado = systemOfEquations.printTabla(systemOfEquations.getTabla());
                Log.d("ass", resultado);

                AlertDialog.Builder builder = new AlertDialog.Builder(SeidelMethod.this);
                builder.setMessage(resultado)
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {

                            }
                        });
                // Create the AlertDialog object and return it
                builder.create();
                builder.show();
            }
        });
    }
}
