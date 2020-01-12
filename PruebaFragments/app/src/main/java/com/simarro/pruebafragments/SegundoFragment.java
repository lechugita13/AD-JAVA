package com.simarro.pruebafragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SegundoFragment extends Fragment {

    public static SegundoFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SegundoFragment fragment = new SegundoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.segundo_fragment,container,false);

        return vista;
    }
}
