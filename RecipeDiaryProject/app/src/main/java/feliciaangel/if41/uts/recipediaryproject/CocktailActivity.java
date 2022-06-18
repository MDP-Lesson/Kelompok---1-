package feliciaangel.if41.uts.recipediaryproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import feliciaangel.if41.uts.recipediaryproject.Adapter.CocktailViewAdapter;
import feliciaangel.if41.uts.recipediaryproject.Models.Cocktail;
import feliciaangel.if41.uts.recipediaryproject.Models.ResponseCocktail;
import feliciaangel.if41.uts.recipediaryproject.Utils.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CocktailActivity extends AppCompatActivity {

    private RecyclerView rvCocktailCategories;
    private CocktailViewAdapter cocktailViewAdapter;
    private List<Cocktail> cocktailCategories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail);

        rvCocktailCategories = findViewById(R.id.rv_cocktail_categories);

        rvCocktailCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        cocktailViewAdapter = new CocktailViewAdapter(this::onCocktailCategoriesClick);
        rvCocktailCategories.setAdapter(cocktailViewAdapter);

        getCategory();
    }

    private void onCocktailCategoriesClick(Cocktail cocktail, int i) {
        Intent intent = new Intent(this, CocktailDetailActivity.class);
        intent.putExtra(Constant.EXTRA_COCKTAIL_ID, cocktail.getIdDrinks());
        startActivity(intent);
    }

    private void getCategory() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_COCKTAIL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService api = retrofit.create(APIService.class);
        api.getDrinks().enqueue(new Callback<ResponseCocktail>() {
            @Override
            public void onResponse(Call<ResponseCocktail> call, Response<ResponseCocktail> response) {
                cocktailCategories = response.body().getDrinks();
                cocktailViewAdapter.setData(cocktailCategories);
                Toast.makeText(CocktailActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseCocktail> call, Throwable t) {
                System.out.println("Retrofit Error: " + t.getMessage());
                Toast.makeText(CocktailActivity.this, "Retrofit Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

