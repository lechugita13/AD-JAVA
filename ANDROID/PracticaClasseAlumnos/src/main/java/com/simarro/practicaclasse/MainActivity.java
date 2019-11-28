package com.simarro.practicaclasse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private AdaptadorAlumnos adaptador;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Alumno> alumnos;
    private EditText etDni;
    private EditText etNombre;
    private RadioButton rbSexoHombre;
    private SwipeRefreshLayout swipeRefreshLayout;

    private Button btnInsertar;

    public void cargarDatos(){

        alumnos.clear();
        for (int i =1;i<10;i++){
            alumnos.add(new Alumno("1234567"+i,"Nombre"+i,(i%2==0)?'H':'M'));

        }
        swipeRefreshLayout.setRefreshing(false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        alumnos=new ArrayList<>();


        recyclerView = (RecyclerView) findViewById(R.id.rv_alumnos);
        adaptador = new AdaptadorAlumnos(alumnos, this);
        recyclerView.setAdapter(adaptador);
        adaptador.setOnClickListener(this);
        layoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        etDni=findViewById(R.id.et_dni);
        etNombre=findViewById(R.id.et_nombre);
        rbSexoHombre =findViewById(R.id.rb_hombre);
        btnInsertar = findViewById(R.id.btn_insertar);
        btnInsertar.setOnClickListener(this);

        ItemTouchHelper.SimpleCallback myCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                switch (direction){
                    case ItemTouchHelper.RIGHT:
                        alumnos.remove(viewHolder.getAdapterPosition());
                        adaptador.notifyItemRemoved(viewHolder.getAdapterPosition());
                        break;
                    case ItemTouchHelper.LEFT:
                        Toast.makeText(MainActivity.this,"PACA EL ALTRE COSTAT",Toast.LENGTH_LONG).show();
                        adaptador.notifyDataSetChanged();
                        break;
                }

            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {


                Paint pincel = new Paint();
                pincel.setColor(Color.WHITE);
                int sizetext = getResources().getDimensionPixelSize(R.dimen.textsize);
                pincel.setTextSize(sizetext);

                //Vox
                if (dX > 0){
                    c.clipRect(viewHolder.itemView.getLeft(),viewHolder.itemView.getTop(),dX,viewHolder.itemView.getBottom());
                    if(dX< recyclerView.getWidth()/3)
                        c.drawColor(Color.GRAY);
                    else
                        c.drawColor(Color.RED);
                    Drawable delete = getDrawable(R.drawable.ic_delete_black_24dp);
                    delete.setBounds(viewHolder.itemView.getLeft(),viewHolder.itemView.getTop(),viewHolder.itemView.getHeight(),viewHolder.itemView.getBottom());
                    delete.draw(c);

                    pincel.setTextAlign(Paint.Align.LEFT);
                    c.drawText(getResources().getString(R.string.eliminar)
                            ,viewHolder.itemView.getHeight()
                            ,viewHolder.itemView.getBottom()-viewHolder.itemView.getHeight()/2+sizetext/2
                            ,pincel);
                }//ERC
                else if(dX < 0){

                    c.clipRect(viewHolder.itemView.getRight()+dX,viewHolder.itemView.getTop(),viewHolder.itemView.getRight(),viewHolder.itemView.getBottom());
                    if(Math.abs(dX)< recyclerView.getWidth()/3) {
                        c.drawColor(Color.GREEN);
                        //Snackbar.make(recyclerView, "Estic dins del else", Snackbar.LENGTH_SHORT).show();
                    }
                    else
                        c.drawColor(Color.BLUE);
                    Drawable edit = getDrawable(R.drawable.ic_edit_black_24dp);
                    edit.setBounds(viewHolder.itemView.getRight()-viewHolder.itemView.getHeight(),viewHolder.itemView.getTop(),viewHolder.itemView.getRight(),viewHolder.itemView.getBottom());
                    edit.draw(c);
                    String editarString = getResources().getString(R.string.editar);
                    Rect pepe = new Rect();
                pincel.getTextBounds(editarString,0,editarString.length(),pepe);
                    pincel.setTextAlign(Paint.Align.RIGHT);
                    c.drawText(editarString
                            ,viewHolder.itemView.getRight()-viewHolder.itemView.getHeight()
                            ,viewHolder.itemView.getBottom()-viewHolder.itemView.getHeight()/2+sizetext/2
                            ,pincel);
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

        if (view.getId()==R.id.btn_insertar){
            char sexo = (rbSexoHombre.isChecked()) ? 'H': 'M';
            Alumno nuevoAlumno = new Alumno(etDni.getText().toString(),etNombre.getText().toString(),sexo);
            alumnos.add(nuevoAlumno);

            adaptador.notifyDataSetChanged();
        }else{
            int posicion = recyclerView.getChildAdapterPosition(view);
            Alumno aSeleccionado = alumnos.get(posicion);
            Toast.makeText(MainActivity.this,"Alumno"+aSeleccionado.getNombre(),Toast.LENGTH_LONG).show();
        }
    }
}
