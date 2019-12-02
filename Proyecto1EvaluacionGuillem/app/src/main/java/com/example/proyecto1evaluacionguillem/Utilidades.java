package com.example.proyecto1evaluacionguillem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import androidx.core.app.ActivityCompat;

public class Utilidades {
    public static void solicitarPermiso(final  String permiso, String explicacion, final int codigoPeticion, final Activity actividad){

        if (ActivityCompat.shouldShowRequestPermissionRationale(actividad,permiso)){
            new AlertDialog.Builder(actividad)
                    .setTitle("Solicitud de permiso")
                    .setMessage(explicacion)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(actividad,new String[]{permiso}, codigoPeticion);

                        }
                    })
                    .show();

        }else {
            ActivityCompat.requestPermissions(actividad,new String[]{permiso},codigoPeticion);
        }

    }
}
