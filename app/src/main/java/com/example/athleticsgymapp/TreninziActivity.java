package com.example.athleticsgymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class TreninziActivity extends AppCompatActivity {

    private RecyclerView listaTreninga;
    private ListaTreningaAdapter adapter;
    public static ArrayList<Trening> treninzi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treninzi);

        adapter= new ListaTreningaAdapter(this);
        listaTreninga = findViewById(R.id.listaTreninga);

        listaTreninga.setAdapter(adapter);
        listaTreninga.setLayoutManager(new LinearLayoutManager(this));

//        ArrayList<Trening> treninzi = new ArrayList<>();
        treninzi = new ArrayList<>();

        String sveVezbePush="Benč: 4 serije 8-10 ponavljanja" + "\n" +"Kosi benč: 4 serije 8-10 ponavljanja" + "\n" +"Propadanja: 4-6 serija, 10-12 ponavljanja"+"\n"+"Ramena bučice: 4 serije 8 ponavljanja";
        String sveVezbePull="Mrtvo dizanje: 4 serije 8-10 ponavljanja" + "\n" +"Lat mašina: 4 serije 8-10 ponavljanja" + "\n" +"Zgibovi: 4-6 serija, 10-12 ponavljanja"+"\n"+"Biceps bučice: 4 serije 8 ponavljanja";
        String sveVezbeNoge="Iskorak bučice: 4 serije 8-10 ponavljanja" + "\n" +"Čučanj sa šipkom: 4 serije 8-10 ponavljanja" + "\n" +"Otkorak: 4-6 serija, 10-12 ponavljanja"+"\n"+"Listovi podizanje: 4 serije 8 ponavljanja";
        String sveVezbeCardio="Čučanj skok: 4 serije 8-10 ponavljanja" + "\n" +"Kolena na grudi: 4 serije 8-10 ponavljanja" + "\n" +"Trčanje: 15 min"+"\n"+"Burpees: 4 serije 8 ponavljanja";

        treninzi.add(new Trening("Push ruke","Trening za ramena, grudi i triceps",sveVezbePush,"https://media.self.com/photos/5a592463d2071c0c445ebbe0/1:1/w_960,h_960,c_limit/kids-at-the-gym-with-parents.jpg"));
        treninzi.add(new Trening("Pull ruke","Trening za ledja i biceps",sveVezbePull,"https://www.muskimagazin.rs/storage/posts/gallery/2018/Jul/63322/rove-gym-prenosiva-sprava-koja-ce-vas-odrzavati-u-formi.jpg"));
        treninzi.add(new Trening("Ultimate noge","Kompletan trening za donji deo tela ",sveVezbeNoge,"https://www.picktime.com/webassets/img/industries/gym.jpg"));
        treninzi.add(new Trening("Explosive cardio","Trening za eksplozivnost i kondiciju",sveVezbeCardio,"https://fitathletic.com/wp-content/uploads/2019/02/Which-gym-machines-are-best-for-weight-loss.jpg"));
        adapter.setTreninzi(treninzi);

    }


    public static Trening nadjiTrening(String imeTreninga){//Mozda nije najbolja praksa da se radi na ovaj nacin, ali mislim da ce da zavrsi posao, da ne komplikujem kod ako ne mora
        for(Trening t:treninzi){
            if(t.getImeTreninga().equals(imeTreninga)){
                return t;
            }
        }
        return null;
    }
}