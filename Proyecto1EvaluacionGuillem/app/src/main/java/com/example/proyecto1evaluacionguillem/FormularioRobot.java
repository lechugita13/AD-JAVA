package com.example.proyecto1evaluacionguillem;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class FormularioRobot extends AppCompatActivity implements View.OnClickListener {

    private EditText entradaNombre;
    private EditText entradaMaterial;
    private EditText entradaAnyo;
    private Spinner spinnerTipo;
    private Button btnCrearRobot;
    private int pos = 0;


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
            Robot r = (Robot) i.getSerializableExtra("Robot");
            pos = i.getIntExtra("pos", 0);

            entradaNombre.setText(r.nombre);
            entradaMaterial.setText(r.material);
            entradaAnyo.setText(String.valueOf(r.anyo));
            spinnerTipo.setSelection(r.tipo.ordinal());
        } catch (NullPointerException ex) {

        }

        btnCrearRobot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nombre = entradaNombre.getText().toString();
        String material = entradaMaterial.getText().toString();
        int anyo = Integer.parseInt(entradaAnyo.getText().toString());
        Tipo t = Tipo.values()[spinnerTipo.getSelectedItemPosition()];

        Robot r = new Robot(nombre, material, anyo, t);
        Intent i = new Intent();
        i.putExtra("Robot", r);
        i.putExtra("pos", pos);
        setResult(0, i);
        finish();
    }
}
