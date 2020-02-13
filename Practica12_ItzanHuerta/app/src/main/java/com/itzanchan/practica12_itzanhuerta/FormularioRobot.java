package com.itzanchan.practica12_itzanhuerta;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.itzanchan.practica12_itzanhuerta.classes.Robot;
import com.itzanchan.practica12_itzanhuerta.classes.Tipo;

public class FormularioRobot extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_NOMBRE = "R_NOMBRE";
    public static final String KEY_MATERIAL = "R_MATERIAL";
    public static final String KEY_ANYO = "R_ANYO";
    public static final String KEY_TIPO = "R_TIPO";

    private EditText entradaNombre;
    private EditText entradaMaterial;
    private EditText entradaAnyo;
    private Spinner spinnerTipo;
    private Button btnCrearRobot;

    private int pos = 0;
    private long editandoId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_robot);

        entradaNombre = findViewById(R.id.entradaNombre);
        entradaMaterial = findViewById(R.id.entradaMaterial);
        entradaAnyo = findViewById(R.id.entradaAnyo);
        spinnerTipo = findViewById(R.id.spinnerTipo);
        btnCrearRobot = findViewById(R.id.btnCrearRobot);

        Intent i = getIntent();
        try {
            Robot r = (Robot) i.getParcelableExtra("Robot");
            if (r == null)
                getSupportActionBar().setTitle("Creando un robot");
            else
                getSupportActionBar().setTitle("Editando un robot");

            pos = i.getIntExtra("pos", 0);
            editandoId = r.id;

            entradaNombre.setText(r.nombre);
            entradaMaterial.setText(r.material);
            entradaAnyo.setText(String.valueOf(r.anyo));
            spinnerTipo.setSelection(r.tipo.ordinal());
        } catch (NullPointerException ex) {

        }

        btnCrearRobot.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_NOMBRE, this.entradaNombre.getText().toString());
        outState.putString(KEY_MATERIAL, this.entradaMaterial.getText().toString());
        outState.putString(KEY_ANYO, this.entradaAnyo.getText().toString());
        outState.putInt(KEY_TIPO, this.spinnerTipo.getSelectedItemPosition());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        this.entradaNombre.setText(savedInstanceState.getString(KEY_NOMBRE));
        this.entradaMaterial.setText(savedInstanceState.getString(KEY_MATERIAL));
        this.entradaAnyo.setText(savedInstanceState.getString(KEY_ANYO));
        this.spinnerTipo.setSelection(savedInstanceState.getInt(KEY_TIPO));

        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        String nombre = entradaNombre.getText().toString();
        String material = entradaMaterial.getText().toString();
        int anyo;
        try {
            anyo = Integer.parseInt(entradaAnyo.getText().toString());
        } catch (Exception e) {
            anyo = 0;
        }
        Tipo t = Tipo.values()[spinnerTipo.getSelectedItemPosition()];

        Robot r = new Robot(nombre, material, anyo, t);
        r.id = editandoId;
        Intent i = new Intent();
        i.putExtra("Robot", r);
        i.putExtra("pos", pos);
        setResult(0, i);
        finish();
    }
}
