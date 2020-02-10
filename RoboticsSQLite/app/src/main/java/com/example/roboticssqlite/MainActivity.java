package com.example.roboticssqlite;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Robot> listaRobots = new ArrayList<>();
    private TextView tvNoHayRobots;
    private RecyclerView recycler;
    private FloatingActionButton botonNuevoRobot;
    private AdaptadorRobots adaptador;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);
        tvNoHayRobots = findViewById(R.id.tvNoHayRobots);
        recycler.setVisibility(View.INVISIBLE);
        tvNoHayRobots.setVisibility(View.VISIBLE);
        botonNuevoRobot = findViewById(R.id.botonNuevoRobot);

        botonNuevoRobot.setOnClickListener(this);

        adaptador = new AdaptadorRobots(listaRobots, this);
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
            this.listaRobots.remove(viewHolder.getAdapterPosition());
        } catch (IndexOutOfBoundsException e) {

        }
        adaptador.notifyItemRemoved(viewHolder.getAdapterPosition());

        if (this.listaRobots.size() == 0) {
            this.tvNoHayRobots.setVisibility(View.VISIBLE);
            this.recycler.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.botonNuevoRobot) {
            abrirFormNuevoRobot();
        }
    }

    private void abrirFormNuevoRobot() {
        Intent i = new Intent(this, FormularioRobot.class);
        startActivityForResult(i, 0);
    }

    private void abrirFormEditarRobot(int pos) {
        Robot r = this.listaRobots.get(pos);
        Intent i = new Intent(this, FormularioRobot.class);
        i.putExtra("Robot", r);
        i.putExtra("pos", pos);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 0 && resultCode == 0) {
            Robot r;
            try {
                r = (Robot) data.getSerializableExtra("Robot");
                anyadirNuevoRobot(r);
            } catch (NullPointerException e) {
                return;
            }
        } else if (requestCode == 1 && resultCode == 0) {
            try {
                Robot r = (Robot) data.getSerializableExtra("Robot");
                int i = data.getIntExtra("pos", 0);
                this.listaRobots.set(i, r);
                adaptador.notifyItemChanged(i);
            } catch (NullPointerException e) {
                return;
            }
        }
    }

    private void anyadirNuevoRobot(final Robot r) {
        // añadir robot
        this.listaRobots.add(0, r);
        recycler.setVisibility(View.VISIBLE);
        tvNoHayRobots.setVisibility(View.INVISIBLE);
        this.adaptador.notifyItemInserted(0);

        this.tvNoHayRobots.setVisibility(View.INVISIBLE);
        this.recycler.setVisibility(View.VISIBLE);

        // mostrar SnackBar
        Snackbar snack = Snackbar.make(recycler, "Se ha añadido " + r.nombre, Snackbar.LENGTH_LONG);
        snack.show();
        snack.setAction("DESHACER", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaRobots.remove(r);
                adaptador.notifyItemRemoved(0);
            }
        });
    }
}
