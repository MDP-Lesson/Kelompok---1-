package feliciaangel.if41.uts.recipediaryproject.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import feliciaangel.if41.uts.recipediaryproject.Service.APIService;
import feliciaangel.if41.uts.recipediaryproject.Adapter.MealCategoriesViewAdapter;
import feliciaangel.if41.uts.recipediaryproject.Models.MealCategories;
import feliciaangel.if41.uts.recipediaryproject.Models.ResponseMealCategories;
import feliciaangel.if41.uts.recipediaryproject.R;
import feliciaangel.if41.uts.recipediaryproject.Utils.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodActivity extends AppCompatActivity {

    private RecyclerView rvMenuCategories;
    private MealCategoriesViewAdapter mealCategoriesViewAdapter;
    private List<MealCategories> mealCategoriesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        rvMenuCategories = findViewById(R.id.rv_menu_categories);

        rvMenuCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mealCategoriesViewAdapter = new MealCategoriesViewAdapter(this::onItemCategoryClick);
        rvMenuCategories.setAdapter(mealCategoriesViewAdapter);

        getCategory();
    }

    private void getCategory() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_MEAL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService api = retrofit.create(APIService.class);
        api.getMealCategory().enqueue(new Callback<ResponseMealCategories>() {
            @Override
            public void onResponse(Call<ResponseMealCategories> call, Response<ResponseMealCategories> response) {
                mealCategoriesList = response.body().getCategories();
                mealCategoriesViewAdapter.setData(mealCategoriesList);
                Toast.makeText(FoodActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseMealCategories> call, Throwable t) {
                System.out.println("Retrofit Error: " + t.getMessage());
                Toast.makeText(FoodActivity.this, "Retrofit Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void onItemCategoryClick(MealCategories mealCategories, int i) {
        Intent intent = new Intent(this, RecipeListActivity.class);
        intent.putExtra(Constant.EXTRA_MEAL_CATEGORY_ID, mealCategories.getStrCategory());
        startActivity(intent);
    }

    @Override
    public void onBackPressed() { //tanda back
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}