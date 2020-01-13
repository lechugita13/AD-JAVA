package com.example.appbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Josep Friki");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new:
                Toast.makeText(this, "Menu nuevo pulsado", Toast.LENGTH_SHORT).show();
            case R.id.action_search:
                Toast.makeText(this, "Menu busqueda pulsado", Toast.LENGTH_SHORT).show();

            case R.id.action_settings:
                Toast.makeText(this, "Menu opciones pulsado", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
