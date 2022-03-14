package com.example.arias_pablo_p3_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Ejercicio2A extends AppCompatActivity {

    Button btnanadido2, btnacabado2;
    EditText campodeFruta2;
    ArrayList<String> arrayFrutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2a);
        arrayFrutas = new ArrayList<>();
        btnanadido2 = findViewById(R.id.btnanadir2);
        btnacabado2 = findViewById(R.id.btnacabar2);
        campodeFruta2 = findViewById(R.id.frutascampo);

        btnanadido2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayFrutas.add(campodeFruta2.getText().toString());
                //Vaciamos el campo
                campodeFruta2.setText("");
            }
        });

        btnacabado2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnanadido2.setVisibility(View.INVISIBLE);
                btnacabado2.setVisibility(View.INVISIBLE);
            }
        });


    }

    public void toSpinner(View view) {

        Intent intento = new Intent(Ejercicio2A.this, Ejercicio2B.class);
        intento.putExtra("frutas", arrayFrutas);
        startActivity(intento);
    }
}