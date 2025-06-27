package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText numero1, numero2;
    Button btnSuma, btnResta, btnDivision, btnMultiplicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);

        btnSuma.setOnClickListener(v -> operar("suma"));
        btnResta.setOnClickListener(v -> operar("resta"));
        btnDivision.setOnClickListener(v -> operar("division"));
        btnMultiplicacion.setOnClickListener(v -> operar("multiplicacion"));
    }

    private void operar(String operacion) {
        String num1Str = numero1.getText().toString();
        String num2Str = numero2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double resultado = 0;

        switch (operacion) {
            case "suma":
                resultado = Operaciones.suma(num1, num2);
                break;
            case "resta":
                resultado = Operaciones.resta(num1, num2);
                break;
            case "division":
                resultado = Operaciones.division(num1, num2);
                break;
            case "multiplicacion":
                resultado = Operaciones.multiplicacion(num1, num2);
                break;
        }

        // Enviar resultado a la nueva actividad
        Intent intent = new Intent(this, ResultadoActivity.class);
        intent.putExtra("resultado", resultado);
        startActivity(intent);
    }
}
