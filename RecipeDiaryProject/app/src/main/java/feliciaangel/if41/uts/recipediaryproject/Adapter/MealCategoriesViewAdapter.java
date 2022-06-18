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

import feliciaangel.if41.uts.recipediaryproject.Models.MealCategories;
import feliciaangel.if41.uts.recipediaryproject.R;
import feliciaangel.if41.uts.recipediaryproject.Utils.ItemClickListener;

public class MealCategoriesViewAdapter extends RecyclerView.Adapter<MealCategoriesViewAdapter.ViewHolder> {
    private List<MealCategories> data = new ArrayList<>();
    private ItemClickListener<MealCategories> itemClickListener;

    public MealCategoriesViewAdapter(ItemClickListener<MealCategories> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<MealCategories> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_categories,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(data.get(position).getStrCategoryThumb())
                .into(holder.ivImage);

        holder.tvName.setText(data.get(position).getStrCategory());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(data.get(position), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.iv_image);
            tvName = itemView.findViewById(R.id.tv_title);
        }
    }
}
