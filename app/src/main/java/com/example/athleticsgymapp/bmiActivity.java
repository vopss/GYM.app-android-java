package com.example.athleticsgymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bmiActivity extends AppCompatActivity {

    private Button btnIzracunajBMI;
    private EditText visina, tezina;
    private TextView rezultatbmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        visina = (EditText) findViewById(R.id.txtVisinaBMI);
        tezina = (EditText) findViewById(R.id.txtTezinaBMI);
        rezultatbmi = (TextView) findViewById(R.id.rezultatbmi);
        btnIzracunajBMI = (Button) findViewById(R.id.btnIzračunajBMI);

        btnIzracunajBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                izracunajBMI();
            }
        });
    }

    private void izracunajBMI(){
        String visinaString=visina.getText().toString();
        String tezinaString=tezina.getText().toString();

        if (visinaString!=null && !"".equals(visinaString) && tezinaString!=null && !"".equals(tezinaString)){
            float visinaVrednost = Float.parseFloat(visinaString)/100;
            float tezinaVrednost = Float.parseFloat(tezinaString);
            float bmi=tezinaVrednost/(visinaVrednost*visinaVrednost);
            displayBMI(bmi);
        }
    }
    private void displayBMI(float bmi){

        String bmiLabel="";
        if (Float.compare(bmi, 15f)<=0){
              bmiLabel="-neuhranjen";
        }else if (Float.compare(bmi, 15f)>0 && Float.compare(bmi, 16f)<=0){
            bmiLabel="-veoma mršav";
        }else if (Float.compare(bmi, 16f)>0 && Float.compare(bmi, 18.5f)<=0){
            bmiLabel="-mršav";
        }else if (Float.compare(bmi, 18.5f)>0 && Float.compare(bmi, 20f)<=0){
            bmiLabel="-normalan";
        }else if (Float.compare(bmi, 20f)>0 && Float.compare(bmi, 25f)<=0){
            bmiLabel="-puniji";
        }else if (Float.compare(bmi, 25f)>0 && Float.compare(bmi, 30f)<=0){
            bmiLabel="-debeo";
        }else if (Float.compare(bmi, 30f)>0 && Float.compare(bmi, 35f)<=0){
            bmiLabel="-gojazan";
        }else if (Float.compare(bmi, 35f)>0 && Float.compare(bmi, 40f)<=0){
            bmiLabel="-smrtno ugrožen gojaznošću";
        }
        bmiLabel = bmi + '\n' + bmiLabel;
        rezultatbmi.setText(bmiLabel);
    }

}