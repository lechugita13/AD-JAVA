package com.simarro.practica11.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.simarro.practica11.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FragmentoDialogoModelo extends DialogFragment {
    private String mensaje;
    private int tipo;
    EditText nombre;
    TextView titleuser;


    public static FragmentoDialogoModelo newInstance(String mensaje, int tipo) {

        Bundle args = new Bundle();

        FragmentoDialogoModelo fragment = new FragmentoDialogoModelo();
        args.putString("msg", mensaje);
        args.putInt("type", tipo);
        fragment.setArguments(args);
        fragment.setCancelable(false);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();


        if (args != null) {
            mensaje = args.getString("msg");
            tipo = args.getInt("type");



        }
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable final Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View v = inflater.inflate(R.layout.dialog_singnin, null);
        builder.setView(v)
                .setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences perfs = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
                        nombre = v.findViewById(R.id.name);
                        titleuser = v.findViewById(R.id.titleUser);
                        SharedPreferences.Editor perfsEditor = perfs.edit();
                        perfsEditor.putString("user", nombre.getText().toString());
                        titleuser.setText(nombre.getText().toString());
                        perfsEditor.apply();
                        perfsEditor.commit();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Has cancelat el login", Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();

    }


}
