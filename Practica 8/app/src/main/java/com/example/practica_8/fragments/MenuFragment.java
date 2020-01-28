package com.example.practica_8.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.practica_8.R;


public class MenuFragment extends Fragment implements View.OnClickListener {

    private Button perfil;
    private Button preferencias;

    private static final String ARG_NOMBRE = "menu";
    private OnFragmentInteractionListener mListener;

    public static MenuFragment newInstance(String nombre) {

        Bundle infoFragment = new Bundle();

        infoFragment.putString(ARG_NOMBRE, nombre);

        MenuFragment mFragment = new MenuFragment();
        mFragment.setArguments(infoFragment);
        return mFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener) context;

        }else{
            throw new RuntimeException(context.toString() + "debe implementar");
        }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.menu_fragment_layaout,container,false);

        perfil = vista.findViewById(R.id.perfilFragment);
        preferencias = vista.findViewById(R.id.preferenciasFragment);
        perfil.setOnClickListener(this);
        preferencias.setOnClickListener(this);
        return vista;
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == perfil.getId()){
            mListener.OnMenuPerfil();
        }else{
            mListener.OnMenuPreferencias();
        }

    }

    public interface OnFragmentInteractionListener {

        void OnMenuPerfil();
        void OnMenuPreferencias();
    }
}
