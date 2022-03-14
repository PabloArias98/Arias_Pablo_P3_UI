package com.example.arias_pablo_p3_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ejercicio2B extends AppCompatActivity {

    ArrayList<String> frutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2b);
        final Spinner spinnerx = findViewById(R.id.spinner2);
        Bundle bundle = getIntent().getExtras();
        frutas = new ArrayList<String>();
        frutas = bundle.getStringArrayList("frutas");

        ArrayAdapter adaptador1 = new ArrayAdapter<> (Ejercicio2B.this, android.R.layout.simple_spinner_item, frutas);
        spinnerx.setAdapter(adaptador1);

        adaptador1.setDropDownViewResource(R.layout.spinner_item_maravilloso);


        spinnerx.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Ejercicio2B.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }



}
