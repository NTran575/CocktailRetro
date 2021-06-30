package com.dynamicdevz.cocktailretro.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dynamicdevz.cocktailretro.databinding.ActivityDrinkDetailsBinding;
import com.dynamicdevz.cocktailretro.model.data.Drink;
import com.dynamicdevz.cocktailretro.view.adapter.CocktailAdapter;

public class DrinkDetailsActivity extends AppCompatActivity {

    private ActivityDrinkDetailsBinding binding;
    private Drink drink;
    private CocktailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDrinkDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //resume
        drink=getIntent().getParcelableExtra("DRINK_DATA");
        if(drink != null){
            
            binding.titleView.setText(drink.getStrDrink());
            binding.instructView.setText(drink.getStrInstructions());
            binding.cateView.setText(drink.getStrCategory());
            binding.glassView.setText(drink.getStrGlass());
            if(drink.getStrIngredient1()!=null)
                if(drink.getStrMeasure1()!=null)
                    binding.Ing1View.setText(drink.getStrMeasure1()+" "+drink.getStrIngredient1());
                else
                    binding.Ing1View.setText(drink.getStrIngredient1());
            if(drink.getStrIngredient2()!=null)
                if(drink.getStrMeasure2()!=null)
                    binding.Ing2View.setText(drink.getStrMeasure2()+" "+drink.getStrIngredient2());
                else
                    binding.Ing2View.setText(drink.getStrIngredient2());
            if(drink.getStrIngredient3()!=null)
                if(drink.getStrMeasure3()!=null)
                    binding.Ing2View.setText(drink.getStrMeasure3()+" "+drink.getStrIngredient3());
                else
                    binding.Ing2View.setText(drink.getStrIngredient3());
            if(drink.getStrIngredient4()!=null)
                if(drink.getStrMeasure4()!=null)
                    binding.Ing2View.setText(drink.getStrMeasure4()+" "+drink.getStrIngredient4());
                else
                    binding.Ing2View.setText(drink.getStrIngredient4());
            if(drink.getStrIngredient5()!=null)
                if(drink.getStrMeasure5()!=null)
                    binding.Ing2View.setText(drink.getStrMeasure5()+" "+drink.getStrIngredient5());
                else
                    binding.Ing2View.setText(drink.getStrIngredient5());
            if(drink.getStrIngredient6()!=null)
                if(drink.getStrMeasure6()!=null)
                    binding.Ing2View.setText(drink.getStrMeasure6()+" "+drink.getStrIngredient6());
                else
                    binding.Ing2View.setText(drink.getStrIngredient6());
            if(drink.getStrIngredient7()!=null)
                if(drink.getStrMeasure7()!=null)
                    binding.Ing2View.setText(drink.getStrMeasure7()+" "+drink.getStrIngredient7());
                else
                    binding.Ing2View.setText(drink.getStrIngredient7());

        }
        binding.backButton.setOnClickListener(view ->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}