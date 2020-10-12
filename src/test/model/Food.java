package model;

// Represents the food intake of a person, composed of carbohydrates, protein and fats (in grams)

public class Food {
    private int carbs;                  // carbohydrates consumed in grams
    private int protein;                // protein consumed in grams
    private int fat;                    // fats consumed in grams


    // EFFECTS: make a new DailyFoodIntake, assuming the user has consumed nothing yet;

    public Food(){
       carbs = 0;
       protein = 0;
       fat = 0;
    }
    // REQUIRES: carbs, protein and fat all must be strictly non-negative.
    // MODIFIES: this
    // EFFECTS: add the macro-nutrients consumed to the total food intake

    public void eatAMeal(int carbs, int protein, int fat){
        this.carbs += carbs;
        this.protein += protein;
        this.fat += fat;
    }

    // EFFECTS: return the total calories consumed by the user, applying the 4-4-9 rule here
    public int getCalories(){
        int calories = 4 * carbs + 4 * protein + 9 * fat;
        return calories;
    }
    // EFFECTS: return carbs consumed in grams
    public int getCarbs(){
        return carbs;
    }
    // EFFECTS: return protein consumed in grams
    public int getProtein(){
        return protein;
    }
    // EFFECTS: return fat consumed in grams
    public int getFat(){
        return fat;
    }
}

