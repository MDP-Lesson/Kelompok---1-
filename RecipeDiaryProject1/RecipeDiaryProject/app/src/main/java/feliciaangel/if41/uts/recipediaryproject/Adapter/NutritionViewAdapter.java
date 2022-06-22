package feliciaangel.if41.uts.recipediaryproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import feliciaangel.if41.uts.recipediaryproject.Models.Nutrition;
import feliciaangel.if41.uts.recipediaryproject.R;

public class NutritionViewAdapter extends RecyclerView.Adapter<NutritionViewAdapter.ViewHolder> {
    private List<Nutrition> mData = new ArrayList<>();

    public NutritionViewAdapter() {
    }

    public void setmData(List<Nutrition> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nutrition_result, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvResultSugar.setText(mData.get(position).getSugar_g());
        holder.tvResultFiber.setText(mData.get(position).getFiber_g());
        holder.tvResultServingSize.setText(mData.get(position).getServing_size_g());
        holder.tvResultSodium.setText(mData.get(position).getSodium_mg());
        holder.tvResultName.setText(mData.get(position).getName());
        holder.tvResultPotassium.setText(mData.get(position).getPotassium_mg());
        holder.tvResultFatSaturated.setText(mData.get(position).getFat_saturated_g());
        holder.tvResultFatTotal.setText(mData.get(position).getFat_total_g());
        holder.tvResultCalories.setText(mData.get(position).getCalories());
        holder.tvResultCholesterol.setText(mData.get(position).getCholesterol_mg());
        holder.tvResultProtein.setText(mData.get(position).getProtein_g());
        holder.tvResultCarbohydrates.setText(mData.get(position).getCarbohydrates_total_g());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvResultSugar, tvResultFiber, tvResultServingSize, tvResultSodium, tvResultName,
                tvResultPotassium, tvResultFatSaturated, tvResultFatTotal, tvResultCalories,
                tvResultCholesterol, tvResultProtein, tvResultCarbohydrates;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvResultSugar = itemView.findViewById(R.id.tv_result_sugar);
            tvResultFiber = itemView.findViewById(R.id.tv_result_fiber);
            tvResultServingSize = itemView.findViewById(R.id.tv_result_serving_size);
            tvResultSodium = itemView.findViewById(R.id.tv_result_sodium);
            tvResultName = itemView.findViewById(R.id.tv_result_name);
            tvResultPotassium = itemView.findViewById(R.id.tv_result_potassium);
            tvResultFatSaturated = itemView.findViewById(R.id.tv_result_fat_saturated);
            tvResultFatTotal = itemView.findViewById(R.id.tv_result_fat_total);
            tvResultCalories = itemView.findViewById(R.id.tv_result_calories);
            tvResultCholesterol = itemView.findViewById(R.id.tv_result_cholestrol);
            tvResultProtein = itemView.findViewById(R.id.tv_result_protein);
            tvResultCarbohydrates = itemView.findViewById(R.id.tv_result_carbohydrates);
        }
    }
}