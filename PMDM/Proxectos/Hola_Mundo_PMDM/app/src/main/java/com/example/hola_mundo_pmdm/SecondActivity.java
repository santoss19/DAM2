package com.example.hola_mundo_pmdm;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // IMPORTANTE POÑER ANTES DE TRABALLAR COS ELEMENTOS DO LAYOUT
        setContentView(R.layout.fragment_second);
        //
        TextView texto = findViewById(R.id.textview_second);
        //texto.setText((String) getIntent().getExtras().get("NOMBRE"));
        texto.setText(getIntent().getStringExtra("NOMBRE"));
    }
}
