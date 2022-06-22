package feliciaangel.if41.uts.recipediaryproject.Models;

import java.util.List;

public class ResponseMealsDetail {
    private List<MealsDetail> meals;

    public ResponseMealsDetail() {
    }

    public List<MealsDetail> getMeals() {
        return meals;
    }

    public void setMeals(List<MealsDetail> meals) {
        this.meals = meals;
    }
}
