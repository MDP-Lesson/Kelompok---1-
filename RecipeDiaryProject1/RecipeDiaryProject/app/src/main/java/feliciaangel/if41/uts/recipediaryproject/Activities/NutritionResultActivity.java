package feliciaangel.if41.uts.recipediaryproject.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import feliciaangel.if41.uts.recipediaryproject.Adapter.NutritionViewAdapter;
import feliciaangel.if41.uts.recipediaryproject.Models.Nutrition;
import feliciaangel.if41.uts.recipediaryproject.Models.ResponseNutrition;
import feliciaangel.if41.uts.recipediaryproject.R;
import feliciaangel.if41.uts.recipediaryproject.Service.APIService;
import feliciaangel.if41.uts.recipediaryproject.Utils.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NutritionResultActivity extends AppCompatActivity {

    private RecyclerView rvResult;
    private NutritionViewAdapter nutritionResultViewAdapter;
    private List<Nutrition> nutritionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrisi_result);

        String input = getIntent().getExtras().getString("INPUT");

        rvResult = findViewById(R.id.rv_result_nutrition);

        rvResult.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        nutritionResultViewAdapter = new NutritionViewAdapter();
        rvResult.setAdapter(nutritionResultViewAdapter);

        getResult(input);
    }

    private void getResult(String input){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_NUTRITION_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService api = retrofit.create(APIService.class);
        api.getNutrition(input).enqueue(new Callback<ResponseNutrition>() {
            @Override
            public void onResponse(Call<ResponseNutrition> call, Response<ResponseNutrition> response) {
                nutritionList = response.body().getItems();
                nutritionResultViewAdapter.setmData(nutritionList);
                Toast.makeText(NutritionResultActivity.this, "Movie Data Success!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseNutrition> call, Throwable t) {
                System.out.println("Retrofit Error: " + t.getMessage());
                Toast.makeText(NutritionResultActivity.this, "Retrofit Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
