package com.example.basededatos;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.constraintlayout.utils.widget.ImageFilterView;

import com.google.android.material.button.MaterialButton;

public class EditarActivity extends AppCompatActivity implements View.OnClickListener {

    private DBManager manager;
    Cursor cursor;
    private String parametro;
    private AppCompatEditText txtNombre;
    private AppCompatEditText txtNumero;
    private Spinner spncategorias;
    SimpleCursorAdapter acategorias;
    Cursor categorias;
    private Integer posicion;
    private MaterialButton btnActualizar;
    private MaterialButton btnEliminar;

    @Override
    public void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_editar);
        manager = new DBManager(this);

        Intent param = getIntent();
        parametro = param.getStringExtra("idContacto");

        cursor = manager.cargarDatosPorID(Integer.parseInt(parametro));
        cursor.moveToPosition(0);

    }

    @Override
    public void onClick(View view) {

    }
}
