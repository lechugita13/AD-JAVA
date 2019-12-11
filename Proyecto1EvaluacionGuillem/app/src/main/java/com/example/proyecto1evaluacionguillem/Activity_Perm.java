package com.example.proyecto1evaluacionguillem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Activity_Perm extends AppCompatActivity implements View.OnClickListener {
    private Button botoCrida;
    private Button atras;
    private Button botoFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permisos);

        botoCrida = findViewById(R.id.botoCrida);
        botoCrida.setOnClickListener(this);

        atras = findViewById(R.id.atras);
        atras.setOnClickListener(this);

        botoFoto = findViewById(R.id.botoFoto);
        botoFoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == botoCrida.getId()) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:666666666"));
            if ((ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)) == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
            } else {
                Utilidades.solicitarPermiso(Manifest.permission.CALL_PHONE, "La aplicacion necesita permisos para realizar una llamada", 1, this);
            }
        }

        if (view.getId() == R.id.atras) {

            Intent i = new Intent(this, DisparadorActivitys.class);
            startActivity(i);
        }
        if (view.getId() == botoFoto.getId()) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {// Marshmallow+
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    // Should we show an explanation?
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                        // Show an expanation to the user *asynchronously* -- don't block
                        // this thread waiting for the user's response! After the user
                        // sees the explanation, try again to request the permission.
                    } else {
                        // No se necesita dar una explicación al usuario, sólo pedimos el permiso.
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 2);
                        // MY_PERMISSIONS_REQUEST_CAMARA es una constante definida en la app. El método callback obtiene el resultado de la petición.
                    }
                } else { //have permissions

                }
            } else { // Pre-Marshmallow
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, 0);

            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


            } else {
                Toast.makeText(this, "Sin permiso de llamada ", Toast.LENGTH_SHORT).show();

            }
        }
        if (requestCode == 2) {

            // Si la petición es cancelada, el array resultante estará vacío.
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // El permiso ha sido concedido.
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, 0);

            } else {
                // Permiso denegado, deshabilita la funcionalidad que depende de este permiso.
            }
            return;
        }
        // otros bloques de 'case' para controlar otros permisos de la aplicación
    }
}
