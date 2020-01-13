package com.example.robotsbenfet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.ArrayList;

public class EditarRobots extends AppCompatActivity implements View.OnClickListener {

    private EditText dni;
    private EditText nombre;
    private RadioButton sexo;
    private Button editar;
    private int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_robots);
        dni = findViewById(R.id.cambiodni);
        nombre = findViewById(R.id.et_nombre);
        sexo = findViewById(R.id.sex_hombre);
        editar = findViewById(R.id.editarbtn);
        getSupportActionBar().setTitle("Edicion un robot");

        editar.setOnClickListener(this);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Metemos en el bundle lo que queremos conservar
        outState.putString("dni",dni.toString());
        outState.putString("nombre",nombre.toString());


    }
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_insertar) {
            char sexo1 = (sexo.isChecked()) ? 'H' : 'M';
            ArrayList<Robot> robots = (ArrayList<Robot>) getIntent().getSerializableExtra("robots");

            Robot robotSel = robots.get(getIntent().getIntExtra("posicioArray",2));

            robotSel.setDni(dni.getText().toString());
            robotSel.setNombre(nombre.getText().toString());
            robotSel.setSexo(sexo1);



            Log.d("Hola", "onClick: " + robotSel);


            Bundle pasarArray = new Bundle();
            pasarArray.putSerializable("alumno", robots);



            Intent i = new Intent();
            i.putExtra("Robot", robotSel);
            i.putExtra("pos",pos);
            setResult(0, i);
            finish();
        }
    }
}
