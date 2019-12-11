package com.example.proyecto1evaluacionguillem;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class FormularioPedido extends AppCompatActivity implements View.OnClickListener {

    private EditText entradaNombre;
    private EditText entradaEmpresa;
    private EditText entradaAnyo;
    private Spinner spinnerTipo;
    private Button btnCrearRobot;
    private int pos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_pedidos);

        entradaNombre = findViewById(R.id.entradaNombre);
        entradaEmpresa = findViewById(R.id.entradaMaterial);
        entradaAnyo = findViewById(R.id.entradaPuntadas);
        spinnerTipo = findViewById(R.id.spinnerTipo);
        btnCrearRobot = findViewById(R.id.btnCrearPedido);

        Intent i = getIntent();
        try {
            Pedido r = (Pedido) i.getSerializableExtra("Pedido");
            pos = i.getIntExtra("pos", 0);

            entradaNombre.setText(r.nombre);
            entradaEmpresa.setText(r.empresa);
            entradaAnyo.setText(String.valueOf(r.puntadas));
            spinnerTipo.setSelection(r.tipo.ordinal());
        } catch (NullPointerException ex) {

        }

        btnCrearRobot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nombre = entradaNombre.getText().toString();
        String material = entradaEmpresa.getText().toString();
        int anyo = Integer.parseInt(entradaAnyo.getText().toString());
        Tipo t = Tipo.values()[spinnerTipo.getSelectedItemPosition()];

        Pedido r = new Pedido(nombre, material, anyo, t);
        Intent i = new Intent();
        i.putExtra("Pedido", r);
        i.putExtra("pos", pos);
        setResult(0, i);
        finish();
    }
}
