package com.example.practica_7_guillem;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListadoRobotsFragment extends Fragment implements RobotViewHolder.OnArray{

    ArrayList<Robot> robots;
    AdaptadorRobots robotsAdapter;
    RecyclerView recyclerView;
    private OnRobotSelected mListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listado_robots,container,false);
        getActivity().setTitle("Listado robots");

        robots = new ArrayList<>();
        robots.add(new Robot("Guillem","Hierro",2000,Tipo.BENDER));
        robots.add(new Robot("Sara","Titanio",1800,Tipo.R2D2));
        robots.add(new Robot("Toni","Chapa",3000,Tipo.WALLE));
        int tamaño = robots.size();


        robotsAdapter = new AdaptadorRobots(robots, getActivity());


        recyclerView = view.findViewById(R.id.fantasia);
        recyclerView.setAdapter(robotsAdapter);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));


        return view;

    }


    public static ListadoRobotsFragment newInstance() {

        Bundle informacionParaFragment = new Bundle();

        ListadoRobotsFragment mFragment = new ListadoRobotsFragment();
        mFragment.setArguments(informacionParaFragment);
        return mFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (mListener instanceof OnRobotSelected){

            mListener = (OnRobotSelected) context;
        }


    }

    @Override
    public void onArrayClick(int pos) {


        mListener.onRobotSelectedClick(robots.get(pos));

    }


    public interface OnRobotSelected{
        void onRobotSelectedClick(Robot robotSelected);
    }
}
