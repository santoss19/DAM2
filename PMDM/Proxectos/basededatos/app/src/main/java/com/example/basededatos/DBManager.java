package com.example.basededatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    public static String TABLE_NAME = "comments";
    public static String CN_ID = "_id";
    public static String CN_NOMBRE = "nombre";
    public static String CN_NT = "phone_number";

    DBHelper dbh = null;
    SQLiteDatabase db = null;

    public DBManager(Context context) {
        dbh = new DBHelper(context);
        db = dbh.getWritableDatabase();
    }

    public ContentValues generarNuevoContenedor(String nombre, String phone_number) {
        ContentValues cv = new ContentValues();
        cv.put(CN_NOMBRE, nombre);
        cv.put(CN_NT, phone_number);
        return cv;
    }

    public void insertar(String nombre, String phone_number) {
        db.insert(TABLE_NAME, null, this.generarNuevoContenedor(nombre, phone_number));
    }

    public void borrar(int id) {
        db.delete(TABLE_NAME, CN_ID + "=?", new String[]{"" + id});
    }

    public void modificarRegistro(int id, String nombre, String phone_number) {
        db.update(TABLE_NAME, generarNuevoContenedor(nombre, phone_number), CN_ID + "=?", new String[]{id + ""});
    }

    public Cursor cargarTodosLosDatos() {
        String[] returnedRows = {CN_ID, CN_NOMBRE, CN_NT};
        return db.query(TABLE_NAME, returnedRows, null, null, null, null, null);
    }

    public Cursor cargarDatosNombre(String nombre) {
        String[] returnedRows = {CN_ID, CN_NOMBRE, CN_NT};
        return db.query(TABLE_NAME, returnedRows, CN_NOMBRE + "=?", new String[]{nombre}, null, null, null);
    }

    public Cursor cargarDatosPorID(int id) {
        String[] returnedRows = {CN_ID, CN_NOMBRE, CN_NT};
        return db.query(TABLE_NAME, returnedRows, CN_ID + "=?", new String[]{id + ""}, null, null, null);
    }

    public void insertarNuevaCat(String nombre) {
        ContentValues cv = new ContentValues();
        cv.put(TABLE_NAME, nombre);
        db.insert(TABLE_NAME, null, cv);
    }

}
