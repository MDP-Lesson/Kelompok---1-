package feliciaangel.if41.uts.recipediaryproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView ivFood, ivCocktail, ivTutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivFood = findViewById(R.id.iv_food);
        ivCocktail = findViewById(R.id.iv_cocktail);
        ivTutorial = findViewById(R.id.iv_tutorial);

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

        ivTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TutorialActivity.class);
                startActivity(intent);
            }
        });

    }


}