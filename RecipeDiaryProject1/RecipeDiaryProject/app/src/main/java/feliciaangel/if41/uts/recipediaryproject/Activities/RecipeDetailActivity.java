package feliciaangel.if41.uts.recipediaryproject.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import feliciaangel.if41.uts.recipediaryproject.Service.APIService;
import feliciaangel.if41.uts.recipediaryproject.Adapter.RecipeDetailViewAdapter;
import feliciaangel.if41.uts.recipediaryproject.Models.MealsDetail;
import feliciaangel.if41.uts.recipediaryproject.Models.ResponseMealsDetail;
import feliciaangel.if41.uts.recipediaryproject.R;
import feliciaangel.if41.uts.recipediaryproject.Utils.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeDetailActivity extends AppCompatActivity {
    private TextView tvMeal, tvCategory, tvArea, tvIngridients, tvInstructions,tvTags;
    private ImageView ivPhoto;
    private RecyclerView rvDetailRecipe;
    private RecipeDetailViewAdapter recipeDetailViewAdapter;
    private List<MealsDetail> detailList = new ArrayList<>();
    private String mealId;
    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        mealId = getIntent().getExtras().getString(Constant.EXTRA_MEAL_ID);

        tvMeal = findViewById(R.id.tv_meal);
        tvCategory = findViewById(R.id.tv_category);
        tvArea = findViewById(R.id.tv_area);
        tvIngridients = findViewById(R.id.tv_ingredients);
        tvInstructions = findViewById(R.id.tv_instructions);
        tvTags = findViewById(R.id.tv_tags);
        ivPhoto = findViewById(R.id.iv_photo);
        rvDetailRecipe = findViewById(R.id.rv_detail_recipe);
        youTubePlayerView = findViewById(R.id.youtube_player_view);

//        tvMeal.setText(mealName);

        rvDetailRecipe.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recipeDetailViewAdapter = new RecipeDetailViewAdapter(this::onItemRecipeDetailClick);
        rvDetailRecipe.setAdapter(recipeDetailViewAdapter);

        getRecipeDetail(mealId);
    }

    private void getRecipeDetail(String mealId) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_MEAL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService api = retrofit.create(APIService.class);
        api.getDetailRecipe(mealId).enqueue(new Callback<ResponseMealsDetail>() {
            @Override
            public void onResponse(Call<ResponseMealsDetail> call, Response<ResponseMealsDetail> response) {
                detailList = response.body().getMeals();
                recipeDetailViewAdapter.setData(detailList);
                Toast.makeText(RecipeDetailActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseMealsDetail> call, Throwable t) {
                System.out.println("Retrofit Error: " + t.getMessage());
                Toast.makeText(RecipeDetailActivity.this, "Retrofit Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void onItemRecipeDetailClick(MealsDetail mealsDetail, int i) {
        Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show();
    }


}