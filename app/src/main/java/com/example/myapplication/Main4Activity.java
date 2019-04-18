package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    private EditText ed1, ed2;
    private RadioGroup rg1;
    private TextView tv1;
    private double n1, n2, result = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ed1 = findViewById(R.id.editTextN1Rg);
        ed2 = findViewById(R.id.editTextN2Rg);
        rg1 = findViewById(R.id.radioGroup);
        tv1 = findViewById(R.id.textViewRg);

        rg1.setOnCheckedChangeListener(meuOuvinte);
    }

    RadioGroup.OnCheckedChangeListener meuOuvinte = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (verificado()) {
                n1 = Double.parseDouble(ed1.getText().toString());
                n2 = Double.parseDouble(ed2.getText().toString());

                switch (checkedId) {
                    case R.id.radioButtonSomar:
                        result = n1 + n2;
                        break;
                    case R.id.radioButtonSubtrair:
                        result = n1 - n2;
                        break;
                    case R.id.radioButtonMult:
                        result = n1 * n2;
                        break;
                    case R.id.radioButtonDiv:
                        result = n1 / n2;
                        break;
                }
                tv1.setText("O resultado é: " + String.format("%.2f", result));
            }
        }
    };

    private boolean verificado() {
        boolean retorno = true;
        if (ed1.getText().toString().length() == 0) {
            ed1.setError("Digite um número.");
            retorno = false;
        }
        if (ed2.getText().toString().length() == 0) {
            ed2.setError("Digite um número.");
            retorno = false;
        }
        return retorno;


    }
}
