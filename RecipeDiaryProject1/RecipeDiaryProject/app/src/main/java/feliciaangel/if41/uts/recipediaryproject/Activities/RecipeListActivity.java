package feliciaangel.if41.uts.recipediaryproject.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import feliciaangel.if41.uts.recipediaryproject.Service.APIService;
import feliciaangel.if41.uts.recipediaryproject.Adapter.MealViewAdapter;
import feliciaangel.if41.uts.recipediaryproject.R;
import feliciaangel.if41.uts.recipediaryproject.Utils.Constant;
import feliciaangel.if41.uts.recipediaryproject.Models.Meal;
import feliciaangel.if41.uts.recipediaryproject.Models.ResponseMeal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeListActivity extends AppCompatActivity {
    private RecyclerView rvListRecipe;
    private MealViewAdapter mealViewAdapter;
    private List<Meal> mealList = new ArrayList<>();
    private String categoriesStr;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        categoriesStr = getIntent().getExtras().getString(Constant.EXTRA_MEAL_CATEGORY_ID);
        tvTitle = findViewById(R.id.tv_categories_name);
        tvTitle.setText(categoriesStr);


        rvListRecipe = findViewById(R.id.rv_recipe_list);

        rvListRecipe.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mealViewAdapter = new MealViewAdapter(this::onItemMealClick);
        rvListRecipe.setAdapter(mealViewAdapter);

//        rvListRecipe.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        beefViewAdapter = new BeefViewAdapter();
//        rvListRecipe.setAdapter(beefViewAdapter);

//        ivChicken = findViewById(R.id.iv_photo);


        getMeal(categoriesStr);


    }

    private void onItemMealClick(Meal meal, int i) {
        Intent intent = new Intent(this, RecipeDetailActivity.class);
        intent.putExtra(Constant.EXTRA_MEAL_ID, meal.getIdMeal());
        startActivity(intent);
    }


    private void getMeal(String categoriesStr) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_MEAL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService api = retrofit.create(APIService.class);
        api.getMeal(categoriesStr).enqueue(new Callback<ResponseMeal>() {
            @Override
            public void onResponse(Call<ResponseMeal> call, Response<ResponseMeal> response) {
                if (response.code() == 200) {
                    mealList = response.body().getMeals();
                    mealViewAdapter.setData(mealList);
                } else {
                    Toast.makeText(RecipeListActivity.this, "Response code: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMeal> call, Throwable t) {
                System.out.println("Retrofit Error: " + t.getMessage());
                Toast.makeText(RecipeListActivity.this, "Retrofit Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}