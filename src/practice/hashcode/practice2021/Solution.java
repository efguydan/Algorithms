package practice.hashcode.practice2021;

import practice.hashcode.practice2021.model.Delivery;
import practice.hashcode.practice2021.model.Pizza;
import practice.hashcode.practice2021.model.Teams;

import java.io.*;
import java.util.ArrayList;

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
                ArrayList<String> ingredients = new ArrayList<>(Integer.parseInt(lArray[0]));
                for (int k = 1; k < lArray.length; k++) ingredients.add(lArray[k]);
                Pizza pizza = new Pizza(i, ingredients);
                inputList.add(pizza);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void simulate() {
        int teamCount;
        while((teamCount = teamCounts.getNextTeam(inputList.size())) != 0) {
            Delivery delivery = new Delivery(teamCount);
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < delivery.getTeamCount(); i++) {
                Pizza pizza = inputList.remove(0);
                list.add(pizza.getId());
            }
            delivery.setPizzasDelivered(list);
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
