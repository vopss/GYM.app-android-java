package com.example.athleticsgymapp;

import android.content.Context;
import android.transition.TransitionManager;
import android.util.Log;
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

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class CenovnikRecycleReviewAdapter extends RecyclerView.Adapter<CenovnikRecycleReviewAdapter.ViewHolder>{

    private static final String TAG = "CenovnikRecycleReviewAd";

    private ArrayList<Cenovnik> cenovnici = new ArrayList<>();

    private Context mContext;

    public CenovnikRecycleReviewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_cenovnika,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.txtTreningUteretani.setText(cenovnici.get(position).getVrstaPaketaCenovnika());
        Glide.with(mContext)
                .asBitmap()
                .load(cenovnici.get(position).getUrl())
                .into(holder.imgTreningUTeretani);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, cenovnici.get(position).getVrstaPaketaCenovnika() + " uspešno izabran",Toast.LENGTH_SHORT).show();
            }
        });
        holder.txtCena.setText("Cena: " + cenovnici.get(position).getCena()+"din");

        if(cenovnici.get(position).isEsxpanded()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelativeLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
        }
        else {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelativeLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return cenovnici.size();
    }

    public void setCenovnici(ArrayList<Cenovnik> cenovnici) {
        this.cenovnici = cenovnici;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView imgTreningUTeretani;
        private TextView txtTreningUteretani;

        private ImageView downArrow, upArrow;
        private RelativeLayout expandedRelativeLayout;
        private TextView txtCena;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgTreningUTeretani = itemView.findViewById(R.id.slikaTreningUTeretani);
            txtTreningUteretani = itemView.findViewById(R.id.txtTreningUTeretani);

            downArrow = itemView.findViewById(R.id.btnDownArrow);
            upArrow = itemView.findViewById(R.id.btnUpArrow);
            expandedRelativeLayout = itemView.findViewById(R.id.expandedRelLayout);
            txtCena = itemView.findViewById(R.id.CenaText);


            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cenovnik cenovnik = cenovnici.get(getAdapterPosition());
                    cenovnik.setEsxpanded(!cenovnik.isEsxpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cenovnik cenovnik = cenovnici.get(getAdapterPosition());
                    cenovnik.setEsxpanded(!cenovnik.isEsxpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
