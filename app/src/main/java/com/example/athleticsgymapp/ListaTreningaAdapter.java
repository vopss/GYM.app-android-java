package com.example.athleticsgymapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListaTreningaAdapter extends RecyclerView.Adapter<ListaTreningaAdapter.ViewHolder>{

    private ArrayList<Trening> treninzi = new ArrayList<>();
    private Context context;//NE ZNAM DA LI CE MI OVO TREBATI

    public ListaTreningaAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_treninga,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imeTreninga.setText(treninzi.get(position).getImeTreninga());
        //Pokusacu da dodam sliku direktno, a ne sa neta
        Glide.with(context).
                asBitmap()
                .load(treninzi.get(position).getUrlSlike())
                .into(holder.slikaTreninga);
        
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,JedanTreningActivity.class);
                intent.putExtra("imeTreninga",treninzi.get(position).getImeTreninga());// Prosledjujem ime treninga preko intenta i na taj nacin cu naci konkretan trening
                context.startActivity(intent);//Ovde nisi u activitiju pa zato nemas direktan pristup ovoj metodi, ali mozemo preko context varijable da je iskoristimo

            }
        });

        holder.kratkiOpis.setText(treninzi.get(position).getKratkiOpis());


        if(treninzi.get(position).isProsireno()){
            TransitionManager.beginDelayedTransition(holder.parent);//Dodaje animaciju na spustanje i podizanje
            holder.rasirenRelLayout.setVisibility(View.VISIBLE);
            holder.donjaStrelica.setVisibility(View.GONE);
        }else{
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.rasirenRelLayout.setVisibility(View.GONE);
            holder.donjaStrelica.setVisibility(View.VISIBLE);
        }

        
    }

    @Override
    public int getItemCount() {
        return treninzi.size();
    }


    public void setTreninzi(ArrayList<Trening> treninzi) {
        this.treninzi = treninzi;
        notifyDataSetChanged();//Mislim da mi ni ovo nece trebati
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView slikaTreninga;
        private TextView imeTreninga;
        private ImageView donjaStrelica, gornjaStrelica;
        private RelativeLayout rasirenRelLayout;
        private TextView kratkiOpis;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.roditelj);
            slikaTreninga=itemView.findViewById(R.id.slikaTreninga);
            imeTreninga=itemView.findViewById(R.id.imeTreninga);
            donjaStrelica = itemView.findViewById(R.id.btnDonjaStrelica);
            gornjaStrelica =itemView.findViewById(R.id.btnGornjaStrelica);
            rasirenRelLayout=itemView.findViewById(R.id.rasirenRelativeLayout);
            kratkiOpis = itemView.findViewById(R.id.kratkiOpisTreninga);

            donjaStrelica.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Trening trening = treninzi.get(getAdapterPosition());
                    trening.setProsireno(!trening.isProsireno());
                    notifyItemChanged(getAdapterPosition());//Ovo ovde obavestava adapter da je doslo do promene, update-uje ga
                }
            });

            gornjaStrelica.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Trening trening = treninzi.get(getAdapterPosition());
                    trening.setProsireno(!trening.isProsireno());
                    notifyItemChanged(getAdapterPosition());//Ovo ovde obavestava adapter da je doslo do promene, update-uje ga
                }
            });

        }
    }


}
