package com.example.basededatos;

import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DBManager manager;
    Cursor cursor;
    SimpleCursorAdapter sca;
    private SharedPreferences registro;
    private SharedPreferences.Editor admin;
    private ListView lista;
    private AppCompatEditText tv;
    private MaterialButton btn_add;
    private MaterialButton btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.main_list);
        tv = (AppCompatEditText) findViewById(R.id.text_to_search_bd);
        manager = new DBManager(this);
        cursor = manager.cargarTodosLosDatos();
        btn_add = (MaterialButton) findViewById(R.id.add_bttn);
        btn_add.setOnClickListener(this);
        btn_search = (MaterialButton) findViewById(R.id.buscar_bttn);
        btn_search.setOnClickListener(this);
        final String[] from = new String[]{manager.CN_NOMBRE, manager.CN_NT};
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};
        sca = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item, cursor, from, to, 0);
        lista.setAdapter(sca);
        lista.setOnItemClickListener((adapterView, view, i, l) -> {
            cursor.moveToPosition(i);
            Intent editar = new Intent(MainActivity.this, EditarActivity.class);
            editar.putExtra("idContacto", cursor.getString(0));
            startActivity(editar);
            finish();
        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buscar_bttn) {
            final Cursor c = manager.cargarDatosNombre(tv.getText().toString());
            sca.changeCursor(c);
            lista.setOnItemClickListener((prnt,v,p,id) -> {
                c.moveToPosition(p);
                Intent editar = new Intent(MainActivity.this, EditarActivity.class);
                editar.putExtra("idContacto", c.getString(0));
                startActivity(editar);
                finish();
            });
        }

        if(view.getId()==R.id.add_bttn) {
            Intent otro = new Intent(this, Main2Activity.class);
            startActivity(otro);
            finish();
        }
    }

}
