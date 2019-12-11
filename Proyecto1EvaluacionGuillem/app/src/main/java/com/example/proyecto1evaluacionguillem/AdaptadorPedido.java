package com.example.proyecto1evaluacionguillem;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorPedido extends RecyclerView.Adapter<PedidoViewHolder> {

    private ArrayList<Pedido> listaPedidos;
    private Context context;

    public AdaptadorPedido(ArrayList<Pedido> listaPedidos, Context context) {
        this.listaPedidos = listaPedidos;
        this.context = context;
    }

    @NonNull
    @Override
    public PedidoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_adaptador_pedidos, parent, false);
        PedidoViewHolder viewHolder = new PedidoViewHolder(itemView, this.context);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PedidoViewHolder holder, int position) {
        holder.bindRobot(this.listaPedidos.get(position));
    }

    @Override
    public int getItemCount() {
        return this.listaPedidos.size();
    }
}
