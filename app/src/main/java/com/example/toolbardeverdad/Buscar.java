package com.example.toolbardeverdad;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class Buscar extends AppCompatActivity {
    List<String> monos = new ArrayList<>();
    List<Integer> gifs = new ArrayList<>();
    @Override
    protected void onCreate(Bundle onSavedInstanceState){
        monos.add("Bicicleta");
        monos.add("Platano");
        monos.add("Colgado");
        monos.add("Familia");
        monos.add("Comiendo");
        gifs.add(R.drawable.bicicleta);
        gifs.add(R.drawable.platano);
        gifs.add(R.drawable.hanging);
        gifs.add(R.drawable.familia);
        gifs.add(R.drawable.comiendo);

        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.buscar_layout);
        Button buscar = (Button) findViewById(R.id.search);
        EditText nombre = (EditText) findViewById(R.id.busqueda);
        ImageView imagen = (ImageView) findViewById(R.id.trobat);
        GifImageView gif = (GifImageView) findViewById(R.id.gifMono);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean trobat = false;
                int pos = 0;
                for (int i = 0; i < monos.size(); i++){
                    if (nombre.getText().toString().equalsIgnoreCase(monos.get(i))){
                        trobat = true;
                        pos = i;
                    }
                }
                if (trobat){
                    gif.setImageResource(gifs.get(pos));
                    gif.setVisibility(View.VISIBLE);
                }
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        Toolbar cardView = (Toolbar) findViewById(R.id.cardviewbar);
        cardView.inflateMenu(R.menu.menu_cardview);
        GifImageView gifCard = (GifImageView) findViewById(R.id.gifCard);
        cardView.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.uno:
                        gifCard.setImageResource(R.drawable.nadar);
                        return true;
                    case R.id.dos:
                        gifCard.setImageResource(R.drawable.gangsta);
                        return true;
                }
                return true;
            }
        });
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
            case R.id.derecha:
                startActivity(new Intent(Buscar.this, MonoFamilia.class));
                return true;
            case R.id.izquierda:
                startActivity(new Intent(Buscar.this, MonoColgado.class));
                return true;
            case R.id.buscar:
                startActivity(new Intent(Buscar.this, Buscar.class));
                return true;
            case R.id.perfil:
                startActivity(new Intent(Buscar.this, Perfil.class));
                return true;
        }
        return true;
    }
}
