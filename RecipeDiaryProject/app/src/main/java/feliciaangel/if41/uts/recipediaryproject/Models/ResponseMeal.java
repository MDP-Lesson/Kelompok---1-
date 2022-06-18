package feliciaangel.if41.uts.recipediaryproject.Models;

import java.util.List;

public class ResponseMeal {
    private List<Meal> meals;

    public ResponseMeal() {
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
