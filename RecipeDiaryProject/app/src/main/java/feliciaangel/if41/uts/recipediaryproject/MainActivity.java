package feliciaangel.if41.uts.recipediaryproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView ivMeal, ivDessert, ivFastFood, ivCocktail;
    private TextView tvDessert, tvFastFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivMeal = findViewById(R.id.iv_meal);
        ivDessert = findViewById(R.id.iv_dessert);
        ivFastFood = findViewById(R.id.iv_fastfood);
        ivCocktail = findViewById(R.id.iv_cocktail);
        tvDessert = findViewById(R.id.tv_dessert);
        tvFastFood = findViewById(R.id.tv_fastfood);

        ivMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MealCategoriesActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Ikon ini berhasil di klik", Toast.LENGTH_SHORT).show();
            }
        });

        ivDessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecipeListActivity.class);
                String namaBahan = tvDessert.getText().toString();
                intent.putExtra("NAMA", namaBahan);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Ikon ini berhasil di klik", Toast.LENGTH_SHORT).show();
            }
        });

        ivFastFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecipeListActivity.class);
                String namaBahan = tvFastFood.getText().toString();
                intent.putExtra("NAMA", namaBahan);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Ikon ini berhasil di klik", Toast.LENGTH_SHORT).show();
            }
        });
        ivCocktail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CocktailActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Ikon ini berhasil di klik", Toast.LENGTH_SHORT).show();
            }
        });
    }
}