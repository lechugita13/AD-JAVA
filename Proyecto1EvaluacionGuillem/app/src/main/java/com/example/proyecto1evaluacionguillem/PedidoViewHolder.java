package com.example.proyecto1evaluacionguillem;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PedidoViewHolder extends RecyclerView.ViewHolder {

    private Context context;

    private ImageView imagen;
    private TextView tvNomRobot;
    private TextView tvPuntadas;
    private TextView tvEmpresa;

    public PedidoViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;

        this.imagen = itemView.findViewById(R.id.imagen);
        this.tvNomRobot = itemView.findViewById(R.id.tvNomRobot);
        this.tvPuntadas = itemView.findViewById(R.id.tvPuntadas);
        this.tvEmpresa = itemView.findViewById(R.id.tvEmpresa);
    }

    public void bindRobot(Pedido r) {
        Drawable d = this.context.getDrawable(R.drawable.tajimaicon1);
        switch (r.tipo) {
            case TAJIMA: {
                d = this.context.getDrawable(R.drawable.tajimaicon1);
                break;
            }
            case BARUDAN: {
                d = this.context.getDrawable(R.drawable.barudanicon);
                break;
            }
            case BROTHER: {
                d = this.context.getDrawable(R.drawable.brothericon);
                break;
            }
        }
        this.imagen.setImageDrawable(d);

        this.tvNomRobot.setText(r.nombre);
        this.tvPuntadas.setText(String.valueOf(r.puntadas));
        this.tvEmpresa.setText(r.empresa);
    }

}
