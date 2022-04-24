package com.example.athleticsgymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FatGramActivity extends AppCompatActivity {

    private Button btnIzracunaj;
    private EditText txtProizvod, txtKalorije, txtMasti;
    private TextView txtOdgovor, txtWarningProizvod,txtWarningKalorije, txtWarningMasti;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fat_gram);
        inicijalizacija();
        IzracunajMasti();
    }

    private void inicijalizacija(){
        btnIzracunaj = findViewById(R.id.btnFatGramIzracunaj);
        txtProizvod = findViewById(R.id.txtProizvodFatGram);
        txtKalorije = findViewById(R.id.txtKalorijeFatGram);
        txtMasti = findViewById(R.id.txtMastiFatGram2);
        txtOdgovor = findViewById(R.id.txtOdgovorFatGram);
        txtWarningProizvod = findViewById(R.id.txtWarningFatGramProizvod);
        txtWarningKalorije = findViewById(R.id.txtWarningFatGramKalorije);
        txtWarningMasti = findViewById(R.id.txtWarningFatGramMasti);
    }

    private boolean ispravno(){
        boolean potvrda = true;
        if(txtProizvod.getText().toString().equals("")){
            txtWarningProizvod.setVisibility(View.VISIBLE);
            potvrda = false;
        }
        else{
            txtWarningProizvod.setVisibility(View.GONE);
        }
        if(txtKalorije.getText().toString().equals("")){
            txtWarningKalorije.setVisibility(View.VISIBLE);
            potvrda = false;
        }
        else{
            txtWarningKalorije.setVisibility(View.GONE);
        }
        if(txtMasti.getText().toString().equals("")){
            txtWarningMasti.setVisibility(View.VISIBLE);
            potvrda = false;
        }
        else{
            txtWarningMasti.setVisibility(View.GONE);
        }

        return potvrda;
    }

    private void izracunaj(){
        double kalorije = Double.parseDouble(txtKalorije.getText().toString());
        double masti = Double.parseDouble(txtMasti.getText().toString());
        double kalorijeIzMasti = masti*9;
        double procenat = kalorijeIzMasti/kalorije;

        if(kalorijeIzMasti>kalorije){
            txtOdgovor.setText("Pogrešan unos podataka!");
        }
        else{
            if(kalorijeIzMasti<(30/100)*kalorije){
                txtOdgovor.setText("zanemarujuće mali");
            }

            txtOdgovor.setText(String.valueOf(procenat));
        }

    }

    private void IzracunajMasti(){
        btnIzracunaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ispravno()){
                    izracunaj();
                }
            }
        });
    }

}