package com.example.arias_pablo_p3_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ejercicio1 extends AppCompatActivity {


    Button btnanadido, btnacabado;
    EditText campodeFruta;
    ArrayList<String> listaFrutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        listaFrutas = new ArrayList<>();
        final Spinner spinner = findViewById(R.id.spinner);
        btnanadido = findViewById(R.id.butadd);
        btnacabado = findViewById(R.id.butacabar);
        campodeFruta = findViewById(R.id.campoFrutas);

        spinner.setVisibility(View.INVISIBLE);

        btnanadido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Añadimos a la lista de frutas
                listaFrutas.add(campodeFruta.getText().toString());
                //Vaciamos el campo
                campodeFruta.setText("");
            }
        });

        btnacabado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnanadido.setEnabled(false);
                btnacabado.setEnabled(false);
                spinner.setVisibility(View.VISIBLE);
            }
        });


        ArrayAdapter arrayAdaptador = new ArrayAdapter<> (this, android.R.layout.simple_spinner_item, listaFrutas);
        spinner.setAdapter(arrayAdaptador);

        arrayAdaptador.setDropDownViewResource(R.layout.spinner_item_maravilloso);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Ejercicio1.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public void regresarMenuPrincipal(View view) {
        Intent intento = new Intent(Ejercicio1.this, MainActivity.class);
        startActivity(intento);
    }
}