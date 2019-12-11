package com.example.proyecto1evaluacionguillem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ReciclerDiseny extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private TextView tvNoHayDibujos;
    private RecyclerView recycler;
    private FloatingActionButton botonNuevoRobot;
    private AdaptadorPedido adaptador;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recicler_diseny);

        recycler = findViewById(R.id.recycler);
        tvNoHayDibujos = findViewById(R.id.tvNoHayDibujos);
        recycler.setVisibility(View.INVISIBLE);
        tvNoHayDibujos.setVisibility(View.VISIBLE);
        botonNuevoRobot = findViewById(R.id.botonNuevoDibujo);

        botonNuevoRobot.setOnClickListener(this);

        adaptador = new AdaptadorPedido(listaPedidos, this);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(layoutManager);

        crearGestos();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.adaptador.notifyDataSetChanged();
    }

    private void crearGestos() {
        ItemTouchHelper.SimpleCallback myCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                switch (direction) {
                    case (ItemTouchHelper.RIGHT): {
                        borrarRobot(viewHolder);
                        break;
                    }
                    case (ItemTouchHelper.LEFT): {
                        abrirFormEditarRobot(viewHolder.getAdapterPosition());
                        break;
                    }
                }
            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                // derecha
                if (dX > 0) {
                    moverHaciaLaDerecha(c, recyclerView, viewHolder, dX);
                } else if (dX < 0) { // izquierda
                    moverHaciaLaIzquierda(c, recyclerView, viewHolder, dX);
                }

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }

            private void moverHaciaLaDerecha(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX) {
                Paint pincel = new Paint();
                pincel.setColor(Color.WHITE);
                int sizeText = getResources().getDimensionPixelSize(R.dimen.textSize);
                pincel.setTextSize(sizeText);

                c.clipRect(viewHolder.itemView.getLeft(), viewHolder.itemView.getTop(), dX, viewHolder.itemView.getBottom());
                if (dX < recyclerView.getWidth() / 3)
                    c.drawColor(getResources().getColor(R.color.colorBorrarChill));
                else
                    c.drawColor(getResources().getColor(R.color.colorBorrar));
                Drawable deleteThis = getDrawable(R.drawable.ic_delete_sweep);
                int margin = getResources().getDimensionPixelSize(R.dimen.margen);
                deleteThis.setBounds(viewHolder.itemView.getLeft() + margin,
                        viewHolder.itemView.getTop() + margin,
                        viewHolder.itemView.getHeight() - margin,
                        viewHolder.itemView.getBottom() - margin);
                deleteThis.draw(c);

                pincel.setTextAlign(Paint.Align.LEFT);
                c.drawText(getResources().getString(R.string.eliminar), viewHolder.itemView.getHeight(),
                        viewHolder.itemView.getBottom() - viewHolder.itemView.getHeight() / 2 + sizeText / 2, pincel);
            }

            private void moverHaciaLaIzquierda(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX) {
                Paint pincel = new Paint();
                pincel.setColor(Color.WHITE);
                int sizeText = getResources().getDimensionPixelSize(R.dimen.textSize);
                pincel.setTextSize(sizeText);

                c.clipRect(viewHolder.itemView.getRight() + dX, viewHolder.itemView.getTop(),
                        viewHolder.itemView.getRight(), viewHolder.itemView.getBottom());
                if (Math.abs(dX) < recyclerView.getWidth() / 3)
                    c.drawColor(getResources().getColor(R.color.colorEditarChill));
                else
                    c.drawColor(getResources().getColor(R.color.colorEditar));
                Drawable iconEdit = getDrawable(R.drawable.ic_edit_black);
                int margin = getResources().getDimensionPixelSize(R.dimen.margen);
                iconEdit.setBounds(viewHolder.itemView.getRight() - viewHolder.itemView.getHeight() + margin,
                        viewHolder.itemView.getTop() + margin,
                        viewHolder.itemView.getRight() - margin,
                        viewHolder.itemView.getBottom() - margin);
                iconEdit.draw(c);

                pincel.setTextAlign(Paint.Align.RIGHT);
                c.drawText(getResources().getString(R.string.editar), viewHolder.itemView.getRight() - viewHolder.itemView.getHeight(),
                        viewHolder.itemView.getBottom() - viewHolder.itemView.getHeight() / 2 + sizeText / 2, pincel);
            }


        };
        (new ItemTouchHelper(myCallback)).attachToRecyclerView(recycler);
    }

    private void borrarRobot(@NonNull RecyclerView.ViewHolder viewHolder) {
        try {
            this.listaPedidos.remove(viewHolder.getAdapterPosition());
        } catch (IndexOutOfBoundsException e) {

        }
        adaptador.notifyItemRemoved(viewHolder.getAdapterPosition());

        if (this.listaPedidos.size() == 0) {
            this.tvNoHayDibujos.setVisibility(View.VISIBLE);
            this.recycler.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.botonNuevoDibujo) {
            abrirFormNuevoRobot();
        }
    }

    private void abrirFormNuevoRobot() {
        Intent i = new Intent(this, FormularioPedido.class);
        startActivityForResult(i, 0);
    }

    private void abrirFormEditarRobot(int pos) {
        Pedido r = this.listaPedidos.get(pos);
        Intent i = new Intent(this, FormularioPedido.class);
        i.putExtra("Pedido", r);
        i.putExtra("pos", pos);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 0 && resultCode == 0) {
            Pedido r;
            try {
                r = (Pedido) data.getSerializableExtra("Pedido");
                anyadirNuevoRobot(r);
            } catch (NullPointerException e) {
                return;
            }
        } else if (requestCode == 1 && resultCode == 0) {
            try {
                Pedido r = (Pedido) data.getSerializableExtra("Pedido");
                int i = data.getIntExtra("pos", 0);
                this.listaPedidos.set(i, r);
                adaptador.notifyItemChanged(i);
            } catch (NullPointerException e) {
                return;
            }
        }
    }

    private void anyadirNuevoRobot(final Pedido r) {
        // añadir robot
        this.listaPedidos.add(0, r);
        recycler.setVisibility(View.VISIBLE);
        tvNoHayDibujos.setVisibility(View.INVISIBLE);
        this.adaptador.notifyItemInserted(0);

        this.tvNoHayDibujos.setVisibility(View.INVISIBLE);
        this.recycler.setVisibility(View.VISIBLE);

        // mostrar SnackBar
        Snackbar snack = Snackbar.make(recycler, "Se ha añadido " + r.nombre, Snackbar.LENGTH_LONG);
        snack.show();
        snack.setAction("DESHACER", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaPedidos.remove(r);
                adaptador.notifyItemRemoved(0);
            }
        });
    }
}