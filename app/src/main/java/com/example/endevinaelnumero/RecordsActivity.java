package com.example.endevinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RecordsActivity extends AppCompatActivity {

    public static ArrayList<Record> records = new ArrayList<Record>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        final TextView ranking = findViewById(R.id.ranking);

        final Button button = findViewById(R.id.tornar);

        ScrollingMovementMethod scroll = new ScrollingMovementMethod();
        ranking.setMovementMethod(scroll);


        for (Record record : records) {
            ranking.append(record.nom + " - " + record.punts + "\n");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecordsActivity.this, MainActivity.class);
                MainActivity.records = RecordsActivity.records;
                startActivity(intent);
            }
        });

    }
}