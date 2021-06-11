package com.example.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.R;
import com.example.entities.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PalabraViewHolder> {
     public List<Pokemon> pokemones = new ArrayList<>();
    public PokemonAdapter (List<Pokemon>pokemones){
        super();
        this.pokemones = pokemones;
    }
    @Override
    public PalabraViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon,parent,false);
        return new PalabraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PalabraViewHolder holder, int position) {
        View view = holder.itemView;
        Pokemon pokemon =pokemones.get(position);
        TextView pkNombre = view.findViewById(R.id.pkNombre);
        TextView pkTipo= view.findViewById(R.id.pkTipo);
        ImageView ig = view.findViewById(R.id.imagenViewPokemon);

        pkNombre.setText(pokemon.nombre);
        pkTipo.setText (pokemon.tipo);
        Picasso.get().load(pokemon.url_imagen).into(ig);

    }

    @Override
    public int getItemCount() {
        return pokemones.size();
    }

    public  class PalabraViewHolder extends RecyclerView.ViewHolder{

        public PalabraViewHolder( View itemView) {
            super(itemView);
        }
    }

}
