package feliciaangel.if41.uts.recipediaryproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeListActivity extends AppCompatActivity {

    private ImageView ivRecipe1;
    private TextView tvRecipe, tvCategoriesName;
    private Response recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        String namaBahan = getIntent().getExtras().getString("NAMA");
        

        tvRecipe = findViewById(R.id.tv_recipe1);
        ivRecipe1 = findViewById(R.id.iv_recipe1);
        tvCategoriesName = findViewById(R.id.tv_categories_name);

        String recipe = namaBahan;

        tvCategoriesName.setText(recipe);
        //ivRecipe1.setImageResource(recipe.getT);

        ivRecipe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecipeListActivity.this, RecipeDetailActivity.class);
                startActivity(intent);
            }
        });
    }
}