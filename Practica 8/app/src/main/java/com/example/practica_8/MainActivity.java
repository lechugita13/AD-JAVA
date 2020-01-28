package com.example.practica_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.practica_8.fragments.MenuFragment;
import com.example.practica_8.fragments.PreferenciasFragment;
import com.example.practica_8.fragments.PrefilFragment;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        MenuFragment menuFragment = MenuFragment.newInstance("menu");
        transaction.add(R.id.contenedor,menuFragment);
        transaction.commit();
    }

    @Override
    public void OnMenuPerfil() {

        FragmentManager fragmentManagerDos = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManagerDos.beginTransaction();

        PrefilFragment perfilFragment = PrefilFragment.newInstance("perfil");
        transaction.add(R.id.contenedor,perfilFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    public void OnMenuPreferencias() {

        android.app.FragmentManager fragmentManagerTres = getFragmentManager();
        android.app.FragmentTransaction transaction = fragmentManagerTres.beginTransaction();

        PreferenciasFragment preferenciasFragment = new PreferenciasFragment();
        transaction.add(R.id.contenedor,preferenciasFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0){
            getSupportFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }
}