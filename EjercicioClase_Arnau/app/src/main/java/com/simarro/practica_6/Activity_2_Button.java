package com.simarro.practica_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Activity_2_Button extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private Button btnInsertar;
    private Spinner spinner;
    private ImageView image;
    private EditText nombre;
    public AdaptadorRobots adaptador;
    private Spinner tipo;
    private EditText anyo;
    private EditText material;
    private ArrayList<Robot> robots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_2_button);
        btnInsertar = findViewById(R.id.btn_insertar);
        nombre = findViewById(R.id.et_nombre);
        material = findViewById(R.id.et_material);
        anyo = findViewById(R.id.et_año);
        tipo = findViewById(R.id.spinner);


        btnInsertar.setOnClickListener(this);
        String[] imagenes = new String[]{"Walle", "R2D2", "Bender"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, imagenes);
        spinner = (Spinner) findViewById(R.id.spinner);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);

    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_insertar) {


            Robot nuevoRobot = new Robot(nombre.getText().toString(), material.getText().toString(), Integer.parseInt(anyo.getText().toString()), spinner.getPrompt().toString());
            robots.add(nuevoRobot);
            adaptador.notifyDataSetChanged();

            Intent i = new Intent(v.getContext(), MainActivity.class);
            startActivityForResult(i, 0);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
