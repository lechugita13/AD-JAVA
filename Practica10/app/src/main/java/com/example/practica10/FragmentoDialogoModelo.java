package com.example.practica10;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class FragmentoDialogoModelo extends DialogFragment implements DialogInterface.OnClickListener {
    private String mensaje;
    private int tipo;
    private OnPutoAlex listener;


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
        final AlertDialog.Builder  builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialog_singnin,null))
                .setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "has loguejat", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        switch (i) {
            case DialogInterface.BUTTON_NEGATIVE:
                listener.OnClickPutoAlexNo();
                break;
            case DialogInterface.BUTTON_NEUTRAL:
                listener.OnClickPutoAlexNeutro();
                break;
            case DialogInterface.BUTTON_POSITIVE:
                listener.OnClickPutoAlexSi();
                break;

        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPutoAlex) {
            listener = (OnPutoAlex) context;
        } else {
            throw new RuntimeException(context.toString() + "deus implementar");
        }
    }

    public interface OnPutoAlex {

        void OnClickPutoAlexNo();

        void OnClickPutoAlexSi();

        void OnClickPutoAlexNeutro();

    }
}
