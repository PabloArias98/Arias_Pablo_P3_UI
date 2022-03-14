package com.example.arias_pablo_p3_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toEjercicio1(View view) {
        Intent intento = new Intent(MainActivity.this, Ejercicio1.class);
        startActivity(intento);
    }

    public void toEjercicio2A(View view) {
        Intent intento = new Intent(MainActivity.this, Ejercicio2A.class);
        startActivity(intento);
    }

    public void toEjercicio3(View view) {
        Intent intento = new Intent(MainActivity.this, Ejercicio3.class);
        startActivity(intento);
    }

    public void toEjercicio4(View view) {
        Intent intento = new Intent(MainActivity.this, Ejercicio4.class);
        startActivity(intento);
    }
}