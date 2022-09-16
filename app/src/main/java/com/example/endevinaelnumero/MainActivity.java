package com.example.endevinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int num = (int) (Math.random()*100);

        final Button button = findViewById(R.id.button);
        final EditText text = findViewById(R.id.editTextNumber);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Integer.parseInt(text.getText().toString()) < num) {
                    Toast.makeText(MainActivity.this, "El numero insertat es menor", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(text.getText().toString()) > num) {
                    Toast.makeText(MainActivity.this, "El numero insertat es major", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Felicitats, has endevinat el numero", Toast.LENGTH_SHORT).show();
                }
                text.setText("");
            }
        });

    }
}