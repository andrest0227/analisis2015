package com.numericos.proyectofinal.views.interpolation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.logic.Lagrange;
import com.numericos.proyectofinal.logic.Newton_For_Interpolation;
import com.numericos.proyectofinal.logic.SystemsOfEquations;

/**
 * Created by Sara Castrillón on 25/11/2014.
 */
public class Newton_For_Interpolation_Method extends Activity {
    private Button execute_button;
    private EditText matrix_editText, indepTerms_editText, interpolated_Value_editText;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newton_for_interpolation);

        execute_button = (Button) findViewById(R.id.gaussian_button);

        execute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                matrix_editText = (EditText) findViewById(R.id.gaussianMatrix_editText);
                String mtx = matrix_editText.getText().toString();

                indepTerms_editText = (EditText) findViewById(R.id.indep_terms_editText);
                String indepTerms = indepTerms_editText.getText().toString();

                interpolated_Value_editText = (EditText) findViewById(R.id.interpolated_value_editText);
                String interpolatedvalue = interpolated_Value_editText.getText().toString();
                Double i_value = Double.valueOf(interpolatedvalue).doubleValue();

                Newton_For_Interpolation nFori = new Newton_For_Interpolation();
                SystemsOfEquations systemOfEquations = new SystemsOfEquations();
                double [] matrix = systemOfEquations.textToVector(mtx);
                double [] vector = systemOfEquations.textToVector(indepTerms);

                nFori.Newton(matrix, vector, i_value);
                Log.d("ass", nFori.getRes());

                AlertDialog.Builder builder = new AlertDialog.Builder(Newton_For_Interpolation_Method.this);
                builder.setMessage(nFori.getRes())
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
