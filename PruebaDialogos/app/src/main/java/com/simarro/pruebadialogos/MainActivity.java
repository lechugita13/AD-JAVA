package com.simarro.pruebadialogos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentoDialogoModelo.OnPutoAlex {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    FragmentoDialogoModelo dialogoModelo = FragmentoDialogoModelo.newInstance("Sergi pasam ODOO",4);
    dialogoModelo.show(getSupportFragmentManager(),null);


    }

    @Override
    public void OnClickPutoAlexNo() {
        Toast.makeText(this, "ole no", Toast.LENGTH_LONG).show();
    }

    @Override
    public void OnClickPutoAlexSi() {
        Toast.makeText(this, "ole neutral", Toast.LENGTH_LONG).show();
    }

    @Override
    public void OnClickPutoAlexNeutro() {
        Toast.makeText(this, "ole SI", Toast.LENGTH_LONG).show();
    }
}
