package feliciaangel.if41.uts.recipediaryproject.Models;

import java.util.List;

public class ResponseMealCategories {
    private List<MealCategories> categories;

    public ResponseMealCategories() {
    }

    public List<MealCategories> getCategories() {
        return categories;
    }

    public void setCategories(List<MealCategories> categories) {
        this.categories = categories;
    }
}
