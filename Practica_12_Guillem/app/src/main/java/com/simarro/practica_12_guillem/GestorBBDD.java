package com.simarro.practica_12_guillem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.simarro.practica_12_guillem.classes.Robot;
import com.simarro.practica_12_guillem.classes.Tipo;

import java.util.ArrayList;

public class GestorBBDD extends SQLiteOpenHelper {

    private final static String DB_NAME = "robotics.sqlite";
    private final static int DB_VERSION = 1;

    private Context context;

    public GestorBBDD(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Robot (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, descripcion TEXT, material VARCHAR(50), anyo INT(4), precio FLOAT, tipo INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // de momento aqui no me hace falta nada, asi que...
    }

    public ArrayList<Robot> getAllRobots() {
        ArrayList<Robot> robots = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(
                "SELECT id, nombre, descripcion, material, anyo, precio, tipo FROM Robot", null);

        if (c.moveToFirst()) {
            do {
                Robot r = new Robot();
                r.id = c.getInt(0);
                r.nombre = c.getString(1);
                r.descripcion = c.getString(2);
                r.material = c.getString(3);
                r.anyo = c.getInt(4);
                r.precio = c.getDouble(5);
                r.tipo = Tipo.values()[c.getInt(6)];
                robots.add(r);
            } while (c.moveToNext());
        }

        db.close();
        return robots;
    }

    public long insertarRobot(Robot r) {
        ContentValues nuevaFila = new ContentValues();
        nuevaFila.put("nombre", r.nombre);
        nuevaFila.put("descripcion", r.descripcion);
        nuevaFila.put("material", r.material);
        nuevaFila.put("anyo", r.anyo);
        nuevaFila.put("precio", r.precio);
        nuevaFila.put("tipo", r.tipo.ordinal());

        SQLiteDatabase db = getWritableDatabase();
        long res = db.insert("Robot", null, nuevaFila);
        db.close();

        r.id = res;
        return res;
    }

    public boolean modificarRobot(Robot r) {
        ContentValues camposACambiar = new ContentValues();
        camposACambiar.put("nombre", r.nombre);
        camposACambiar.put("descripcion", r.descripcion);
        camposACambiar.put("material", r.material);
        camposACambiar.put("anyo", r.anyo);
        camposACambiar.put("precio", r.precio);
        camposACambiar.put("tipo", r.tipo.ordinal());

        SQLiteDatabase db = getWritableDatabase();
        int rows = db.update("Robot", camposACambiar, "id = ?", new String[]{String.valueOf(r.id)});
        db.close();
        return rows > 0;
    }

    public void eliminarRobot(Robot r) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Robot", "id = ?", new String[]{String.valueOf(r.id)});
        db.close();
    }
}
