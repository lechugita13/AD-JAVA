package com.simarro.practica_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    public AdaptadorRobots adaptador;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Robot> Robots;
    private SwipeRefreshLayout swipeRefreshLayout;


    public void cargarDatos(){
        Robots.clear();

        swipeRefreshLayout.setRefreshing(false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        swipeRefreshLayout = findViewById(R.id.srl);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                cargarDatos();
                adaptador.notifyDataSetChanged();
            }
        });

        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.colorAccent);
        //desactivar swipe swipeRefreshLayout.setEnabled(false);

        Robots = new ArrayList<>();
        cargarDatos();

        recyclerView = findViewById(R.id.rv_robots);
        adaptador = new AdaptadorRobots(Robots, this);
        adaptador.setOnClickListener(this);
        recyclerView.setAdapter(adaptador);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        //layoutManager = new GridLayoutManager(this,3);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(layoutManager);

        Button nuevo = (Button) findViewById(R.id.nuevo);
        nuevo.setOnClickListener(this);

        ItemTouchHelper.SimpleCallback myCallBack = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                switch (direction){
                    case ItemTouchHelper.RIGHT:
                        Robots.remove(viewHolder.getAdapterPosition());
                        adaptador.notifyItemRemoved(viewHolder.getAdapterPosition());
                        break;
                    case ItemTouchHelper.LEFT:
                        adaptador.notifyDataSetChanged();
                        break;
                }


            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

                Paint pincel = new Paint();
                pincel.setColor(Color.WHITE);
                int sizeText = getResources().getDimensionPixelSize(R.dimen.textSize);
                pincel.setTextSize(sizeText);

                //Derecha
                if(dX >0){
                    c.clipRect(viewHolder.itemView.getLeft(),viewHolder.itemView.getTop(),dX,viewHolder.itemView.getBottom());
                    if (dX < recyclerView.getWidth() / 3){
                        c.drawColor(Color.GRAY);
                    }else{
                        c.drawColor(Color.RED);
                    }
                    int margen = 40;
                    Drawable delete = getDrawable(R.drawable.delete);
                    delete.setBounds(viewHolder.itemView.getLeft()+margen,
                            viewHolder.itemView.getTop()+margen,
                            viewHolder.itemView.getHeight()-margen,
                            viewHolder.itemView.getBottom()-margen);
                    delete.draw(c);

                    pincel.setTextAlign(Paint.Align.LEFT);
                    c.drawText(getResources().getString(R.string.eliminar),viewHolder.itemView.getHeight(),
                            viewHolder.itemView.getBottom()-viewHolder.itemView.getHeight()/2+sizeText/2,pincel);
                }else if (dX < 0){

                    c.clipRect(viewHolder.itemView.getRight(),viewHolder.itemView.getTop(),dX,viewHolder.itemView.getBottom());
                    if (dX < -recyclerView.getWidth() / 3){
                        c.drawColor(Color.GREEN);
                    }else{
                        c.drawColor(Color.GRAY);
                    }

                    int margen = 40;
                    Drawable editar = getDrawable(R.drawable.edit);
                    editar.setBounds(viewHolder.itemView.getRight() - viewHolder.itemView.getHeight()+margen,
                            viewHolder.itemView.getTop() + margen,
                            viewHolder.itemView.getRight() - margen,
                            viewHolder.itemView.getBottom() - margen);

                    editar.draw(c);

                    pincel.setTextAlign(Paint.Align.RIGHT);
                    c.drawText(getResources().getString(R.string.editar),viewHolder.itemView.getRight() - viewHolder.itemView.getHeight(),
                            viewHolder.itemView.getBottom()-viewHolder.itemView.getHeight()/2+sizeText/2,pincel);
                }
            }
        };


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(myCallBack);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    @Override
    public void onClick(View v) {


            Intent intent = new Intent (v.getContext(), Activity_2_Button.class);
            startActivityForResult(intent, 0);


    }
}
