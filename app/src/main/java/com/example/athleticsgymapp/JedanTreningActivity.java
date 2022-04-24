package com.example.athleticsgymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class JedanTreningActivity extends AppCompatActivity {

    private ImageView slikaTreninga;
    private TextView imeTreninga;
    private TextView dugiOpisTreninga;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jedan_trening);

        inicijalizuj();

        Intent intent= getIntent();
        if(intent!=null){
            String imeZaPronalazenje= intent.getStringExtra("imeTreninga");//Bilo bi bolje napraviti konstantu nego hardkodovati ovako, uradicu to posle
            if (imeZaPronalazenje!=null){
                Trening pronadjeniTrening = TreninziActivity.nadjiTrening(imeZaPronalazenje);
                if(pronadjeniTrening!=null){
                    postaviPodatke(pronadjeniTrening);
                }
            }
        }
    }

    private void inicijalizuj(){
        slikaTreninga=findViewById(R.id.slikaJedanTrening);
        imeTreninga = findViewById(R.id.imeTreningaJedanTrening);
        dugiOpisTreninga=findViewById(R.id.dugiOpisJedanTrening);
    }

    private void postaviPodatke(Trening trening){
        imeTreninga.setText(trening.getImeTreninga());
        dugiOpisTreninga.setText(trening.getSveVezbe());
        Glide.with(this)
                .asBitmap().load(trening.getUrlSlike())
                .into(slikaTreninga);
    }



}