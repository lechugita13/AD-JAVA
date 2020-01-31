package com.simarro.pruebadialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
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
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final String[] paises = getResources().getStringArray(R.array.paises);
        switch (tipo) {
            case 1:
                builder.setTitle("PruebasFantasia 1").setMessage(mensaje)
                        .setPositiveButton("Si TeuPase", this)
                        .setNegativeButton("No feso tu", this)
                        .setNeutralButton("Si vols tajude", this);
                break;
            case 2:
                builder.setItems(paises, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Sergi Malparit", Toast.LENGTH_SHORT).show();
                    }
                });

                break;
            case 3:
               builder.setSingleChoiceItems(paises, -1, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       Toast.makeText(getActivity(), "Sergi REMALPARIT", Toast.LENGTH_SHORT).show();
                   }
               }).setPositiveButton("OK",null);
                break;
            case 4:
                final ArrayList<String> selectedItems = new ArrayList<>();
               builder.setMultiChoiceItems(paises, null, new DialogInterface.OnMultiChoiceClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                       if (b){
                           selectedItems.add(paises[i]);

                       }else if (selectedItems.contains(paises[i])){
                           selectedItems.remove(paises[i]);
                       }
                       Toast.makeText(getActivity(),selectedItems.toString(), Toast.LENGTH_SHORT).show();
                   }
               }).setPositiveButton("PUTO SERGI",null);
                break;
        }




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
