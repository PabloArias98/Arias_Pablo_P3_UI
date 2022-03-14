package com.example.arias_pablo_p3_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);
        final Spinner spinnerProvincia = findViewById(R.id.spinProv);
        final Spinner spinnerLocalidad = findViewById(R.id.spinLoc);

        String[] provincias = new String[] {"A Coruña", "Lugo", "Ourense", "Pontevedra"};

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, R.layout.item_guay, provincias);

        spinnerProvincia.setAdapter(arrayAdapter);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerProvincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter arrayAdapterX;
                switch (parent.getSelectedItem().toString()) {
                    case "A Coruña":
                        String[] ciudadesCoruna = new String[] {"A Coruña", "Carballo", "Ferrol", "Santiago de Compostela"};
                        arrayAdapterX = new ArrayAdapter<> (Ejercicio3.this, R.layout.item_guay, ciudadesCoruna);
                        spinnerLocalidad.setAdapter(arrayAdapterX);
                        break;
                    case "Lugo" :
                        String[] ciudadesLugo = new String[] {"Lugo", "Monforte de Lemos", "Ribadeo", "Viveiro"};
                        arrayAdapterX = new ArrayAdapter<> (Ejercicio3.this, R.layout.item_guay, getResources().getStringArray(R.array.ciudades_lugo));
                        spinnerLocalidad.setAdapter(arrayAdapterX);
                        break;
                    case "Ourense" :
                        String[] ciudadesOurense = new String[] {"O Barco de Valdeorras", "Ourense", "Ribadavia", "Villamartin de Valdeorras"};
                        arrayAdapterX = new ArrayAdapter<> (Ejercicio3.this, R.layout.item_guay, ciudadesOurense);
                        spinnerLocalidad.setAdapter(arrayAdapterX);
                        break;
                    case "Pontevedra" :
                        String[] ciudadesPontevedra = new String[] {"Pontevedra", "Mos Distrito Capital", "Redondela", "Vigo"};
                        arrayAdapterX = new ArrayAdapter<> (Ejercicio3.this, R.layout.item_guay, ciudadesPontevedra);
                        spinnerLocalidad.setAdapter(arrayAdapterX);
                        break;
                    default:
                        arrayAdapterX = null;
                        break;
                }

                arrayAdapterX.setDropDownViewResource(R.layout.spinner_item_maravilloso);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerLocalidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Ejercicio3.this, "Localidad: "+parent.getSelectedItem().toString()+" \n Provincia: "+spinnerProvincia.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}