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

import feliciaangel.if41.uts.recipediaryproject.Models.Cocktail;
import feliciaangel.if41.uts.recipediaryproject.R;
import feliciaangel.if41.uts.recipediaryproject.Utils.ItemClickListener;

public class CocktailViewAdapter extends RecyclerView.Adapter<CocktailViewAdapter.ViewHolder> {

    private List<Cocktail> mData = new ArrayList<>();
    private ItemClickListener<Cocktail> itemClickListener;

    public CocktailViewAdapter(ItemClickListener<Cocktail> itemClickListener)
    {
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<Cocktail> mData)
    {
        this.mData = mData;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_categories, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(mData.get(position).getStrDrinkThumb())
                .into(holder.ivImage);
        holder.tvName.setText(mData.get(position).getStrDrink());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(mData.get(position), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
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