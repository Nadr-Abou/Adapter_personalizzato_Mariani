package com.example.listanomipersona3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Dettaglio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettaglio);

        TextView nome = findViewById(R.id.mioNome);
        TextView cognome = findViewById(R.id.mioCognome);
        Button finishButton = findViewById(R.id.finishButton);
        Button bottoneMail = findViewById(R.id.buttonEmail);

        Persona persona = getIntent().getSerializableExtra("persona",Persona.class);
        nome.setText(persona.getNome());
        cognome.setText(persona.getCognome());

        finishButton.setOnClickListener( v -> {
            Intent result = new Intent();
            result.putExtra("nomeEdited",((EditText) findViewById(R.id.editTextText)).getText());
            setResult(200,result);
            finish();
        });
        bottoneMail.setOnClickListener(v -> {
            String email = "mailto:nadrabou1@gmail.com";
            Intent intent = new Intent(Intent.ACTION_SENDTO);
        });
    }

}