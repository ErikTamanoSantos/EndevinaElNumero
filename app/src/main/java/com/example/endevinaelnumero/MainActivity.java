package com.example.endevinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    int num = 1;

    public static ArrayList<Record> records = new ArrayList<Record>();

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button submit = findViewById(R.id.button);
        final Button hof = findViewById(R.id.HOFButton);
        final EditText entrada = findViewById(R.id.editTextNumber);

        final TextView hist = findViewById(R.id.Respuesta);
        final TextView textContador = findViewById(R.id.Contador);

        hist.setMovementMethod(new ScrollingMovementMethod());


        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                textContador.setText(String.valueOf(Integer.parseInt(textContador.getText().toString()) + 1));

                int resp = Integer.parseInt(entrada.getText().toString());

                if (resp < num) {
                    hist.append("\nEl numero " + resp + " és menor");
                } else if (resp > num) {
                    hist.append("\nEl numero " + resp + " és major");;
                } else {
                    final EditText jugador = new EditText(MainActivity.this);
                    AlertDialog.Builder popup = new AlertDialog.Builder(MainActivity.this);
                    popup.setTitle("Felicitats, has endevinat el número!\nInserta el teu nom.");
                    popup.setView(jugador);
                    popup.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            records.add(new Record(jugador.getText().toString(), Integer.parseInt(textContador.getText().toString())));
                            textContador.setText("0");
                            entrada.setText("");
                            hist.setText("Historial:");
                            num = 1;
                        }
                    });
                    popup.create();
                    popup.show();
                }
            }
        });

        hof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecordsActivity.class);
                RecordsActivity.records = MainActivity.records;
                startActivity(intent);
            }
        });

    }
}

class WinnersActivity extends AppCompatActivity {

}