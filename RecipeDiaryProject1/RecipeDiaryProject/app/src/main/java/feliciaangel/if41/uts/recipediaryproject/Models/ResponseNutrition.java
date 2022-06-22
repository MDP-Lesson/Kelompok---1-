package feliciaangel.if41.uts.recipediaryproject.Models;

import java.util.List;

public class ResponseNutrition {
    private List<Nutrition> items;

    public ResponseNutrition() {
    }

    public List<Nutrition> getItems() {
        return items;
    }

    public void setItems(List<Nutrition> items) {
        this.items = items;
    }
}
