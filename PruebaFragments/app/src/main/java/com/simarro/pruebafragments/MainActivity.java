package com.simarro.pruebafragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MiPrimerFragment.OnMiPrimerFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager supportFragment = getSupportFragmentManager();

        FragmentTransaction transaction = supportFragment.beginTransaction();


        MiPrimerFragment mFragment = MiPrimerFragment.newInstance("Guillem CRAK");
        transaction.add(R.id.layout_contenedor, mFragment);
        MiPrimerFragment mFragment2 = MiPrimerFragment.newInstance("QUE TAPASANDO");
        transaction.add(R.id.layout_contenedor, mFragment2);

        transaction.commit();

    }

    @Override
    public void OnMiPrimerFragmentClick() {

        FragmentManager suFragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = suFragmentManager.beginTransaction();

        SegundoFragment segundoFragment = SegundoFragment.newInstance();
        transaction.replace(R.id.layout_contenedor, segundoFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount()>0){
            getSupportFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }
}
