package com.simarro.practica_6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRobots extends RecyclerView.Adapter<RobotsViewHolder> implements View.OnClickListener{

    private ArrayList <Robot> Robots;
    private Context context;

    private View.OnClickListener mListener;

    public AdaptadorRobots(ArrayList<Robot> Robots, Context context) {
        this.Robots = Robots;
        this.context = context;
    }

    @Override
    public RobotsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.elemento_lista, viewGroup,false);
        RobotsViewHolder viewHolder = new RobotsViewHolder(itemView,context);
        itemView.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder (RobotsViewHolder viewHolder, int position){
        Robot Robot = Robots.get(position);
        viewHolder.bindRobot(Robot);
    }

    @Override
    public  int getItemCount(){
        return Robots.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        mListener = listener;
    }
    @Override
    public void onClick(View v) {
        if(mListener != null){
            mListener.onClick(v);
        }
    }
}
