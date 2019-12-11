package com.example.proyecto1evaluacionguillem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Contacto extends AppCompatActivity implements View.OnClickListener {

    private Button guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        guardar=findViewById(R.id.btn_guardar);
        guardar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.btn_guardar){

            Intent i = new Intent(this, DisparadorActivitys.class);
            startActivity(i);
        }
    }
}
