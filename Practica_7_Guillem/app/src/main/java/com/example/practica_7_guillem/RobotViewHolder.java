package com.example.practica_7_guillem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RobotViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Context context;

    private ImageView imagen;
    private TextView tvNomRobot;
    private TextView tvAnyo;
    private TextView tvMaterial;
    private OnArray mListener;


    public RobotViewHolder(@NonNull View itemView, Context context,OnArray interfaz) {
        super(itemView);
        this.context = context;

        this.imagen = itemView.findViewById(R.id.imagen);
        this.tvNomRobot = itemView.findViewById(R.id.tvNomRobot);
        this.tvAnyo = itemView.findViewById(R.id.tvAnyo);
        this.tvMaterial = itemView.findViewById(R.id.tvMaterial);

        if (interfaz instanceof OnArray){
            mListener = interfaz ;
        }


    }

    public void bindRobot(Robot r) {
        Drawable d = this.context.getDrawable(R.drawable.rdosddos);
        switch (r.tipo) {
            case R2D2: {
                d = this.context.getDrawable(R.drawable.rdosddos);
                break;
            }
            case BENDER: {
                d = this.context.getDrawable(R.drawable.bender);
                break;
            }
            case WALLE: {
                d = this.context.getDrawable(R.drawable.walle);
                break;
            }
        }
        this.imagen.setImageDrawable(d);

        this.tvNomRobot.setText(r.nombre);
        this.tvAnyo.setText(String.valueOf(r.anyo));
        this.tvMaterial.setText(r.material);
    }


    @Override
    public void onClick(View view) {

        mListener.onArrayClick(getAdapterPosition());
    }

    public interface OnArray{
        void onArrayClick(int pos);
    }
}
