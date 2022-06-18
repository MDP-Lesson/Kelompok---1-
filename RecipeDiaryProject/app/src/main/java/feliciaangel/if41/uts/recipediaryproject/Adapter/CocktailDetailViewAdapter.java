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

import feliciaangel.if41.uts.recipediaryproject.Models.CocktailDetail;
import feliciaangel.if41.uts.recipediaryproject.R;
import feliciaangel.if41.uts.recipediaryproject.Utils.ItemClickListener;

public class CocktailDetailViewAdapter extends RecyclerView.Adapter<CocktailDetailViewAdapter.ViewHolder> {

    private List<CocktailDetail> mData = new ArrayList<>();
    private ItemClickListener<CocktailDetail> itemClickListener;

    public CocktailDetailViewAdapter(ItemClickListener<CocktailDetail> itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<CocktailDetail> mData){
        this.mData = mData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cocktail_detail,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(mData.get(position).getStrDrinkThumb())
                .into(holder.ivPhoto);
        holder.tvCocktail.setText(mData.get(position).getStrDrink());
        holder.tvAlcoholic.setText(mData.get(position).getStrAlcoholic());
        holder.tvGlass.setText(mData.get(position).getStrGlass());
        holder.tvIngridients.setText(mData.get(position).getStrIngredient1() + ", " + mData.get(position).getStrIngredient2() + ", " + mData.get(position).getStrIngredient3() + ", "
                + mData.get(position).getStrIngredient4() + ", " + mData.get(position).getStrIngredient5() + ", " + mData.get(position).getStrIngredient6() + ", " + mData.get(position).getStrIngredient7() + ", "
                + mData.get(position).getStrIngredient8() + ", " + mData.get(position).getStrIngredient9() + ", " + mData.get(position).getStrIngredient10() + ", " + mData.get(position).getStrIngredient11() + ", "
                + mData.get(position).getStrIngredient12() + ", " + mData.get(position).getStrIngredient13() + ", " + mData.get(position).getStrIngredient14() + ", " + mData.get(position).getStrIngredient15());
        holder.tvInstructions.setText(mData.get(position).getStrInstructions());

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

        private TextView tvCocktail, tvAlcoholic, tvGlass, tvIngridients, tvInstructions;
        private ImageView ivPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCocktail = itemView.findViewById(R.id.tv_cocktail);
            tvAlcoholic = itemView.findViewById(R.id.tv_alcoholic);
            tvGlass = itemView.findViewById(R.id.tv_glass);
            tvIngridients = itemView.findViewById(R.id.tv_ingredients);
            tvInstructions = itemView.findViewById(R.id.tv_instructions);
            ivPhoto = itemView.findViewById(R.id.iv_photo);
        }
    }
}
