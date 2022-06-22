package feliciaangel.if41.uts.recipediaryproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import feliciaangel.if41.uts.recipediaryproject.Models.Nutrition;
import feliciaangel.if41.uts.recipediaryproject.R;
import feliciaangel.if41.uts.recipediaryproject.Utils.Constant;

public class NutrisiActivity extends AppCompatActivity {

    private TextView etInput;
    private Button btnRun;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrisi);

        etInput = findViewById(R.id.et_search);
        btnRun = findViewById(R.id.btn_run);

        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NutrisiActivity.this, NutritionResultActivity.class);
                String input = etInput.getText().toString();
                intent.putExtra("INPUT", input);
                startActivity(intent);


            }
        });


    }


}