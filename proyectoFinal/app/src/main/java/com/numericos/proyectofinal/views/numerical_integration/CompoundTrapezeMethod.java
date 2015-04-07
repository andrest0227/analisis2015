package com.numericos.proyectofinal.views.numerical_integration;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.logic.CompoundTrapeze;
import com.numericos.proyectofinal.views.util.CustomKeyboard;

/**
 * Created by Sara Castrillón on 22/11/2014.
 */
public class CompoundTrapezeMethod extends Activity{
    private CompoundTrapeze compoundTrapeze;
    private Button execute_button;
    private EditText x0_editText,x1_editText, tolerance_editText, intervals_editText, function_editText, result_editText;
    private String resultado;
    private CustomKeyboard mCustomKeyboard;

    public CompoundTrapezeMethod(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compound_trapeze_method);

        mCustomKeyboard= new CustomKeyboard(this, R.id.keyboardview, R.xml.hexkbd );
        mCustomKeyboard.registerEditText(R.id.function_editText);
        mCustomKeyboard.registerEditText(R.id.x0_editText);
        mCustomKeyboard.registerEditText(R.id.x1_editText);
        //mCustomKeyboard.registerEditText(R.id.tolerance_editText);
        //mCustomKeyboard.registerEditText(R.id.iteraciones_editText);

        compoundTrapeze= new CompoundTrapeze();

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

                compoundTrapeze.setX0(x0);
                compoundTrapeze.setX0(x1);
                compoundTrapeze.setIntervals(intervals);
                compoundTrapeze.setFx(funct);

                resultado = compoundTrapeze.compoundTrapezeMethod(x0,x1,intervals);


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
