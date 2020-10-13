package model;

// Represents the food intake of a person, composed of carbohydrates, protein and fats (in grams)

public class Food {
    public int carbs;                  // carbohydrates consumed in grams
    public int protein;                // protein consumed in grams
    public int fat;                    // fats consumed in grams


    // EFFECTS: make a new DailyFoodIntake, assuming the user has consumed nothing yet;

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
        String meal = "You had " + carbs + "g of carbs, " + protein + "g of protein, and " +  fat + "g of fat.";
        return meal;
    }
}
