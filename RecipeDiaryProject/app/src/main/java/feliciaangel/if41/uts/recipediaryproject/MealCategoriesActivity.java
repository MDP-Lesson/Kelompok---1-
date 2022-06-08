package feliciaangel.if41.uts.recipediaryproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MealCategoriesActivity extends AppCompatActivity {

    private ImageView ivChicken, ivBeef, ivSalmon, ivPork;
    private TextView tvChicken, tvBeef, tvSalmon, tvPork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_categories);

        ivChicken = findViewById(R.id.iv_chicken);
        ivBeef = findViewById(R.id.iv_beef);
        ivSalmon = findViewById(R.id.iv_salmon);
        ivPork = findViewById(R.id.iv_pork);
        tvChicken = findViewById(R.id.tv_chicken);
        tvBeef = findViewById(R.id.tv_beef);
        tvSalmon = findViewById(R.id.tv_salmon);
        tvPork = findViewById(R.id.tv_pork);

        ivChicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealCategoriesActivity.this, RecipeListActivity.class);
                String namaBahan = tvChicken.getText().toString();
                intent.putExtra("NAMA", namaBahan);
                startActivity(intent);
            }
        });

        ivBeef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealCategoriesActivity.this, RecipeListActivity.class);
                String namaBahan = tvBeef.getText().toString();
                intent.putExtra("NAMA", namaBahan);
                startActivity(intent);
            }
        });

        ivSalmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealCategoriesActivity.this, RecipeListActivity.class);
                String namaBahan = tvSalmon.getText().toString();
                intent.putExtra("NAMA", namaBahan);
                startActivity(intent);
            }
        });

        ivPork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealCategoriesActivity.this, RecipeListActivity.class);
                String namaBahan = tvPork.getText().toString();
                intent.putExtra("NAMA", namaBahan);
                startActivity(intent);
            }
        });

    }
}