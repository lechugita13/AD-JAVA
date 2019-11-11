package com.simarro.practicaclasse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private AdaptadorAlumnos adaptador;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Alumno> alumnos;
    private EditText etDni;
    private EditText etNombre;
    private RadioButton rbSexoHombre;
    private Button btnInsertar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        alumnos=new ArrayList<>();

        for (int i =1;i<10;i++){
            alumnos.add(new Alumno("1234567"+i,"Nombre"+i,(i%2==0)?'H':'M'));

        }
        recyclerView = (RecyclerView) findViewById(R.id.rv_alumnos);
        adaptador = new AdaptadorAlumnos(alumnos, this);
        recyclerView.setAdapter(adaptador);
        adaptador.setOnClickListener(this);
        layoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        etDni=findViewById(R.id.et_dni);
        etNombre=findViewById(R.id.et_nombre);
        rbSexoHombre =findViewById(R.id.rb_hombre);
        btnInsertar = findViewById(R.id.btn_insertar);
        btnInsertar.setOnClickListener(this);

        recyclerView.setLayoutManager(layoutManager);

    }


    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.btn_insertar){
            char sexo = (rbSexoHombre.isChecked()) ? 'H': 'M';
            Alumno nuevoAlumno = new Alumno(etDni.getText().toString(),etNombre.getText().toString(),sexo);
            alumnos.add(nuevoAlumno);

            adaptador.notifyDataSetChanged();
        }else{
            int posicion = recyclerView.getChildAdapterPosition(view);
            Alumno aSeleccionado = alumnos.get(posicion);
            Toast.makeText(MainActivity.this,"Alumno"+aSeleccionado.getNombre(),Toast.LENGTH_LONG).show();
        }
    }
}
