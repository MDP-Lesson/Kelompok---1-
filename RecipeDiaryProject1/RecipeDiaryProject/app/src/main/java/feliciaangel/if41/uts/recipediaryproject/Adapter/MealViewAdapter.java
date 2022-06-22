package feliciaangel.if41.uts.recipediaryproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import feliciaangel.if41.uts.recipediaryproject.Utils.ItemClickListener;
import feliciaangel.if41.uts.recipediaryproject.Models.Meal;
import feliciaangel.if41.uts.recipediaryproject.R;

public class MealViewAdapter extends RecyclerView.Adapter<MealViewAdapter.ViewHolder> {
    private List<Meal> data = new ArrayList<>();
    private ItemClickListener<Meal> itemClickListener;

    public MealViewAdapter(ItemClickListener<Meal> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<Meal> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_recipe, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int temp = holder.getAbsoluteAdapterPosition();


        holder.tvRecipeName.setText(data.get(position).getStrMeal());
        Glide.with(holder.itemView.getContext())
                .load(data.get(position).getStrMealThumb())
                .into(holder.ivImage);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(data.get(temp), temp);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImage;
        private TextView tvRecipeName, tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_recipe);
            tvRecipeName = itemView.findViewById(R.id.tv_recipe_name);
            tvTitle = itemView.findViewById(R.id.tv_categories_name);


        }
    }
}