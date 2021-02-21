package practice.hashcode.practice2021;

import practice.hashcode.practice2021.model.Delivery;
import practice.hashcode.practice2021.model.Pizza;
import practice.hashcode.practice2021.model.Teams;

import java.io.*;
import java.util.*;

public class Solution {

    // Input Variables
    private ArrayList<Pizza> inputList = new ArrayList<>();
    private Teams teamCounts = new Teams(0, 0, 0);

    // Output Variables
    private ArrayList<Delivery> outPutList = new ArrayList<>();

    public void parseInput(String filename) {
        int bufferSize = 8 * 1024;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename), bufferSize);

            String firstLine = bufferedReader.readLine();
            String[] arr = firstLine.split(" ");
            int pizzaCount = Integer.parseInt(arr[0]);
            teamCounts.setCountOfTwo(Integer.parseInt(arr[1]));
            teamCounts.setCountOfThree(Integer.parseInt(arr[2]));
            teamCounts.setCountOfFour(Integer.parseInt(arr[3]));

            for (int i = 0; i < pizzaCount; i++) {
                String l = bufferedReader.readLine();
                String[] lArray = l.split(" ");
                HashSet<String> ingredients = new HashSet<>(Integer.parseInt(lArray[0]));
                for (int k = 1; k < lArray.length; k++) ingredients.add(lArray[k]);
                Pizza pizza = new Pizza(i, ingredients);
                inputList.add(pizza);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void simulate() {
        inputList.sort(Comparator.comparingInt(o -> o.getIngredients().size()));
        Collections.reverse(inputList);

        int teamCount;
        while((teamCount = teamCounts.getNextTeam(inputList.size())) != 0) {
            Delivery delivery = new Delivery(teamCount);
            ArrayList<Integer> pizzas = new ArrayList<>();

            ArrayList<Integer> selectedPizzas = new ArrayList<>();
            selectedPizzas.add(0);
            Set<String> ingredients = new HashSet<>(inputList.get(0).getIngredients());

            while (selectedPizzas.size() < teamCount) {
                int selectedIndex = 0;
                HashSet<String> ingredientsCopy = new HashSet<>(inputList.get(0).getIngredients());
                ingredientsCopy.removeAll(ingredients);
                int score = ingredientsCopy.size();

                int end = Integer.min(100, inputList.size());
                for (int i = 1; i < end; i++) {
                    if (selectedPizzas.contains(i)) continue;
                    HashSet<String> copy = new HashSet<>(inputList.get(i).getIngredients());
                    copy.removeAll(ingredients);
                    if (copy.size() > score) {
                        score = copy.size();
                        selectedIndex = i;
                    } else if (copy.size() == score) {
                        if (inputList.get(selectedIndex).getIngredientsCount() > inputList.get(i).getIngredientsCount()) {
                            selectedIndex = i;
                        }
                    }
                }
                selectedPizzas.add(selectedIndex);
            }

            Collections.sort(selectedPizzas);
            Collections.reverse(selectedPizzas);
            for (int selectedPizza: selectedPizzas) {
                Pizza pizza = inputList.remove(selectedPizza);
                pizzas.add(pizza.getId());
                System.out.println(inputList.size());
            }

            delivery.setPizzasDelivered(pizzas);
            outPutList.add(delivery);
        }
    }

    public void parseOutput(String filename) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(filename, "UTF-8");
            writer.println(outPutList.size());
            for (int j = 0; j < outPutList.size(); j++) {
                writer.println(outPutList.get(j).getInSubmissionFormat());
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
