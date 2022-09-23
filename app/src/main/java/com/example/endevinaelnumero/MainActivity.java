package com.example.endevinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int num = (int) (Math.random()*100);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        final EditText entrada = findViewById(R.id.editTextNumber);



        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final TextView textContador = findViewById(R.id.Contador);
                final TextView resp = findViewById(R.id.Respuesta);

                textContador.setText(String.valueOf(Integer.parseInt(textContador.getText().toString()) + 1));


                if (Integer.parseInt(entrada.getText().toString()) < num) {
                    resp.append("\nEl numero insertat és menor");
                } else if (Integer.parseInt(entrada.getText().toString()) > num) {
                    resp.append("\nEl numero insertat és major");;
                } else {
                    resp.append("\nFelicitats, has endevinat el numero");
                }
                entrada.setText("");
            }
        });

    }
}