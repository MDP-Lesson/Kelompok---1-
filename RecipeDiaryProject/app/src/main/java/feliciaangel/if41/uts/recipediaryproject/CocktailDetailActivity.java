package feliciaangel.if41.uts.recipediaryproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import feliciaangel.if41.uts.recipediaryproject.Adapter.CocktailDetailViewAdapter;
import feliciaangel.if41.uts.recipediaryproject.Models.CocktailDetail;
import feliciaangel.if41.uts.recipediaryproject.Models.ResponseCocktailDetail;
import feliciaangel.if41.uts.recipediaryproject.Utils.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CocktailDetailActivity extends AppCompatActivity {

    private TextView tvCocktail, tvAlcoholic, tvGlass, tvIngridients, tvInstructions;
    private ImageView ivPhoto;
    private RecyclerView rvCocktailDetail;
    private CocktailDetailViewAdapter cocktailDetailViewAdapter;
    private List<CocktailDetail> cocktailDetails = new ArrayList<>();
    private String drinksId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail_detail);

        drinksId = getIntent().getExtras().getString(Constant.EXTRA_COCKTAIL_ID);

        tvCocktail = findViewById(R.id.tv_cocktail);
        tvAlcoholic = findViewById(R.id.tv_alcoholic);
        tvGlass = findViewById(R.id.tv_glass);
        tvIngridients = findViewById(R.id.tv_ingredients);
        tvInstructions = findViewById(R.id.tv_instructions);
        ivPhoto = findViewById(R.id.iv_photo);
        rvCocktailDetail = findViewById(R.id.rv_detail_cocktail);

        rvCocktailDetail.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        cocktailDetailViewAdapter = new CocktailDetailViewAdapter(this::onCocktailDetailClick);
        rvCocktailDetail.setAdapter(cocktailDetailViewAdapter);

        getCocktailDetail(drinksId);

    }

    private void onCocktailDetailClick(CocktailDetail cocktailDetail, int i) {
        Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show();
    }

    private void getCocktailDetail(String DrinkId){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_COCKTAIL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService api = retrofit.create(APIService.class);
        api.getCocktailDetail(drinksId).enqueue(new Callback<ResponseCocktailDetail>() {
            @Override
            public void onResponse(Call<ResponseCocktailDetail> call, Response<ResponseCocktailDetail> response) {
                cocktailDetails = response.body().getDrinks();
                cocktailDetailViewAdapter.setData(cocktailDetails);
                Toast.makeText(CocktailDetailActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseCocktailDetail> call, Throwable t) {
                System.out.println("Retrofit Error: " + t.getMessage());
                Toast.makeText(CocktailDetailActivity.this, "Retrofit Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}