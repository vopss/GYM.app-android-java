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
                        "Fitness klub \"Athletic's Gym\" je oformljen 1996. godine. Na samom po??etku rada, klub je radio kao sekcija za aerobik i body building pri sportskom centru Partizan ??? ??ukarica na Banovom brdu, a od 20. januara 1998. godine kao samostalni sportski klub.\n" +
                        "\n" +
                        "Funkcionalnost\n" +
                        "Funkcionalnost kluba se ogleda u opremljenosti samog prostora, trenerima i pru??enoj usluzi. U skladu sa ovim, sva 4 fitness studija raspola??u sa moderno dizajniranim enterijerom, ventilacijom, klimatizacijom, prijemnim delom, sportskim suplementima, svla??ionicama sa ormari??ima za garderobu, tu?? kabinama, aerobik salom, profesionalnom Technogym Cardio i Strenght opremom i izuzetno prihvatljivim ??lanarinama.\n" +
                        "\n" +
                        "Opremljenost\n" +
                        "Preko 60 Cardio Technogym ma??ina i preko 60 Technogym ma??ina sa optere??enjem i 25 klupa i sprava za ve??banje ??ine ovaj prostor potpunim, a ve??banje produktivnim.\n" +
                        "\n" +
                        "Stru??nost\n" +
                        "Fakultet sporta i fizi??ke kulture i nekoliko vi??ih ??kola za sportske trenere ??ine bazu za instruktore i personalne trenere. Kako bismo pratili svetske trendove kada je fitness u pitanju, trudimo se da prikupimo ??to vi??e informacija putem konvencija, interneta, ??asopisa, stru??ne literature i od na??ih kolega iz zemalja gde je fitness izuzetno razvijen.\n" +
                        "\n" +
                        "Besplatni probni trening\n" +
                        "Probni treninzi za sve na??e fitness programe su na raspolaganju potencijalnim ??lanovima. Uverite se i sami da su programi koje mi realizujemo kvalitetni, zdravi i prakti??ni i da je upravo to ono ??to Vam je zaista i potrebno!\n" +
                        "\n" +
                        "\n" +
                        "Postanite na?? ??lan i u??ivajte u napretku Va??eg duha i tela.");
                builder.setNegativeButton("PRESKO??I", new DialogInterface.OnClickListener() {
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
                Toast.makeText(this, "Dobrodo??ao/la " + kIme , Toast.LENGTH_SHORT).show();
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