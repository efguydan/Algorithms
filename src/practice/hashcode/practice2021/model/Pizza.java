package practice.hashcode.practice2021.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    int id;
    ArrayList<String> ingredients;

    public Pizza(int id, ArrayList<String> ingredients) {
        this.id = id;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", ingredients=" + ingredients +
                '}';
    }
}
