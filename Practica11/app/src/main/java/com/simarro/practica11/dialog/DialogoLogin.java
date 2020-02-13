package com.simarro.practica11.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.simarro.practica11.R;

public class DialogoLogin extends DialogFragment {

    private OnLoginListener listener;
    private EditText entradaUsuario;
    private EditText entradaContrasenya;


    public interface OnLoginListener {
        public void onLogin(String user, String pass);
    }

    public DialogoLogin(OnLoginListener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_login, null);

        this.entradaUsuario = v.findViewById(R.id.entradaUsuario);
        this.entradaContrasenya = v.findViewById(R.id.entradaContrasenya);

        builder
                .setView(v)
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onLogin(
                                entradaUsuario.getText().toString(),
                                entradaContrasenya.getText().toString());
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onLogin(null, null);
                    }
                });

        return builder.create();
    }
}
