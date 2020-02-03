package com.simarro.practica11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.android.material.navigation.NavigationView;
import com.simarro.practica11.fragments.Fragment1;
import com.simarro.practica11.fragments.Fragment2;
import com.simarro.practica11.fragments.Fragment3;
import com.simarro.practica11.fragments.Fragment4;
import com.simarro.practica11.fragments.Fragment5;
import com.simarro.practica11.fragments.FragmentoDialogoModelo;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;
    EditText nombre;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences perfs = getSharedPreferences("login", Context.MODE_PRIVATE);
        if (perfs.getString("user",null) == null){
            FragmentoDialogoModelo dialogoModelo = FragmentoDialogoModelo.newInstance("Hola usuario ",4);
            dialogoModelo.show(getSupportFragmentManager(),null);




        }else{

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Hola de nuevo").setMessage("hola de nuevo "+perfs.getString("user",null))
                    .setPositiveButton("Okey", null)
                    .setNegativeButton("Cancel", null);


        }

        drawerLayout = findViewById(R.id.drawer_layout);

        navView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        navView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.menu_opcion_1:
                fragment = Fragment1.newInstance();
                break;
            case R.id.menu_opcion_2:
                fragment = Fragment2.newInstance();
                break;
            case R.id.menu_opcion_3:
                fragment = Fragment3.newInstance();
                break;
            case R.id.menu_subopcion_1:
                fragment = Fragment4.newInstance();
                break;
            case R.id.menu_subopcion_2:
                fragment = Fragment5.newInstance();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();

        if (navView.getCheckedItem() != null){
            navView.getCheckedItem().setChecked(false);
        }

        menuItem.setChecked(true);

        getSupportActionBar().setTitle(menuItem.getTitle());
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout.closeDrawers();
        return true;

    }

}
