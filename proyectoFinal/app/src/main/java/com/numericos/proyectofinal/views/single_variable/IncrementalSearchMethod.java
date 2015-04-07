package com.numericos.proyectofinal.views.single_variable;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.logic.IncrementalSearch;
import com.numericos.proyectofinal.views.util.CustomKeyboard;

/**
 * Created by JU on 10/21/2014.
 */

public class IncrementalSearchMethod extends Activity {

    private IncrementalSearch incrementalSearch;
    private Button execute_button;
    private EditText x0_editText, delta_editText, iteraciones_editText, function_editText, result_editText;
    private String resultado;
    private CustomKeyboard mCustomKeyboard;

    public IncrementalSearchMethod(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.incremental_search_method);

        mCustomKeyboard= new CustomKeyboard(this, R.id.keyboardview, R.xml.hexkbd );
        mCustomKeyboard.registerEditText(R.id.function_editText);
        //mCustomKeyboard.registerEditText(R.id.x1_editText);
        mCustomKeyboard.registerEditText(R.id.x0_editText);


        incrementalSearch = new IncrementalSearch();

        execute_button = (Button) findViewById(R.id.execute_button);
        execute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                x0_editText = (EditText) findViewById(R.id.x0_editText);
                delta_editText = (EditText) findViewById(R.id.delta_editText);
                iteraciones_editText = (EditText) findViewById(R.id.iteraciones_editText);
                function_editText = (EditText) findViewById(R.id.function_editText);
                result_editText = (EditText)findViewById(R.id.result_editText);

                double x0 = Double.parseDouble(x0_editText.getText().toString());
                double delta = Double.parseDouble(delta_editText.getText().toString());
                double iteraciones = Double.parseDouble(iteraciones_editText.getText().toString());
                String funct = function_editText.getText().toString();

                incrementalSearch.setX0(x0);
                incrementalSearch.setDelta(delta);
                incrementalSearch.setIteraciones(iteraciones);
                incrementalSearch.setFx(funct);

                resultado = incrementalSearch.execute();


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
