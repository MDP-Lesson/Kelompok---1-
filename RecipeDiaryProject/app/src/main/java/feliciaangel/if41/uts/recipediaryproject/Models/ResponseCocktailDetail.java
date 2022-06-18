package feliciaangel.if41.uts.recipediaryproject.Models;

import java.util.List;

public class ResponseCocktailDetail {

    private List<CocktailDetail> drinks;

    public ResponseCocktailDetail() {
    }

    public List<CocktailDetail> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<CocktailDetail> drinks) {
        this.drinks = drinks;
    }
}
