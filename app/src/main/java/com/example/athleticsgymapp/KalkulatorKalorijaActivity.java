package com.example.athleticsgymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class KalkulatorKalorijaActivity extends AppCompatActivity {

    private Button izracunajBtn;
    private EditText txtVisina,txtTezina,txtGodine;
    private RadioGroup polGrupa;
    private RadioButton opcijaMuski,opcijaZenski;
    private TextView txtRezultat,warningGodine,warningVisina,warningTezina;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator_kalorija);

        inicijalizuj();

        handlujButton();


    }


    private void inicijalizuj(){
        izracunajBtn = findViewById(R.id.btnIzracunajKalkulatorKalorija);
        txtVisina = findViewById(R.id.visinaKalkulatorKalorija);
        txtTezina=findViewById(R.id.tezinaKalkulatorKalorija);
        txtGodine=findViewById(R.id.godineKalkulatorKalorija);
        polGrupa=findViewById(R.id.radioGroupKalkulatorKalorija);
        txtRezultat=findViewById(R.id.rezultatKalkulatorKalorija);
        warningGodine=findViewById(R.id.warningGodineKalkulatorKalorija);
        warningTezina=findViewById(R.id.warningTezinaKalkulatorKalorija);
        warningVisina=findViewById(R.id.warningVisinaKalkulatorKalorija);
        opcijaMuski=(RadioButton) findViewById(R.id.radioBtnMuskiKalkulatorKalorija);
        opcijaZenski=(RadioButton)findViewById(R.id.radioBtnZenskiKalkulatorKalorija);
    }


    private void handlujButton(){
        izracunajBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jeValidno()){
                    izracunajRezultat();
                }

            }
        });

    }

    private boolean jeValidno(){
        boolean potvrda= true;
       if(txtGodine.getText().toString().equals("")){
           warningGodine.setVisibility(View.VISIBLE);
           potvrda=false;
       }else{
           warningGodine.setVisibility(View.GONE);
       }
        if(txtVisina.getText().toString().equals("")){
            warningVisina.setVisibility(View.VISIBLE);
            potvrda=false;
        }else{
            warningVisina.setVisibility(View.GONE);
        }
        if(txtTezina.getText().toString().equals("")){
            warningTezina.setVisibility(View.VISIBLE);
            potvrda=false;
        }else{
            warningTezina.setVisibility(View.GONE);
        }
       return potvrda;
    }

    private void izracunajRezultat(){
        int godine = Integer.parseInt(txtGodine.getText().toString());
        int visina = Integer.parseInt(txtVisina.getText().toString());
        int tezina = Integer.parseInt(txtTezina.getText().toString());
        double rezultat= 0;
        if(opcijaMuski.isChecked()){
            rezultat = 10*tezina+6.25*visina-5*godine+5;
        }else{
            rezultat=10*tezina+6.25*visina-5*godine-161;
        }
        int zaokruzenRezultat = (int) Math.round(rezultat);
        txtRezultat.setText("Dnevne potrebe: " +  String.valueOf(zaokruzenRezultat) + " kcal");
    }


}