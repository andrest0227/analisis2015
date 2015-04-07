package com.numericos.proyectofinal.views.single_variable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.numericos.proyectofinal.R;
import com.numericos.proyectofinal.logic.FixedPoint;
import com.numericos.proyectofinal.logic.Newton;
import com.numericos.proyectofinal.views.util.CustomKeyboard;
import android.app.Activity;



/**
 * Created by Sara Castrillón on 20/11/2014.
 */
public class NewtonMethod extends Activity{
    private Newton newton;
    private Button execute_button;
    private EditText x0_editText,x1_editText, tolerance_editText, iterations_editText, function_editText,function2_editText, result_editText;
    private String resultado;
    private CustomKeyboard mCustomKeyboard;

    public NewtonMethod(){    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newton_method);

        mCustomKeyboard= new CustomKeyboard(this, R.id.keyboardview, R.xml.hexkbd );
        mCustomKeyboard.registerEditText(R.id.function_editText);
        mCustomKeyboard.registerEditText(R.id.x0_editText);
        mCustomKeyboard.registerEditText(R.id.function2_editText);

        newton = new Newton();

        execute_button = (Button) findViewById(R.id.execute_button);
        execute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                x0_editText = (EditText) findViewById(R.id.x0_editText);
                //x1_editText = (EditText) findViewById(R.id.x1_editText);
                tolerance_editText = (EditText) findViewById(R.id.tolerance_editText);
                iterations_editText = (EditText) findViewById(R.id.iterations_editText);
                function_editText = (EditText) findViewById(R.id.function_editText);
                function2_editText = (EditText) findViewById(R.id.function2_editText);
                result_editText = (EditText)findViewById(R.id.result_editText);

                double x0 = Double.parseDouble(x0_editText.getText().toString());
                //double x1 = Double.parseDouble(x1_editText.getText().toString());
                double tolerance = Double.parseDouble(tolerance_editText.getText().toString());
                double iterations = Double.parseDouble(iterations_editText.getText().toString());
                String funct = function_editText.getText().toString();
                String funct2 = function2_editText.getText().toString();

                newton.setX0(x0);
                //fixedPoint.setX0(x1);
                newton.setTolerance(tolerance);
                newton.setIterations(iterations);
                newton.setFx(funct);
                newton.setDFx(funct2);



                resultado = newton.newtonMethod(x0,tolerance,iterations);


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
