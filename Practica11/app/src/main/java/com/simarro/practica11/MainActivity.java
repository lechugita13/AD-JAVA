package com.simarro.practica11;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.simarro.practica11.classes.User;
import com.simarro.practica11.dialog.DialogoLogin;
import com.simarro.practica11.fragments.Fragment1;
import com.simarro.practica11.fragments.Fragment2;
import com.simarro.practica11.fragments.Fragment3;
import com.simarro.practica11.fragments.Fragment4;
import com.simarro.practica11.fragments.Fragment5;

import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements DialogoLogin.OnLoginListener, NavigationView.OnNavigationItemSelectedListener {

    public static final String KEY_MIS_PREFERENCIAS = "MisPreferencias";
    public static final String KEY_USERNAME = "USERNAME";
    public static final String KEY_FULLNAME = "FULLNAME";
    public static final String KEY_ID = "ID";

    private DrawerLayout drawerLayout;
    private NavigationView navView;

    private TextView tvUsuario;
    private TextView tvNombreCompleto;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        tvUsuario = headerView.findViewById(R.id.tvUsuario);
        tvNombreCompleto = headerView.findViewById(R.id.tvNombreCompleto);
        imageView = headerView.findViewById(R.id.imageView);

        // app bar
        setSupportActionBar((androidx.appcompat.widget.Toolbar) findViewById(R.id.appbar));

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);

        // usuarios
        SharedPreferences preferences = getSharedPreferences(KEY_MIS_PREFERENCIAS, MODE_PRIVATE);
        int id = preferences.getInt(KEY_ID, -1);
        String username = preferences.getString(KEY_USERNAME, null);
        String fullName = preferences.getString(KEY_FULLNAME, null);
        if (id == -1 && username == null && fullName == null) {
            mostrarDialogoLogin();
        } else {
            mostrarAlertBienvenido(username);
            this.mostrarUsuario(username, fullName, id);
        }
    }


    private void mostrarUsuario(String username, String fullName, int id) {

        tvUsuario.setText(username);
        tvNombreCompleto.setText(fullName);
        switch (id) {
            case 1: {
                imageView.setImageDrawable(getDrawable(R.drawable.user1));
                break;
            }
            case 2: {
                imageView.setImageDrawable(getDrawable(R.drawable.user2));
                break;
            }
            case 3: {
                imageView.setImageDrawable(getDrawable(R.drawable.user3));
                break;
            }
        }
    }

    private void mostrarAlertBienvenido(String username) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("Bienvenido de nuevo")
                .setMessage("Bienvenido otra vez " + username + ", sabía que volverías.")
                .setPositiveButton("OK", null)
                .setCancelable(false);
        builder.show();
    }

    private void mostrarDialogoLogin() {
        DialogoLogin dialogo = new DialogoLogin(this);
        dialogo.show(getSupportFragmentManager(), null);
        dialogo.setCancelable(false);
    }


    @Override
    public void onLogin(String user, String pass) {
        User u = this.checkLogin(user, pass);
        if (u == null) {
            mostrarDialogoError();
        } else {
            guardarLogin(u);
            // mostrar los datos del usuario en el menu de navegacion
            this.mostrarUsuario(u.getUserName(), u.getFullName(), u.getId());
        }
    }

    private void guardarLogin(User u) {
        SharedPreferences.Editor editor = getSharedPreferences(KEY_MIS_PREFERENCIAS, MODE_PRIVATE).edit();
        editor.putInt(KEY_ID, u.getId());
        editor.putString(KEY_USERNAME, u.getUserName());
        editor.putString(KEY_FULLNAME, u.getFullName());
        editor.commit();
    }

    private void mostrarDialogoError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("Error")
                .setMessage("Datos de inicio de sesión incorrectos, el FBI esta de camino.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mostrarDialogoLogin();
                    }
                })
                .setCancelable(false);
        builder.show();
    }

    private User checkLogin(String user, String pass) {
        InputStreamReader input = new InputStreamReader(getResources().openRawResource(R.raw.users));
        Gson gson = new Gson();
        User[] users = gson.fromJson(input, User[].class);
        for (User u : users) {
            if (u.getUserName().equals(user) && u.getPassword().equals(pass)) {
                return u;
            }
        }
        return null;
    }


    private void eliminarUsuarioGuardado() {
        SharedPreferences.Editor editor = getSharedPreferences(KEY_MIS_PREFERENCIAS, MODE_PRIVATE).edit();
        editor.remove(KEY_ID);
        editor.remove(KEY_USERNAME);
        editor.remove(KEY_FULLNAME);
        editor.commit();
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                this.drawerLayout.openDrawer(Gravity.LEFT);
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
