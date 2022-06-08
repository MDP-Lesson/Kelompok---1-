package feliciaangel.if41.uts.recipediaryproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CocktailActivity extends AppCompatActivity {

    private ImageView ivVodka, ivGin, ivTequila, ivRum;
    private TextView tvVodka, tvGin, tvTequila, tvRum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail);

        ivVodka = findViewById(R.id.iv_vodka);
        ivGin = findViewById(R.id.iv_gin);
        ivTequila = findViewById(R.id.iv_tequila);
        ivRum = findViewById(R.id.iv_rum);
        tvVodka = findViewById(R.id.tv_vodka);
        tvGin = findViewById(R.id.tv_gin);
        tvTequila = findViewById(R.id.tv_tequila);
        tvRum = findViewById(R.id.tv_rum);

        ivVodka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CocktailActivity.this, RecipeListActivity.class);
                String namaBahan = tvVodka.getText().toString();
                intent.putExtra("NAMA", namaBahan);
                startActivity(intent);
            }
        });

        ivGin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CocktailActivity.this, RecipeListActivity.class);
                String namaBahan = tvGin.getText().toString();
                intent.putExtra("NAMA", namaBahan);
                startActivity(intent);
            }
        });

        ivTequila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CocktailActivity.this, RecipeListActivity.class);
                String namaBahan = tvTequila.getText().toString();
                intent.putExtra("NAMA", namaBahan);
                startActivity(intent);
            }
        });

        ivRum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CocktailActivity.this, RecipeListActivity.class);
                String namaBahan = tvRum.getText().toString();
                intent.putExtra("NAMA", namaBahan);
                startActivity(intent);
            }
        });
    }
}