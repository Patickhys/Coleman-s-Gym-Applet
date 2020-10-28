package model;

// Represents the food intake of a person, composed of carbohydrates, protein and fats (in grams)

import org.json.JSONObject;
import persistence.Writable;

import static model.Type.*;

public class Food implements Writable {
    private int carbs;                  // carbohydrates consumed in grams
    private int protein;                // protein consumed in grams
    private int fat;                    // fats consumed in grams
    private final Type type = FOOD;



    // REQUIRES: all int must be non-negative
    // EFFECTS: make a new DailyFoodIntake, assuming the user has consumed nothing yet

    public Food(int carbs, int protein, int fat) {
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
    }
    // REQUIRES: carbs, protein and fat all must be strictly non-negative.
    // MODIFIES: this
    // EFFECTS: add the macro-nutrients consumed to the total food intake

    public void eatAMeal(int carbs, int protein, int fat) {
        this.carbs += carbs;
        this.protein += protein;
        this.fat += fat;
    }

    // EFFECTS: return the total calories consumed by the user, applying the 4-4-9 rule here
    public int getCalories() {
        int calories = 4 * carbs + 4 * protein + 9 * fat;
        return calories;
    }

    // EFFECTS: return carbs consumed in grams
    public int getCarbs() {
        return carbs;
    }

    // EFFECTS: return protein consumed in grams
    public int getProtein() {
        return protein;
    }

    // EFFECTS: return fat consumed in grams
    public int getFat() {
        return fat;
    }

    public String reportMeal() {
        int cal = getCalories();
        String meal = "You had " + carbs + "g of carbs, " + protein + "g of protein, and " +  fat + "g of fat."
                + "A total of " + cal + " calories.";
        return meal;
    }

    // EFFECTS: Make food into a JSONObject
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Carbs", carbs);
        json.put("Protein", protein);
        json.put("Fat", fat);
        return json;
    }
}

