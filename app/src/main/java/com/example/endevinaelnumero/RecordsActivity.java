package com.example.endevinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class RecordsActivity extends AppCompatActivity {
    public static ArrayList<Record> records = new ArrayList<Record>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        final Button button = findViewById(R.id.tornar);

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