package com.finsol.tarea1pm1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaracion de variables
    EditText txtNumero1, txtNumero2;
    Button btnSuma, btnResta, btnMultiplicacion, btnDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumero1 = findViewById(R.id.txtNumero1);
        txtNumero2 = findViewById(R.id.txtNumero2);
        btnSuma = findViewById(R.id.btnSuma);
        btnDivision = findViewById(R.id.btnDivision);
        btnResta = findViewById(R.id.btnResta);
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarDatos()){
                    int res = Integer.parseInt(txtNumero1.getText().toString())+Integer.parseInt(txtNumero2.getText().toString());
                    enviarResultado("suma",res);
                }
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarDatos()){
                    int res = Integer.parseInt(txtNumero1.getText().toString())-Integer.parseInt(txtNumero2.getText().toString());
                    enviarResultado("resta",res);
                }
            }
        });

        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarDatos()){
                    int res = Integer.parseInt(txtNumero1.getText().toString())*Integer.parseInt(txtNumero2.getText().toString());
                    enviarResultado("multiplicacion",res);
                }
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarDatos()){
                    if (Integer.parseInt(txtNumero2.getText().toString())==0){
                        Toast.makeText(MainActivity.this,"Numero 2 no puede ser 0",Toast.LENGTH_SHORT).show();
                    }else{
                        double res = Double.parseDouble(txtNumero1.getText().toString())/Double.parseDouble(txtNumero2.getText().toString());
                        enviarResultado("division",res);
                    }

                }
            }
        });


    }

    private void enviarResultado(String msj, double res) {
        Intent intent = new Intent(MainActivity.this,ActivityResultado.class);
        intent.putExtra("Res","El resultado de la "+msj+" es: "+res);
        startActivity(intent);
    }

    private boolean validarDatos() {
        boolean res = true;
        if (txtNumero1.getText().length()==0 || (txtNumero2.getText().length()==0)){
            Toast.makeText(this,"Ingrese ambos valores",Toast.LENGTH_SHORT).show();
            res = false;
        }
        return res;
    }
}