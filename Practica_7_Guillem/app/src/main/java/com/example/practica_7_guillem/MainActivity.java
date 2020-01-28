package com.example.practica_7_guillem;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements ListadoRobotsFragment.OnArrayClickListener {

    private boolean pantallaMovil;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantallaMovil = getSupportFragmentManager().findFragmentById(R.id.fgrag_lista) == null;

        if(pantallaMovil){

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            ListadoRobotsFragment listadoFragment = ListadoRobotsFragment.newInstance("Listado Robots");
            transaction.add(R.id.layout_contenedor,listadoFragment);
            transaction.commit();
        }

    }
    

    @Override
    public void onArrayClick(Robot editar) {
        if (pantallaMovil){

            FragmentManager suFragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = suFragmentManager.beginTransaction();

            DetalleRobotFragment segundoFragment = DetalleRobotFragment.newInstance();
            transaction.replace(R.id.layout_contenedor, segundoFragment);
            transaction.addToBackStack(null);
            transaction.commit();

            Bundle data = new Bundle();
            data.putParcelable("robot", editar);
            segundoFragment.setArguments(data);
        }else{
            DetalleRobotFragment framentDetalle = (DetalleRobotFragment) getSupportFragmentManager().findFragmentById(R.id.fgrag_detalle);
            framentDetalle.actualizarDatos(editar);

        }
    }
}
