package com.example.athleticsgymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import static com.example.athleticsgymapp.MainActivity.korisnici;

public class RegistracijaActivity extends AppCompatActivity {

    private EditText korisnickoImeTxt, emailTxt, lozinkaTxt, potvrdaLozinkeTxt;
    private TextView warningKIme, warningEmail, warningLozinka, warningPotvrdaLozinke;
    private RadioGroup pol;
    private Button btnRegistracija;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registracija);

        inicijalizuj();

        btnRegistracija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jeUneoSve()){
//TODO: Ovde treba oko onog log in dela da odradim, tj da napravim korisnika, unesem u listu i serijalizujem, ako ne bude radilo jer ne znamo baze, samo cemo zabraniti log in button

                    unesiKorisnika();

                    sacuvajKorisnikaUBazu();

                    Intent intent = new Intent(RegistracijaActivity.this,OpcijeActivity.class);
                    startActivity(intent);
                }
            }
        });




    }

    //Ovako ga muljam zato sto zelim da kad kasnije uneses to neko polje, onda to crveno nestane, a pojavi se crveno za ostala koja nisu popunjena!
    //Ako budem imao neki bag, iskuliracu to, pa cu da odradim na jednostavniji nacin.
//    TODO:PROVERI DA LI RADI!
    private boolean jeUneoSve(){
        boolean potvrda =true;
        if(korisnickoImeTxt.getText().toString().equals("")){
            warningKIme.setVisibility(View.VISIBLE);
            potvrda=false;
        }else{
            warningKIme.setVisibility(View.GONE);
        }

        if(emailTxt.getText().toString().equals("")){
            warningEmail.setVisibility(View.VISIBLE);
            potvrda=false;
        }else{
            warningEmail.setVisibility(View.GONE);
        }
        if(lozinkaTxt.getText().toString().equals("")){
            warningLozinka.setVisibility(View.VISIBLE);
           potvrda=false;
        }else{
            warningLozinka.setVisibility(View.GONE);
        }
        if(potvrdaLozinkeTxt.getText().toString().equals("")){
            warningPotvrdaLozinke.setText("Molimo Vas unesite potvrdu lozinke");
            warningPotvrdaLozinke.setVisibility(View.VISIBLE);
            potvrda=false;
        }else{
            warningPotvrdaLozinke.setVisibility(View.GONE);
        }
        if( !lozinkaTxt.getText().toString().equals(potvrdaLozinkeTxt.getText().toString())  ){
            warningPotvrdaLozinke.setText("Lozinke se ne poklapaju.");
            warningPotvrdaLozinke.setVisibility(View.VISIBLE);
            potvrda=false;
        }else{
            warningPotvrdaLozinke.setVisibility(View.GONE);
        }


        return potvrda;
    }


    private void inicijalizuj(){
        korisnickoImeTxt = findViewById(R.id.korisnickoImeRegistracija);
        emailTxt = findViewById(R.id.emailRegistracija);
        lozinkaTxt = findViewById(R.id.lozinkaRegistracija);
        potvrdaLozinkeTxt =findViewById(R.id.potvrdaLozinkeRegistracija);
        warningKIme =findViewById(R.id.warningKorisnickoIme);
        warningEmail=findViewById(R.id.warningEmail);
        warningLozinka=findViewById(R.id.warningLozinka);
        warningPotvrdaLozinke=findViewById(R.id.warningPonovnaLozinka);
        pol = findViewById(R.id.polRadioGroupRegistracija);
        btnRegistracija = findViewById(R.id.btnRegistrujSeRegistracija);
    }

    private void unesiKorisnika(){
        String kIme = korisnickoImeTxt.getText().toString();
        String email = emailTxt.getText().toString();
        String lozinka = lozinkaTxt.getText().toString();
//        TODO:Zavrsi ovo za pol kad proveris dal radi lepo, to nije sad toliko ni bitno
        String pol = "nepoznat";
        Korisnik k = new Korisnik(kIme,email,lozinka,pol);
        korisnici.add(k);
    }
    private void sacuvajKorisnikaUBazu(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",MODE_PRIVATE);//Ovde isto bolje napraviti static promenljive za ove key-eve
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(korisnici);
        editor.putString("lista korisnika",json);
//        editor.apply();
        editor.commit();
    }

}