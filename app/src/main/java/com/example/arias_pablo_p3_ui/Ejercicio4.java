package com.example.arias_pablo_p3_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Ejercicio4 extends AppCompatActivity {

    EditText campo;
    String[] listaAcciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4);
        campo = findViewById(R.id.campoDato);
        final Spinner spinner = findViewById(R.id.spinner3);
        //listaAcciones = new String[]{"Llamar", "SMS", "Web", "Localización", "Alarma", "Email", "Cámara"};

        //ArrayAdapter arrayAdaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaAcciones);
        //spinner.setAdapter(arrayAdaptador);


       // arrayAdaptador.setDropDownViewResource(R.layout.spinner_item_maravilloso);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();

                switch (parent.getSelectedItem().toString()) {
                    case "Selecciona una opción":
                        break;
                    case "Llamar":
                        campo.setInputType(InputType.TYPE_CLASS_NUMBER);
                        marcarTelefono(view, intent);
                        break;
                    case "SMS":
                        campo.setInputType(InputType.TYPE_CLASS_TEXT);
                        enviarSMS(view, intent);
                        break;
                    case "Web":
                        campo.setInputType(InputType.TYPE_CLASS_TEXT);
                        irAWeb(view, intent);
                        break;
                    case "Localización":
                        campo.setInputType(InputType.TYPE_CLASS_TEXT);
                        openLocation(view, intent);
                        break;
                    case "Alarma":
                        campo.setInputType(InputType.TYPE_CLASS_DATETIME);
                        crearAlarma(view, intent);
                        break;
                    case "Email":
                        campo.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                        email(view, intent);
                        break;
                    case "Cámara":
                        foto(view);
                        break;
                    default:
                        break;
                }
                Toast.makeText(Ejercicio4.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

    public void marcarTelefono(View v, Intent intent) {
        // Intent implícito: se indica la acción a realizar y no la actividad que la realizará
        String numero = campo.getText().toString();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+numero));

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
        }
    }


    public void enviarSMS(View v, Intent intent) {
        String sms = campo.getText().toString();
        intent.setAction(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("sms:"));
        intent.putExtra("direccion", "666432333");
        intent.putExtra("sms_body", sms);

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Error, introduzca un dato correcto!!!", Toast.LENGTH_SHORT).show();
        }
    }


    public void irAWeb(View v, Intent intent) {
        String datosBusca = campo.getText().toString();
        intent.setAction(Intent.ACTION_VIEW);
        // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/avidaldo"));
        if (URLUtil.isValidUrl(datosBusca)) {

            intent.setData(Uri.parse(datosBusca));

        } else if (datosBusca.contains(".")) {

            intent.setData(Uri.parse("https://" + datosBusca));

        } else {
            intent.setData(Uri.parse("https://www.google.com/search?q=" + datosBusca));
        }

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Error, introduzca un dato correcto!!!", Toast.LENGTH_SHORT).show();
        }
    }


    public void openLocation(View view, Intent intent) {
        // Parse the location and create the intent.
        //Uri addressUri = Uri.parse("geo:42.2515086,-8.6920307"); // Localización por coordenadas concretas
        Uri addressUri = Uri.parse(campo.getText().toString());  // Búsqueda de "Vigo"
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:?q=" + addressUri));

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Error, introduzca un dato correcto!!!", Toast.LENGTH_SHORT).show();
        }
    }


    public void crearAlarma(View view, Intent intent) {

        try {

            String alarm = campo.getText().toString();
            LocalTime hora = LocalTime.parse(alarm);
            intent.setAction(AlarmClock.ACTION_SET_ALARM);
            intent.putExtra(AlarmClock.EXTRA_HOUR, hora.getHour());
            intent.putExtra(AlarmClock.EXTRA_MINUTES, hora.getMinute());
            intent.putExtra(AlarmClock.EXTRA_ALARM_SNOOZE_DURATION, 15);

        } catch (DateTimeException e) {

            Toast.makeText(this, "Use un formato de hora válido. HH:MM",
                    Toast.LENGTH_SHORT).show();
            return;
        }



        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Error, introduzca un dato correcto!!!", Toast.LENGTH_SHORT).show();
        }
    }


    /*public void email(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{getResources().getString(R.string.email1)});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto");
        intent.putExtra(Intent.EXTRA_TEXT, "Contenido del correo");

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, R.string.no_app_error, Toast.LENGTH_SHORT).show();
        }
    }*/


    public void email(View v, Intent intent) {
        String mail = campo.getText().toString();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(mail));
        // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/avidaldo"));

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Error, introduzca un dato correcto!!!", Toast.LENGTH_SHORT).show();
        }
    }


    /* Abrir la cámara. Se necesita añadir este permiso al manifest:
    <uses-feature android:name="android.hardware.camera" android:required="true" /> */
    public void foto(View view) {
        try {
            startActivity(new Intent("android.media.action.IMAGE_CAPTURE"));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Error, introduzca un dato correcto!!!", Toast.LENGTH_SHORT).show();
        }
    }
}