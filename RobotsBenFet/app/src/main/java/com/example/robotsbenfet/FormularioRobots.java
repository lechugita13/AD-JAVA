package com.example.robotsbenfet;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


import java.util.ArrayList;

public class FormularioRobots extends AppCompatActivity implements View.OnClickListener{

    private EditText etDni;
    private EditText etNombre;
    private RadioButton rbSexoHombre;
    private Button btnInsertar;
    private ArrayList<Alumno> alumnos;
    private AdaptadorAlumnos adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_robots);

        etDni=findViewById(R.id.et_dni);
        etNombre=findViewById(R.id.et_nombre);
        rbSexoHombre =findViewById(R.id.rb_hombre);
        btnInsertar = findViewById(R.id.btn_insertar);
        btnInsertar.setOnClickListener(this);


    }
    @Override
    public void onClick(View view) {


        if (view.getId()==R.id.btn_insertar){
            char sexo = (rbSexoHombre.isChecked()) ? 'H': 'M';
            Alumno nuevoAlumno = new Alumno(etDni.getText().toString(),etNombre.getText().toString(),sexo);
            alumnos.add(nuevoAlumno);

            adaptador.notifyDataSetChanged();
            Bundle pasarAlumno = new Bundle();
            pasarAlumno.putSerializable("alumno",nuevoAlumno);

            Intent i = new Intent(this,MainActivity.class);
            i.putExtra("elAlumno",pasarAlumno);
            startActivityForResult(i,1);
        }


    }

}
