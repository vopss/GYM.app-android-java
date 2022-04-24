package com.example.athleticsgymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button registrujSe, prijaviSe;
    public static ArrayList<Korisnik> korisnici;//Trebalo bi koristiti Singleton pattern za ovakve situacije kako bi se osiguralo da ce biti napravljena samo jedna instanca.
    //Uradicu to ako budem imao vremena, ali to je bolja praksa svakako.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ucitajListuKorisnika();
        registrujSe = findViewById(R.id.btnRegistracijaPocetna);
        prijaviSe = findViewById(R.id.btnPrijavaPocetna);


        registrujSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegistracijaActivity.class);
                startActivity(intent);
            }
        });


        prijaviSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PrijavaActivity.class);
                startActivity(intent);
            }
        });


    }

    private void ucitajListuKorisnika(){
        SharedPreferences sharedPreferences =getSharedPreferences("shared preferences",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("lista korisnika",null);
        Type type = new TypeToken<ArrayList<Korisnik>>(){}.getType();
        korisnici=gson.fromJson(json,type);

        if(korisnici==null){
            korisnici=new ArrayList<>();
        }
    }


}