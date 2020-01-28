package com.example.practica_7_guillem;

import android.content.Context;

import android.os.Bundle;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

public class ListadoRobotsFragment extends Fragment implements View.OnClickListener {

    private final static String ARG_NOMBRE = "ARG_NOMBRE";
    private OnArrayClickListener mListener;
    private ArrayList<Robot> robots;
    private AdaptadorRobots adaptador;
    private RecyclerView recyclerView;
    private String nombre;


    public static ListadoRobotsFragment newInstance(String nombre) {
        Bundle informacionParaFragment = new Bundle();


        informacionParaFragment.putString(ARG_NOMBRE, nombre);
        //informacionParaFragment.putString(ARG_DIRECCION, direccion);

        ListadoRobotsFragment mFragment = new ListadoRobotsFragment();
        mFragment.setArguments(informacionParaFragment);
        return mFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnArrayClickListener){
            mListener = (OnArrayClickListener) context;

        }else{
            throw new RuntimeException(context.toString() + "debe implementar");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_listado_robots,container,false);

        getActivity().setTitle("Listado de robots");

        robots = new ArrayList<>();

        robots.add(new Robot(1,"Hierrocop","Hierro",2000, "BENDER",1000, "Esta es la descripción del primer robot."));
        robots.add(new Robot(2,"Titacop","Titanio",2012, "R2D2",2000,"Esta es la descripción del segundo robot."));
        robots.add(new Robot(3,"Acercop", "Acero",2022, "WALLE",1000,"Esta es la descripción del tercer robot"));

        adaptador = new AdaptadorRobots(robots, this.getActivity());
        adaptador.setOnClickListener(this);
        recyclerView = view.findViewById(R.id.rv_robots);
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        //recyclerView.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        Robot editar = robots.get(recyclerView.getChildAdapterPosition(v));
        mListener.onArrayClick(editar);
    }

    public interface OnArrayClickListener {

        void onArrayClick(Robot editar);
    }
}
