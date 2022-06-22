package feliciaangel.if41.uts.recipediaryproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import feliciaangel.if41.uts.recipediaryproject.Utils.ItemClickListener;
import feliciaangel.if41.uts.recipediaryproject.Models.MealsDetail;
import feliciaangel.if41.uts.recipediaryproject.R;

public class RecipeDetailViewAdapter extends RecyclerView.Adapter<RecipeDetailViewAdapter.ViewHolder> {
    private List<MealsDetail> data = new ArrayList<>();
    private ItemClickListener<MealsDetail> itemClickListener;

    public RecipeDetailViewAdapter(ItemClickListener<MealsDetail> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<MealsDetail> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe_detail, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(data.get(position).getStrMealThumb())
                .into(holder.ivPhoto);
        holder.tvCategory.setText(data.get(position).getStrCategory());
        holder.tvMeal.setText(data.get(position).getStrMeal());
        holder.tvIngridients.setText(data.get(position).getStrIngredient1() + ", " + data.get(position).getStrIngredient2() + ", " + data.get(position).getStrIngredient3() + ", "
        + data.get(position).getStrIngredient4() + ", " + data.get(position).getStrIngredient5() + ", " + data.get(position).getStrIngredient6() + ", " + data.get(position).getStrIngredient7() + ", "
        + data.get(position).getStrIngredient8() + ", " + data.get(position).getStrIngredient9() + ", " + data.get(position).getStrIngredient10() + ", " + data.get(position).getStrIngredient11() + ", "
        + data.get(position).getStrIngredient12() + ", " + data.get(position).getStrIngredient13() + ", " + data.get(position).getStrIngredient14() + ", " + data.get(position).getStrIngredient15() + ", "
        + data.get(position).getStrIngredient16() + ", " + data.get(position).getStrIngredient17() + ", " + data.get(position).getStrIngredient18() + ", " + data.get(position).getStrIngredient19() + ", "
        + data.get(position).getStrIngredient20() + ", ");
        holder.tvInstructions.setText(data.get(position).getStrInstructions());
        holder.tvArea.setText(data.get(position).getStrArea());
        holder.tvTags.setText(data.get(position).getStrTags());
        holder.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                String videoUrl = data.get(position).getStrYoutube();
                String strVideo[] = videoUrl.split("v=");
                String videoId = strVideo[1];
                youTubePlayer.cueVideo(videoId, 0);
            }
        });

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

        private TextView tvMeal, tvCategory, tvArea, tvIngridients, tvInstructions,tvTags;
        private ImageView ivPhoto;
        private YouTubePlayerView youTubePlayerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMeal = itemView.findViewById(R.id.tv_meal);
            tvCategory = itemView.findViewById(R.id.tv_category);
            tvArea = itemView.findViewById(R.id.tv_area);
            tvIngridients = itemView.findViewById(R.id.tv_ingredients);
            tvInstructions = itemView.findViewById(R.id.tv_instructions);
            tvTags = itemView.findViewById(R.id.tv_tags);
            ivPhoto = itemView.findViewById(R.id.iv_photo);
            youTubePlayerView = itemView.findViewById(R.id.youtube_player_view);

        }
    }
}
