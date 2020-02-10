package com.itzanchan.practica11_itzanhuerta;

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

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.itzanchan.practica11_itzanhuerta.classes.User;
import com.itzanchan.practica11_itzanhuerta.dialog.DialogoLogin;

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

        // cojer el del navigation view el header, y de el los textviews por ID
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

    /**
     * Muestra en el menu lateral los datos del usuario dados por parametro.
     *
     * @param username
     * @param fullName
     * @param id
     */
    private void mostrarUsuario(String username, String fullName, int id) {
        // mostrar los datos del usuario
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

    /**
     * Muestra el mensaje de bienvenida en un dialogo modal. Usado al principio de la aplicacion.
     *
     * @param username
     */
    private void mostrarAlertBienvenido(String username) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("Bienvenido de nuevo")
                .setMessage("Bienvenido otra vez " + username + ", sabía que volverías.")
                .setPositiveButton("OK", null)
                .setCancelable(false);
        builder.show();
    }

    /**
     * Lanza el cuandro de dialogo modal que pregunta por un usuario y contraseña.
     */
    private void mostrarDialogoLogin() {
        DialogoLogin dialogo = new DialogoLogin(this);
        dialogo.show(getSupportFragmentManager(), null);
        dialogo.setCancelable(false);
    }

    /**
     * Lanzado por mostrarDialogoLogin al confirmar.
     *
     * @param user es null si el usuario cancela
     * @param pass es null si el usuario cancela
     */
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

    /**
     * Guarda los datos del usuario especificados a los SharedPreferences.
     *
     * @param u
     */
    private void guardarLogin(User u) {
        SharedPreferences.Editor editor = getSharedPreferences(KEY_MIS_PREFERENCIAS, MODE_PRIVATE).edit();
        editor.putInt(KEY_ID, u.getId());
        editor.putString(KEY_USERNAME, u.getUserName());
        editor.putString(KEY_FULLNAME, u.getFullName());
        editor.commit();
    }

    /**
     * Dialogo de error en caso de no acertar la contraseña. Vuelve a lanzar la entrada de login.
     */
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

    /**
     * Comprueva los datos de un usuario en los datos estáticos del listado de usuarios.
     *
     * @param user nombre de usuario
     * @param pass contraseña de usuario
     * @return el objecto del usuario encontrado en caso que el nombre y la contraseña sean correctas,
     * o null si no ha habido ningun registro que coincida
     */
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

    /**
     * Elimina los datos de usuarios guardados en las SharedPreferences
     */
    private void eliminarUsuarioGuardado() {
        SharedPreferences.Editor editor = getSharedPreferences(KEY_MIS_PREFERENCIAS, MODE_PRIVATE).edit();
        editor.remove(KEY_ID);
        editor.remove(KEY_USERNAME);
        editor.remove(KEY_FULLNAME);
        editor.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_subopcion_1: {
                this.drawerLayout.closeDrawer(Gravity.LEFT);
                this.eliminarUsuarioGuardado();
                this.mostrarDialogoLogin();
            }
        }

        return false;
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
