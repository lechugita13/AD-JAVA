package com.example.robotsbenfet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_robots);
        dni = findViewById(R.id.cambiodni);
        nombre = findViewById(R.id.et_nombre);
        sexo = findViewById(R.id.sex_hombre);
        editar = findViewById(R.id.editarbtn);

        editar.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_insertar) {
            char sexo1 = (sexo.isChecked()) ? 'H' : 'M';
            ArrayList<Alumno> alumnos = (ArrayList<Alumno>) getIntent().getSerializableExtra("alumnos");

            Alumno alumnoSel=alumnos.get(getIntent().getIntExtra("posicioArray",2));

            alumnoSel.setDni(dni.getText().toString());
            alumnoSel.setNombre(nombre.getText().toString());
            alumnoSel.setSexo(sexo1);



            Log.d("Hola", "onClick: " + alumnoSel);


            Bundle pasarAlumno = new Bundle();
            pasarAlumno.putSerializable("alumno", alumnoSel);

            //i.putExtra("alumno",nuevoAlumno);
            Bundle posicioAlumno = new Bundle();

            Intent i = new Intent();
            i.putExtras(pasarAlumno);
            setResult(Activity.RESULT_OK, i);
            finish();
        }
    }
}
