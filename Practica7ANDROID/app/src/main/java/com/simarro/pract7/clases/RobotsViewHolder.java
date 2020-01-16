package com.simarro.pract7.clases;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.simarro.pract7.R;
import com.simarro.pract7.clases.Robot;

public class RobotsViewHolder extends RecyclerView.ViewHolder {


    private ImageView imgSexo;
    private TextView tvNombre;
    private TextView tvDni;
    private Context contexto;

    public RobotsViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        imgSexo = itemView.findViewById(R.id.img_sexo);
        tvNombre = itemView.findViewById(R.id.tv_nombre);
        tvDni = itemView.findViewById(R.id.tv_dni);
        contexto = context;


    }

    public void bindAlumno(Robot a) {
        if (a.getSexo() == 'H') {
            imgSexo.setImageDrawable(contexto.getDrawable(R.drawable.bender));

        } else {
            imgSexo.setImageDrawable(contexto.getDrawable(R.drawable.walle));
        }

        tvNombre.setText(a.getNombre());
        tvDni.setText(a.getDni());
    }
}
