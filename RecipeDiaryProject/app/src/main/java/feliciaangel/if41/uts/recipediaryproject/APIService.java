package feliciaangel.if41.uts.recipediaryproject;

import feliciaangel.if41.uts.recipediaryproject.Models.ResponseCocktail;
import feliciaangel.if41.uts.recipediaryproject.Models.ResponseCocktailDetail;
import feliciaangel.if41.uts.recipediaryproject.Models.ResponseMealCategories;
import feliciaangel.if41.uts.recipediaryproject.Models.ResponseMeal;
import feliciaangel.if41.uts.recipediaryproject.Models.ResponseMealsDetail;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService
{
    @GET("filter.php?")
    Call<ResponseMeal> getMeal(@Query("c") String query);

    @GET("lookup.php?")
    Call<ResponseMealsDetail> getDetailRecipe(@Query("i") String query);

    @GET("categories.php")
    Call<ResponseMealCategories> getMealCategory();

    @GET("filter.php?c=Ordinary_Drink")
    Call<ResponseCocktail> getDrinks();

    @GET("lookup.php?")
    Call<ResponseCocktailDetail> getCocktailDetail(@Query("i") String query);
}
