package com.example.listanomipersona3;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    ArrayList<Persona> persone = new ArrayList<>(Arrays.asList(new Persona("nadr", "abou"), new Persona("nadr", "abou"), new Persona("nadr", "abou"), new Persona("nadr", "abou"), new Persona("nadr", "abou"), new Persona("nadr", "abou"), new Persona("nadr", "abou"), new Persona("nadr", "abou"), new Persona("nadr", "abou"), new Persona("nadr", "abou"), new Persona("nadr", "abou"), new Persona("nadr", "abou"), new Persona("nadr", "abou"), new Persona("nadr", "abou"), new Persona("nadr", "abou"), new Persona("nadr", "abou")));
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView miaLista = findViewById(R.id.miaLista);
        PersonaAdapter listaNomi = new PersonaAdapter(
                MainActivity.this,
                persone);
        miaLista.setAdapter(listaNomi);
        miaLista.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent dettaglio = new Intent(MainActivity.this, Dettaglio.class);
            dettaglio.putExtra("persona",persone.get(i));
            activityResultLauncher.launch(dettaglio);

        });
    }

}