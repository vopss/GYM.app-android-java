package com.example.athleticsgymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.athleticsgymapp.MainActivity.korisnici;

public class PrijavaActivity extends AppCompatActivity {

    private Button btnPrijava;
    private EditText txtKorisnickoIme, txtLozinka;
    private TextView warningKorisnickoIme ,warningLozinka;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prijava);

        inicijalizuj();
        handlujBtn();

    }


    private void inicijalizuj(){
        btnPrijava = findViewById(R.id.btnLogIn);
        txtKorisnickoIme=findViewById(R.id.korisnickoImeLogIn);
        txtLozinka=findViewById(R.id.lozinkaLogIn);
        warningKorisnickoIme = findViewById(R.id.warningKorisnickoImeLogIn);
        warningLozinka=findViewById(R.id.warningLozinkaLogIn);
    }


    private void handlujBtn(){
        btnPrijava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ispisiTrenutnuListu();
                if(jeSveUneo()){
//TODO:Prosledi ime intentom i pozdravi ga u sledecem aktivitiju
                    if(postojiUBazi()){
                        Intent intent =new Intent(PrijavaActivity.this,OpcijeActivity.class);
                        intent.putExtra("korisnickoIme",txtKorisnickoIme.getText().toString());// Prosledjujem ime korisnika kako bih ga pozdravio
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private void ispisiTrenutnuListu(){
        for (Korisnik k:korisnici){
            System.out.println(k.getKorisnickoIme());
        }
    }


    private boolean jeSveUneo(){
        boolean potvrda=true;
        if(txtKorisnickoIme.getText().toString().equals("")){
            warningKorisnickoIme.setText("Molimo Vas unesite korisničko ime.");
            warningKorisnickoIme.setVisibility(View.VISIBLE);
            potvrda=false;
        }else{
            warningKorisnickoIme.setVisibility(View.GONE);
        }
        if(txtLozinka.getText().toString().equals("")){
            warningLozinka.setText("Molimo Vas unesite lozinku.");
            warningLozinka.setVisibility(View.VISIBLE);
            potvrda=false;
        }else{
            warningLozinka.setVisibility(View.GONE);
        }
        return potvrda;
    }

    private boolean postojiUBazi(){
        String korisnickoIme = txtKorisnickoIme.getText().toString();
        String lozinka = txtLozinka.getText().toString();
        for (Korisnik k: korisnici){
            if(k.getKorisnickoIme().equals(korisnickoIme) && k.getLozinka().equals(lozinka)){
                return true;
            }
        }
//        warningLozinka.setText("Pogrešno uneto korisničko ime ili lozinka. Pokušajte ponovo.");
//        warningLozinka.setText(View.VISIBLE);
        Toast.makeText(this, "Pogrešno uneti podaci. Pokušajte ponovo.", Toast.LENGTH_SHORT).show();
        return false;
    }



}