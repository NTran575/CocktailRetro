package com.dynamicdevz.cocktailretro.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import com.dynamicdevz.cocktailretro.R;
import com.dynamicdevz.cocktailretro.databinding.ActivityMainBinding;
import com.dynamicdevz.cocktailretro.model.data.CocktailResponse;
import com.dynamicdevz.cocktailretro.model.data.Drink;
import com.dynamicdevz.cocktailretro.model.network.CocktailRetrofit;
import com.dynamicdevz.cocktailretro.view.adapter.CocktailAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements CocktailAdapter.DrinkDelegate{

    private ActivityMainBinding binding;
    private CocktailAdapter adapter = new CocktailAdapter(this);

    private CocktailRetrofit cocktailRetrofit = new CocktailRetrofit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.drinkRecyclerview.setAdapter(adapter);

        cocktailRetrofit.getSearchResults("margarita")
                .enqueue(new Callback<CocktailResponse>() {

                    @Override
                    public void onResponse(Call<CocktailResponse> call, Response<CocktailResponse> response) {
                        Log.d("TAG_X"," "+call.request().url());
                        adapter.setResults(response.body().getDrinks());

                    }

                    @Override
                    public void onFailure(Call<CocktailResponse> call, Throwable t) {
                        Log.d("TAG_X"," OOPS :< "+call.request().url());

                    }
                });
    }
    //from adapter
    @Override
    public void selectDrink(Drink drink) {
        Toast.makeText(this, drink.getStrDrink(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, DrinkDetailsActivity.class);
        intent.putExtra("DRINK_DATA", drink);
        startActivity(intent);
    }


}