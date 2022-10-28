package com.finsol.tarea1pm1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityResultado extends AppCompatActivity {

    //Declaracion de variables
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        txtResultado = findViewById(R.id.txtResultado);

        Bundle Resultado = getIntent().getExtras();
        txtResultado.setText(Resultado.getString("Res"));
    }
}