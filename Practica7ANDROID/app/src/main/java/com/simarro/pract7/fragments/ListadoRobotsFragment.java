package com.simarro.pract7.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.simarro.pract7.R;
import com.simarro.pract7.clases.AdaptadorRobots;
import com.simarro.pract7.clases.Robot;

import java.util.ArrayList;

public class ListadoRobotsFragment extends Fragment {

    private AdaptadorRobots robotsAdapter;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listado_robots,container,flase);
        getActivity().setTitle("Listado robots");

        ArrayList<Robot> robtos = new ArrayList<Robot>();

        robots.add(new Robot("1","Hierrocop",'M'));
        robots.add(new Robot("2","Titacop",'M'));
        robots.add(new Robot("3","Acerocop",'M'));


        robotsAdapter = new AdaptadorRobots(robtos, getActivity());
        robotsAdapter.setOnClickListener(this);



    }
}
