package com.example.toolbardeverdad;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MonoColgado extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.colgado_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.izquierda:
                startActivity(new Intent(MonoColgado.this, MonoBicicleta.class));
                return true;
            case R.id.derecha:
                startActivity(new Intent(MonoColgado.this, Main.class));
                return true;
            case R.id.buscar:
                startActivity(new Intent(MonoColgado.this, Buscar.class));
                return true;
            case R.id.perfil:
                startActivity(new Intent(MonoColgado.this, Perfil.class));
                return true;
        }
        return true;
    }
}
