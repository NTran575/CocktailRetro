package com.dynamicdevz.cocktailretro.view.adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dynamicdevz.cocktailretro.databinding.DrinkListItemBinding;
import com.dynamicdevz.cocktailretro.model.data.Drink;
import com.dynamicdevz.cocktailretro.view.DrinkDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class CocktailAdapter extends RecyclerView.Adapter<CocktailAdapter.CocktailViewHolder>{

    public interface DrinkDelegate{
        void selectDrink(Drink drink);
    }
    public CocktailAdapter(DrinkDelegate drinkDelegate){
        this.drinkDelegate =drinkDelegate;
    }
    @NonNull
    @Override
    public CocktailViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        DrinkListItemBinding binding = DrinkListItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new CocktailViewHolder(binding);
    }
    private DrinkDelegate drinkDelegate;

    @Override
    public void onBindViewHolder(@NonNull CocktailAdapter.CocktailViewHolder holder, int position) {
        Drink result = results.get(position);
        Glide.with(holder.itemView)
                .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
                .load(result.getStrDrinkThumb())
                .into(holder.binding.posterImageview);
        holder.binding.synopsisTextview.setText(result.getStrInstructions());
        holder.binding.titleTextview.setText(result.getStrDrink());

        holder.binding.posterImageview.setOnClickListener(v ->{

            drinkDelegate.selectDrink(result);
        });



    }
    private List<Drink> results = new ArrayList<>();

    public void setResults(List<Drink> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class CocktailViewHolder extends RecyclerView.ViewHolder{
        //ImageView poster;
        DrinkListItemBinding binding;
        public CocktailViewHolder(DrinkListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            //poster = itemView.findViewById(R.id.poster_imageview)

        }
    }
}
