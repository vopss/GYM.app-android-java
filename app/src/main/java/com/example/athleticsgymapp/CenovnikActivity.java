package com.example.athleticsgymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CenovnikActivity extends AppCompatActivity {
    private RecyclerView CenovnikRecycleReview;
    private CenovnikRecycleReviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cenovnik);

        adapter = new CenovnikRecycleReviewAdapter(this);
        CenovnikRecycleReview = findViewById(R.id.CenovnikRecycleReview);

        CenovnikRecycleReview.setAdapter(adapter);
        CenovnikRecycleReview.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Cenovnik> cenovnici = new ArrayList<>();

        cenovnici.add(new Cenovnik("Trening u teretani","1900","https://body.ba/pictures/article/pages/1563272926-vjezbanje-poboljsava-mozdanu-funkciju.jpg",false));
        cenovnici.add(new Cenovnik("SPA","2100","https://lepotica.rs/wp-content/uploads/2020/08/Untitled-design214-660x400.png",false));
        cenovnici.add(new Cenovnik("Athletic 360","2400","https://www.ampyourworkout.com/wp-content/uploads/2016/06/GYM_Dumbells.png",false));
        adapter.setCenovnici(cenovnici);


    }
}