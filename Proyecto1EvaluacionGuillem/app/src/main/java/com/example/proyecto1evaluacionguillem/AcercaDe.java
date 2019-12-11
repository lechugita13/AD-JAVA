package com.example.proyecto1evaluacionguillem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AcercaDe extends AppCompatActivity implements View.OnClickListener {

    private Button atras;
    private Button permisos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        atras = findViewById(R.id.atras);
        atras.setOnClickListener(this);

        permisos = findViewById(R.id.permisos);
        permisos.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.atras){

            Intent i = new Intent(this,DisparadorActivitys.class);
            startActivity(i);
        }
        if (view.getId()==R.id.permisos){

            Intent i = new Intent(this,Activity_Perm.class);
            startActivity(i);
        }
    }
}
