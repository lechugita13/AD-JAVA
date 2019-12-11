package com.example.proyecto1evaluacionguillem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DisparadorActivitys extends AppCompatActivity implements View.OnClickListener{

    private Button recicler;
    private Button contacto;
    private Button acercade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disparador_activitys);

        recicler = findViewById(R.id.recicler);
        recicler.setOnClickListener(this);

        contacto = findViewById(R.id.contacto);
        contacto.setOnClickListener(this);

        acercade = findViewById(R.id.acercade);
        acercade.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.recicler){

            Intent i = new Intent(this, ReciclerDiseny.class);
            startActivity(i);
        }
        if (view.getId()==R.id.contacto){

            Intent i = new Intent(this, Contacto.class);
            startActivity(i);
        }
        if (view.getId()==R.id.acercade){

            Intent i = new Intent(this, AcercaDe.class);
            startActivity(i);
        }
    }
}
