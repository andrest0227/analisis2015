package com.numericos.proyectofinal.views.numerical_integration;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.logic.CompoundSimpson1_3;
import com.numericos.proyectofinal.logic.CompoundTrapeze;
import com.numericos.proyectofinal.views.util.CustomKeyboard;

/**
 * Created by Sara Castrillón on 22/11/2014.
 */
public class CompoundSimpson1_3Method extends Activity {
private CompoundSimpson1_3 compoundSimpson1_3;
private Button execute_button;
private EditText x0_editText,x1_editText, tolerance_editText, intervals_editText, function_editText, result_editText;
private String resultado;
private CustomKeyboard mCustomKeyboard;

    public CompoundSimpson1_3Method(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compound_simpson_1_3_method);

        mCustomKeyboard= new CustomKeyboard(this, R.id.keyboardview, R.xml.hexkbd );
        mCustomKeyboard.registerEditText(R.id.function_editText);
        mCustomKeyboard.registerEditText(R.id.x0_editText);
        mCustomKeyboard.registerEditText(R.id.x1_editText);
        //mCustomKeyboard.registerEditText(R.id.tolerance_editText);
        //mCustomKeyboard.registerEditText(R.id.iteraciones_editText);

        compoundSimpson1_3 = new CompoundSimpson1_3();

        execute_button = (Button) findViewById(R.id.execute_button);
        execute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                x0_editText = (EditText) findViewById(R.id.x0_editText);
                x1_editText = (EditText) findViewById(R.id.x1_editText);
                //tolerance_editText = (EditText) findViewById(R.id.tolerance_editText);
                intervals_editText = (EditText) findViewById(R.id.tolerance_editText);
                function_editText = (EditText) findViewById(R.id.function_editText);
                result_editText = (EditText)findViewById(R.id.result_editText);

                double x0 = Double.parseDouble(x0_editText.getText().toString());
                double x1 = Double.parseDouble(x1_editText.getText().toString());
                //double tolerance = Double.parseDouble(tolerance_editText.getText().toString());
                double intervals = Double.parseDouble(intervals_editText.getText().toString());
                String funct = function_editText.getText().toString();

                compoundSimpson1_3.setX0(x0);
                compoundSimpson1_3.setX1(x1);
                compoundSimpson1_3.setIntervals(intervals);
                compoundSimpson1_3.setFx(funct);

                resultado = compoundSimpson1_3.compoundSimpson1_3Method(x0,x1,intervals);


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
