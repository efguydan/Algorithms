package practice.hashcode.practice2021.model;

import java.util.ArrayList;
import java.util.HashSet;

public class Pizza {

    int id;
    HashSet<String> ingredients;

    public Pizza(int id, HashSet<String> ingredients) {
        this.id = id;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public HashSet<String> getIngredients() {
        return ingredients;
    }

    public int getIngredientsCount() {
        return ingredients.size();
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", ingredients=" + ingredients +
                '}';
    }
}
