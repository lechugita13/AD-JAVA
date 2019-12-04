package com.example.proyecto1evaluacionguillem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Activity_Perm extends AppCompatActivity implements View.OnClickListener {
    private Button botoCrida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permisos);

        botoCrida = findViewById(R.id.botoCrida);
        botoCrida.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == botoCrida.getId()){
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:666666666"));
            if ((ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)) == PackageManager.PERMISSION_GRANTED){
                startActivity(intent);
            }else{
                Utilidades.solicitarPermiso(Manifest.permission.CALL_PHONE,"La aplicacion necesita permisos para realizar una llamada",1,this);
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1){
            if (grantResults.length==1 && grantResults[0] == PackageManager.PERMISSION_GRANTED ){


            }else{
                Toast.makeText(this,"Sin permiso de llamada ",Toast.LENGTH_SHORT).show();

            }
        }
    }
}
