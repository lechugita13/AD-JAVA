package com.example.practica_7_guillem;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRobots extends RecyclerView.Adapter<RobotViewHolder> implements RobotViewHolder.OnArray {

    private ArrayList<Robot> listaRobots;
    private Context context;

    public AdaptadorRobots(ArrayList<Robot> listaRobots, Context context) {
        this.listaRobots = listaRobots;
        this.context = context;

    }



    @NonNull
    @Override
    public RobotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_robot, parent, false);
        RobotViewHolder viewHolder = new RobotViewHolder(itemView, this.context,this);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RobotViewHolder holder, int position) {
        holder.bindRobot(this.listaRobots.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    @Override
    public void onArrayClick(int pos) {

        Log.d("pepe", "onArrayClick: ");
    }
}
