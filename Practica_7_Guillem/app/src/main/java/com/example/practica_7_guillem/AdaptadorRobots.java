package com.example.practica_7_guillem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class AdaptadorRobots extends RecyclerView.Adapter<RobotViewHolder> implements View.OnClickListener {

    private ArrayList<Robot> robots;
    private Context context;

    private View.OnClickListener mListener;

    public AdaptadorRobots(ArrayList<Robot> robots, Context context) {
        this.robots = robots;
        this.context = context;
    }

    @Override
    public RobotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_robot,parent, false);
        RobotViewHolder viewHolder = new RobotViewHolder(itemView,context);
        itemView.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder (RobotViewHolder viewHolder, int position){
        Robot robot = robots.get(position);
        viewHolder.bindAlumno(robot);
    }

    @Override
    public  int getItemCount(){
        return robots.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        mListener = listener;
    }

    public ArrayList<Robot> getRobots() {
        return robots;
    }

    public void setRobots(ArrayList<Robot> robots) {
        this.robots = robots;
    }

    @Override
    public void onClick(View v) {
        if(mListener != null){
            mListener.onClick(v);
        }
    }
}
