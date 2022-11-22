package com.example.basededatos;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.constraintlayout.utils.widget.ImageFilterView;

import com.google.android.material.button.MaterialButton;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private DBManager manager;
    Cursor cursor;
    private ImageFilterView image;
    private String parametro;
    private AppCompatEditText txtNombre;
    private AppCompatEditText txtTelefono;
    private AppCompatSpinner spnCategorias;
    SimpleCursorAdapter acategorias;
    Cursor ccategorias;
    private Integer posicion;
    private MaterialButton btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(R.layout.activity2_main);
        manager = new DBManager(this);

        txtTelefono = (AppCompatEditText) findViewById(R.id.txtTelefono);
        txtNombre = (AppCompatEditText) findViewById(R.id.txtNombre);
        spnCategorias = (AppCompatSpinner) findViewById(R.id.spinner);
        btnGuardar = (MaterialButton) findViewById(R.id.boton_guardar);
        btnGuardar.setOnClickListener(this);

        final String[] from = new String[]{manager.CN_NOMBRE};
        int[] to = new int[]{android.R.id.text1};

        ccategorias = manager.cargarTodosLosDatos();
        acategorias = new SimpleCursorAdapter(this, android.R.layout.simple_spinner_dropdown_item,ccategorias,from,to,0);
        spnCategorias.setAdapter(acategorias);

        image = (ImageFilterView) findViewById(R.id.imagen);
        image.setImageResource(R.drawable.ic_launcher_foreground);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.boton_guardar) {
            posicion = spnCategorias.getSelectedItemPosition();

            ccategorias.moveToPosition(posicion);

            manager.insertar(txtNombre.getText().toString(), txtTelefono.getText().toString());
            txtNombre.setText("");
            txtTelefono.setText("");

            Intent refresh = new Intent(this, MainActivity.class);
            startActivity(refresh);
            finish();
        }
    }

}
