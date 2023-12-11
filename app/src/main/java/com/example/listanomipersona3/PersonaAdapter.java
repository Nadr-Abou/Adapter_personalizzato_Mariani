package com.example.listanomipersona3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PersonaAdapter extends ArrayAdapter<Persona> {
    public  PersonaAdapter(Context context, ArrayList<Persona> persone){
        super(context, 0, persone);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Persona persona = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.persona_layout,parent,false);
        }else{
            Log.d("getView","ricicla la view");
        }

        TextView nome = convertView.findViewById(R.id.textNome);
        TextView cognome = convertView.findViewById(R.id.textCognome);

        if(persona.getNome() != null)
            nome.setText(persona.getNome());
        cognome.setText(persona.getCognome());

        return convertView;
    }


}
