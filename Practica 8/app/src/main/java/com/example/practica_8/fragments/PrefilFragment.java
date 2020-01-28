package com.example.practica_8.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.practica_8.R;

public class PrefilFragment extends Fragment {

    private ImageView foto;

    public static PrefilFragment newInstance(String perfil) {
        Bundle args = new Bundle();

        PrefilFragment fragment = new PrefilFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.perfil_fragment_layout,container,false);

        foto = vista.findViewById(R.id.imgPersona);
        return vista;
    }
}