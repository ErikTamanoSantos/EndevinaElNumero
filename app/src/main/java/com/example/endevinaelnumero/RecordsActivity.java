package com.example.endevinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class RecordsActivity extends AppCompatActivity {

    public static ArrayList<Record> records = new ArrayList<Record>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        final Button button = findViewById(R.id.tornar);


        TableRow.LayoutParams params1 = new TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT, 1.0f);
        TableRow.LayoutParams params2 = new TableRow.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
        TableLayout table = (TableLayout) findViewById(R.id.table);
        for (Record record : records) {

            TableRow row = new TableRow(this);
            TextView textNom = new TextView(this);
            TextView textPunts = new TextView(this);

            textNom.setText(record.nom);
            textPunts.setText(String.valueOf(record.punts));

            textNom.setLayoutParams(params1);
            textPunts.setLayoutParams(params1);

            row.addView(textNom);
            row.addView(textPunts);
            row.setLayoutParams(params2);
            table.addView(row);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(RecordsActivity.this, MainActivity.class);
                startActivity(intent2);

            }
        });
    }
}