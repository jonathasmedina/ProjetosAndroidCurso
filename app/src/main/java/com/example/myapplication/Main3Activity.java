package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    private Button btSomar, btSubtrair, btMult, btDivid;
    private EditText edN1, edN2;
    private TextView tvResult;
    private double num1, num2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btSomar = findViewById(R.id.buttonSomar);
        btDivid = findViewById(R.id.buttonDividir);
        btSubtrair = findViewById(R.id.buttonSubtrair);
        btMult = findViewById(R.id.buttonMultiplicar);
        edN1 = findViewById(R.id.editTextN1);
        edN2 = findViewById(R.id.editTextN2);
        tvResult = findViewById(R.id.textViewResult);

        btSomar.setOnClickListener(this);
        btMult.setOnClickListener(this);
        btSubtrair.setOnClickListener(this);
        btDivid.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (verificado()) {
            num1 = Double.parseDouble(edN1.getText().toString());
            num2 = Double.parseDouble(edN2.getText().toString());
            switch (v.getId()) {
                case R.id.buttonSomar:
                    result = num1 + num2;
                    break;
                case R.id.buttonSubtrair:
                    result = num1 - num2;
                    break;
                case R.id.buttonMultiplicar:
                    result = num1 * num2;
                    break;
                case R.id.buttonDividir:
                    result = num1 / num2;
                    break;
            }
            tvResult.setText("O resultado é: " + String.format("%.2f", result));
        }
    }

    private boolean verificado() {
        boolean retorno = true;
        if (TextUtils.isEmpty(edN1.getText().toString())) {
            edN1.setError("Digite um número.");
            retorno = false;
        }
        if (edN2.getText().toString().length() == 0) {
            edN2.setError("Digite um número.");
            retorno = false;
        }
        return retorno;
    }
}
