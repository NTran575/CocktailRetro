package com.dynamicdevz.cocktailretro.model.network;

import com.dynamicdevz.cocktailretro.model.data.CocktailResponse;
import com.dynamicdevz.cocktailretro.model.data.Drink;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.dynamicdevz.cocktailretro.util.Constants.*;

public class CocktailRetrofit {
    private DrinkService drinkService = createRetrofit().create(DrinkService.class);
    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }
    public Call<CocktailResponse> getSearchResults(String query){
        return drinkService.searchDrink(query);
    }
    interface DrinkService {

        @GET(END_POINT)
        public Call<CocktailResponse> searchDrink(@Query(SEARCH_QUERY)String query);

    }
}
