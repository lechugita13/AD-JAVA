package com.example.practica_7_guillem;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;



public class RobotViewHolder extends RecyclerView.ViewHolder{

    private ImageView imgRobot;
    private TextView tvNombre;
    private TextView tvMaterial;
    private TextView tvAnyo;
    private Context contexto;

    public RobotViewHolder(View itemView, Context context){
        super(itemView);

        imgRobot = itemView.findViewById(R.id.img_robot);
        tvNombre = itemView.findViewById(R.id.tv_nombre);
        tvMaterial = itemView.findViewById(R.id.tv_material);
        tvAnyo = itemView.findViewById(R.id.tv_anyo);
        contexto = context;
    }

    public  void bindAlumno(Robot a){

        if(a.getTipo().equals("R2D2")){
            imgRobot.setImageDrawable(contexto.getDrawable(R.drawable.rdosddos));
        }else if(a.getTipo().equals("BENDER")){
            imgRobot.setImageDrawable(contexto.getDrawable(R.drawable.bender));
        }else{
            imgRobot.setImageDrawable(contexto.getDrawable(R.drawable.walle));
        }
        tvNombre.setText(a.getNombre());
        tvMaterial.setText(a.getMaterial());
        tvAnyo.setText(Integer.toString(a.getAnyo()));
    }
}
