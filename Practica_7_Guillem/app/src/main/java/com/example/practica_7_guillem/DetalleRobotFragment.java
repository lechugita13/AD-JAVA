package com.example.practica_7_guillem;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetalleRobotFragment extends Fragment {

    private ImageView foto;
    private TextView nombre;
    private TextView material;
    private TextView anyo;
    private TextView precio;
    private TextView descripcion;
    private Context contexto;

    private boolean pantallaMovil;

    public static DetalleRobotFragment newInstance() {

        Bundle args = new Bundle();

        DetalleRobotFragment fragment = new DetalleRobotFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_detalle_robot,container,false);

        getActivity().setTitle("Detalle del robot");

        pantallaMovil = getFragmentManager().findFragmentById(R.id.fgrag_lista) == null;

        foto = vista.findViewById(R.id.img_robot);
        nombre = vista.findViewById(R.id.tv_nombre);
        material = vista.findViewById(R.id.tv_material);
        anyo = vista.findViewById(R.id.tv_anyo);
        precio = vista.findViewById(R.id.tv_precio);
        descripcion = vista.findViewById(R.id.tv_descripción);


        if(pantallaMovil){
            Robot robot = (Robot) getArguments().getParcelable("robot");

            if(robot.getTipo().equals("R2D2")){
                foto.setImageDrawable(getContext().getDrawable(R.drawable.rdosddos));
            }else if(robot.getTipo().equals("BENDER")){
                foto.setImageDrawable(getContext().getDrawable(R.drawable.bender));
            }else{
                foto.setImageDrawable(getContext().getDrawable(R.drawable.walle));
            }

            nombre.setText(robot.getNombre());
            material.setText(robot.getMaterial());
            anyo.setText(String.valueOf(robot.getAnyo()));
            precio.setText(String.valueOf(robot.getPrecio()));
            descripcion.setText(robot.getDescripcion());
        }

        return vista;
    }

    public  void actualizarDatos(Robot robot){
        switch (robot.getTipo()){
            case "R2D2":
                foto.setImageDrawable(getActivity().getDrawable(R.drawable.rdosddos));
                break;
            case "BENDER":
                foto.setImageDrawable(getActivity().getDrawable(R.drawable.bender));
                break;
            case "WALLE":
                foto.setImageDrawable(getActivity().getDrawable(R.drawable.walle));
                break;
        }
        nombre.setText(robot.getNombre());
        material.setText(robot.getMaterial());
        anyo.setText(String.valueOf(robot.getAnyo()));
        precio.setText(String.valueOf(robot.getPrecio()));
        descripcion.setText(robot.getDescripcion());
    }
}
