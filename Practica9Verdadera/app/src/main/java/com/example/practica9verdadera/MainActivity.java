package com.example.practica9verdadera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;



import com.example.practica9verdadera.fragments.Fragment1;
import com.example.practica9verdadera.fragments.Fragment2;
import com.example.practica9verdadera.fragments.Fragment3;
import com.example.practica9verdadera.fragments.Fragment4;
import com.example.practica9verdadera.fragments.Fragment5;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
