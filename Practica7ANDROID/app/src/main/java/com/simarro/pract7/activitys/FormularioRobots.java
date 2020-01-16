package com.simarro.pract7.activitys;


import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.simarro.pract7.R;
import com.simarro.pract7.clases.Robot;

public class FormularioRobots extends AppCompatActivity implements View.OnClickListener {

    private EditText etDni;
    private EditText etNombre;
    private RadioButton rbSexoHombre;
    private Button btnInsertar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_robots);

        etDni = findViewById(R.id.et_dni);
        etNombre = findViewById(R.id.et_nombre);
        rbSexoHombre = findViewById(R.id.rb_hombre);
        btnInsertar = findViewById(R.id.btn_insertar);
        btnInsertar.setOnClickListener(this);
        getSupportActionBar().setTitle("Creacion de un robot");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Metemos en el bundle lo que queremos conservar
        outState.putString("dni",etDni.toString());
        outState.putString("nombre",etNombre.toString());


    }
    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.btn_insertar) {
            char sexo = (rbSexoHombre.isChecked()) ? 'H' : 'M';
            Robot nuevoRobot = new Robot(etDni.getText().toString(), etNombre.getText().toString(), sexo);
            Log.d("Hola", "onClick: " + nuevoRobot);


            Bundle pasarAlumno = new Bundle();
            pasarAlumno.putSerializable("alumno", nuevoRobot);

            //i.putExtra("alumno",nuevoRobot);

            Intent i = new Intent();
            i.putExtras(pasarAlumno);
            setResult(Activity.RESULT_OK, i);
            finish();
        }


    }

}
