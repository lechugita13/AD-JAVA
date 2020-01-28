package com.simarro.pract7.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.simarro.pract7.clases.AdaptadorRobots;
import com.simarro.pract7.R;
import com.simarro.pract7.clases.Robot;
import com.simarro.pract7.fragments.ListadoRobotsFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botoCrear;
    private RecyclerView recyclerView;
    private AdaptadorRobots adaptador;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Robot> robots;
    private SwipeRefreshLayout swipeRefreshLayout;


    public void cargarDatos() {

        robots.clear();
        for (int i = 1; i < 10; i++) {
            robots.add(new Robot("1234567" + i, "Nombre" + i, (i % 2 == 0) ? 'H' : 'M'));

        }
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        robots = new ArrayList<>();

        botoCrear = findViewById(R.id.botoCrear);
        recyclerView = (RecyclerView) findViewById(R.id.rv_alumnos);
        adaptador = new AdaptadorRobots(robots, this);
        recyclerView.setAdapter(adaptador);
        adaptador.setOnClickListener(this);
        botoCrear.setOnClickListener(this);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        getSupportActionBar().setTitle("Listado de robots");


        ItemTouchHelper.SimpleCallback myCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                switch (direction) {
                    case ItemTouchHelper.RIGHT:
                        robots.remove(viewHolder.getAdapterPosition());
                        adaptador.notifyItemRemoved(viewHolder.getAdapterPosition());
                        break;
                    case ItemTouchHelper.LEFT:
                        Toast.makeText(MainActivity.this, "PACA EL ALTRE COSTAT", Toast.LENGTH_LONG).show();
                        editarRobots(robots.get(viewHolder.getAdapterPosition()));
                        adaptador.notifyDataSetChanged();
                        break;
                }

            }

            private void editarRobots(Robot adapterPosition) {

                Intent intent = new Intent(MainActivity.this, EditarRobots.class);
                Bundle pasarPosicio = new Bundle();

                pasarPosicio.putSerializable("robots", robots);

                intent.putExtras(pasarPosicio);
                startActivityForResult(intent, 2);

            }


            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {


                Paint pincel = new Paint();
                pincel.setColor(Color.WHITE);
                int sizetext = getResources().getDimensionPixelSize(R.dimen.textsize);
                pincel.setTextSize(sizetext);

                //Vox
                if (dX > 0) {
                    c.clipRect(viewHolder.itemView.getLeft(), viewHolder.itemView.getTop(), dX, viewHolder.itemView.getBottom());
                    if (dX < recyclerView.getWidth() / 3)
                        c.drawColor(Color.GRAY);
                    else
                        c.drawColor(Color.RED);
                    Drawable delete = getDrawable(R.drawable.delelte);
                    delete.setBounds(viewHolder.itemView.getLeft(), viewHolder.itemView.getTop(), viewHolder.itemView.getHeight(), viewHolder.itemView.getBottom());
                    delete.draw(c);

                    pincel.setTextAlign(Paint.Align.LEFT);
                    c.drawText(getResources().getString(R.string.eliminar)
                            , viewHolder.itemView.getHeight()
                            , viewHolder.itemView.getBottom() - viewHolder.itemView.getHeight() / 2 + sizetext / 2
                            , pincel);
                }//ERC
                else if (dX < 0) {

                    c.clipRect(viewHolder.itemView.getRight() + dX, viewHolder.itemView.getTop(), viewHolder.itemView.getRight(), viewHolder.itemView.getBottom());
                    if (Math.abs(dX) < recyclerView.getWidth() / 3) {
                        c.drawColor(Color.GREEN);
                        //Snackbar.make(recyclerView, "Estic dins del else", Snackbar.LENGTH_SHORT).show();
                    } else
                        c.drawColor(Color.BLUE);
                    Drawable edit = getDrawable(R.drawable.edit);
                    edit.setBounds(viewHolder.itemView.getRight() - viewHolder.itemView.getHeight(), viewHolder.itemView.getTop(), viewHolder.itemView.getRight(), viewHolder.itemView.getBottom());
                    edit.draw(c);
                    String editarString = getResources().getString(R.string.editar);
                    Rect pepe = new Rect();
                    pincel.getTextBounds(editarString, 0, editarString.length(), pepe);
                    pincel.setTextAlign(Paint.Align.RIGHT);
                    c.drawText(editarString
                            , viewHolder.itemView.getRight() - viewHolder.itemView.getHeight()
                            , viewHolder.itemView.getBottom() - viewHolder.itemView.getHeight() / 2 + sizetext / 2
                            , pincel);
                }


                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(myCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.srl);
        cargarDatos();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                                                    @Override
                                                    public void onRefresh() {
                                                        cargarDatos();
                                                        adaptador.notifyDataSetChanged();
                                                    }
                                                }


        );
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        recyclerView.setLayoutManager(layoutManager);


    }


    @Override
    public void onClick(View view) {

        Intent i = new Intent(this, FormularioRobots.class);
        startActivityForResult(i, 1);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista_robots, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.addRobot:
                Intent i = new Intent(this, FormularioRobots.class);
                startActivityForResult(i, 1);
                break;

            case R.id.reiniciar:
                robots.clear();
                swipeRefreshLayout.setRefreshing(false);
                adaptador.notifyDataSetChanged();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {


            try {


                Robot a = (Robot) data.getSerializableExtra("alumno");
                Log.d("Hola", "onClick: " + a);

                robots.add(a);
            } catch (NullPointerException e) {

            }


        }
        if (requestCode == 2) {


            try {


                Robot a = (Robot) data.getSerializableExtra("alumno");
                Log.d("Hola", "onClick: " + a);


            } catch (NullPointerException e) {

            }


        }

    }


}
