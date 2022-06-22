package feliciaangel.if41.uts.recipediaryproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import feliciaangel.if41.uts.recipediaryproject.R;

public class MainActivity extends AppCompatActivity {

    private ImageView ivFood, ivCocktail, ivNutrisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivFood = findViewById(R.id.iv_food);
        ivCocktail = findViewById(R.id.iv_cocktail);
        ivNutrisi = findViewById(R.id.iv_nutrisi);

        ivFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                startActivity(intent);
            }
        });

        ivCocktail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CocktailActivity.class);
                startActivity(intent);
            }
        });

        ivNutrisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NutrisiActivity.class);
                startActivity(intent);
            }
        });

    }


}