package com.simarro.practica_6;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;



public class RobotsViewHolder extends RecyclerView.ViewHolder{

    private ImageView img;
    private TextView Nombre;
    private TextView anyo;
    private Context contexto;

    public RobotsViewHolder(View itemView, Context context){
        super(itemView);

        img = itemView.findViewById(R.id.img);
        Nombre = itemView.findViewById(R.id.tv_nombre);
        anyo = itemView.findViewById(R.id.anyo);
        contexto = context;
    }

    public  void bindRobot(Robot r){

        if (r.getTipo() == "Bender"){
               img.setImageDrawable(contexto.getDrawable(R.drawable.bender));
        }
        if (r.getTipo() == "R2D2"){
            img.setImageDrawable(contexto.getDrawable(R.drawable.r2d2));
        }
        if (r.getTipo() == "Walle"){
            img.setImageDrawable(contexto.getDrawable(R.drawable.walle));
        }

    }
}

