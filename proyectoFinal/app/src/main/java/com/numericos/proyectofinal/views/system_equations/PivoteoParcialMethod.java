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

public class PivoteoParcialMethod extends Activity {

    private Button execute_button;
    private EditText matrix_editText, indepTerms_editText;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eg_pivoteo_parcial_method);

        execute_button = (Button) findViewById(R.id.pivoteo_total_button);

        execute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                matrix_editText = (EditText) findViewById(R.id.matrix_editText);
                String mtx = matrix_editText.getText().toString();

                indepTerms_editText = (EditText) findViewById(R.id.indep_terms_editText);
                String indepTerms = indepTerms_editText.getText().toString();

                SystemsOfEquations systemOfEquations = new SystemsOfEquations();
                double [][] matrix = systemOfEquations.textToMatrix(mtx);
                double [] vector = systemOfEquations.textToVector(indepTerms);

                systemOfEquations.eliminacionGauss(matrix, vector, 0);
                Log.d("ass", systemOfEquations.getRes());

                AlertDialog.Builder builder = new AlertDialog.Builder(PivoteoParcialMethod.this);
                builder.setMessage(systemOfEquations.getRes())
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
