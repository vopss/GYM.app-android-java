package com.example.athleticsgymapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OpcijeActivity extends AppCompatActivity {

    private Button btnTreninzi, btnCenovnik, btnKalkulatorKalorija, btnOKlubuOpcije, btnFatGram,btnBMIKalkulator ,izlogujSe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcije);

        inicijalizacija();
        pozdraviKorisnika();


        //OVAKO PO METODAMA RAZDOVJTE HANDLERE ZA SVAKI BUTTON DA NE BI BILO NAGURANO SVE OVDE
        handleTreninzi();
        handleCenovnik();
        handleKalkulatorKalorija();
        oNama();
        handleFatGramCalculator();
        handleBMICalculator();
        handleIzlogujSe();

    }

    //OVDE INICIJALIZUJTE SVE BUTTONE I SVE STO VAM TREBA, MORAMO SVE DA RAZDVOJIMO PO METODAMA ZATO STO CE BITI PUNO OVDE!!
    private void inicijalizacija(){
        btnTreninzi=findViewById(R.id.btnTreninziOpcije);
        btnCenovnik = findViewById(R.id.btnCenovnik);
        btnKalkulatorKalorija =findViewById(R.id.btnKalkulatorKalorija);
        btnOKlubuOpcije =findViewById(R.id.btnOKlubuOpcije);
        btnFatGram = findViewById(R.id.btnFatGram);
        btnBMIKalkulator = findViewById(R.id.btnBMIKalkulator);
        izlogujSe =findViewById(R.id.izlogujSeOpcije);
    }

    private void handleTreninzi(){
        btnTreninzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcijeActivity.this,TreninziActivity.class);
                startActivity(intent);
            }
        });
    }

    private void handleCenovnik(){
        btnCenovnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcijeActivity.this,CenovnikActivity.class);
                startActivity(intent);
            }
        });
    }

    private void handleKalkulatorKalorija(){
        btnKalkulatorKalorija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcijeActivity.this,KalkulatorKalorijaActivity.class);
                startActivity(intent);
            }
        });
    }

    private void oNama() {
        btnOKlubuOpcije.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(OpcijeActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("Athletic's Gym\n" +
                        "24 godine tradicije\n" +
                        "Fitness klub \"Athletic's Gym\" je oformljen 1996. godine. Na samom početku rada, klub je radio kao sekcija za aerobik i body building pri sportskom centru Partizan – Čukarica na Banovom brdu, a od 20. januara 1998. godine kao samostalni sportski klub.\n" +
                        "\n" +
                        "Funkcionalnost\n" +
                        "Funkcionalnost kluba se ogleda u opremljenosti samog prostora, trenerima i pruženoj usluzi. U skladu sa ovim, sva 4 fitness studija raspolažu sa moderno dizajniranim enterijerom, ventilacijom, klimatizacijom, prijemnim delom, sportskim suplementima, svlačionicama sa ormarićima za garderobu, tuš kabinama, aerobik salom, profesionalnom Technogym Cardio i Strenght opremom i izuzetno prihvatljivim članarinama.\n" +
                        "\n" +
                        "Opremljenost\n" +
                        "Preko 60 Cardio Technogym mašina i preko 60 Technogym mašina sa opterećenjem i 25 klupa i sprava za vežbanje čine ovaj prostor potpunim, a vežbanje produktivnim.\n" +
                        "\n" +
                        "Stručnost\n" +
                        "Fakultet sporta i fizičke kulture i nekoliko viših škola za sportske trenere čine bazu za instruktore i personalne trenere. Kako bismo pratili svetske trendove kada je fitness u pitanju, trudimo se da prikupimo što više informacija putem konvencija, interneta, časopisa, stručne literature i od naših kolega iz zemalja gde je fitness izuzetno razvijen.\n" +
                        "\n" +
                        "Besplatni probni trening\n" +
                        "Probni treninzi za sve naše fitness programe su na raspolaganju potencijalnim članovima. Uverite se i sami da su programi koje mi realizujemo kvalitetni, zdravi i praktični i da je upravo to ono što Vam je zaista i potrebno!\n" +
                        "\n" +
                        "\n" +
                        "Postanite naš član i uživajte u napretku Vašeg duha i tela.");
                builder.setNegativeButton("PRESKOČI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("POSETI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO: prikazi websaj
                        Intent intent = new Intent(OpcijeActivity.this, WebsiteActivity.class);
                        intent.putExtra("url", "https://www.gym.rs/");
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });
    }

    private void pozdraviKorisnika(){
        Intent intent = getIntent();
        if(intent!=null){
            String kIme =intent.getStringExtra("korisnickoIme");
            if(kIme!=null){
                Toast.makeText(this, "Dobrodošao/la " + kIme , Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void handleFatGramCalculator(){
        btnFatGram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcijeActivity.this,FatGramActivity.class);
                startActivity(intent);
            }
        });
    }
    public void handleBMICalculator(){
        btnBMIKalkulator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcijeActivity.this,bmiActivity.class);
                startActivity(intent);
            }
        });
    }

    private void handleIzlogujSe(){
        izlogujSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcijeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


}