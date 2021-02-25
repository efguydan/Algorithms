package Competitions.Hashcode2021;

import Competitions.Hashcode2021.models.Car;
import Competitions.Hashcode2021.models.Intersection;
import Competitions.Hashcode2021.models.Simulation;
import Competitions.Hashcode2021.models.Street;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    // Input Variables
    private Simulation simulation = new Simulation();
    private HashMap<String, Street> streets = new HashMap<>();
    private ArrayList<Car> cars = new ArrayList<>();

    // Output Variables
    private HashMap<Integer, HashSet<String>> intersectionHashMap = new HashMap<>();
    HashMap<Integer, ArrayList<String>> outputList = new HashMap<>();

    public void parseInput(String filename) {
        int bufferSize = 8 * 1024;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename), bufferSize);

            String firstLine = bufferedReader.readLine();
            String[] arr = firstLine.split(" ");

            // Collecting Simulation
            simulation.setDuration(Integer.parseInt(arr[0]));
            simulation.setNoOfIntersections(Integer.parseInt(arr[1]));
            simulation.setNoOfStreets(Integer.parseInt(arr[2]));
            simulation.setNoOfCars(Integer.parseInt(arr[3]));
            simulation.setBonusPoints(Integer.parseInt(arr[4]));

            // Collecting Streets
            for (int i = 0; i < simulation.noOfStreets; i++) {
                String line = bufferedReader.readLine();
                String[] lineArr = line.split(" ");
                Street street = new Street();
                street.setStart(Integer.parseInt(lineArr[0]));
                street.setEnd(Integer.parseInt(lineArr[1]));
                street.setName(lineArr[2]);
                street.setDuration(Integer.parseInt(lineArr[3]));
                streets.put(street.name, street);
            }

            // Collecting Cars
            for (int i = 0; i < simulation.noOfCars; i++) {
                String line = bufferedReader.readLine();
                String[] lineArr = line.split(" ");
                Car car = new Car();
                car.setStreetCount(Integer.parseInt(lineArr[0]));
                ArrayList<String> streetNames = new ArrayList<>();
                for (int j = 1; j < lineArr.length; j++) streetNames.add(lineArr[j]);
                car.setStreets(streetNames);
                cars.add(car);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void simulate() {
        // Creating Intersection Map
        for (Street street: streets.values()) {
            HashSet<String> streets = intersectionHashMap.get(street.end);
            if (streets == null) streets = new HashSet<>();
            streets.add(street.name);
            intersectionHashMap.put(street.end, streets);
        }

        // Adding Possible Cars to a street
        for (Car car: cars) {
            if (car.streetCount < 2) continue;
            for (int i = 0; i < car.streets.size() - 1; i++) {
                Street street = streets.get(car.streets.get(i));
                street.possibleCars++;
            }
        }

        // Removing Zeros
        for (int id: intersectionHashMap.keySet()) {
            HashSet<String> streets = intersectionHashMap.get(id);
            ArrayList<String> streetToConsider = new ArrayList<>();

            for (String streetName : streets) {
                Street street = this.streets.get(streetName);
                if (street.possibleCars != 0) streetToConsider.add(streetName);
            }

            if (streetToConsider.size() != 0) {
                outputList.put(id, streetToConsider);
            }
        }

        // Considering Amount of Cars on each street
        for (int id: outputList.keySet()) {
            ArrayList<String> streetNames = outputList.get(id);
            int min = Integer.MAX_VALUE;
            for (String streetName: streetNames) {
                Street street = streets.get(streetName);
                min = Math.min(min, street.possibleCars);
            }

            for (String streetName: streetNames) {
                Street street = streets.get(streetName);
                street.openDuration = street.duration / min;
                if (street.openDuration < 1) street.openDuration = 1;
                if (street.openDuration > 2) street.openDuration = 2;

                street.openDuration = 1;
            }
        }
        System.out.println("Test");
    }

    public void parseOutput(String filename) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename, "UTF-8");

            writer.println(outputList.size());
            for (int id: outputList.keySet()) {
                writer.println(id);
                ArrayList<String> streets = outputList.get(id);
                writer.println(streets.size());
                for (String streetName: streets) {
                    Street street = this.streets.get(streetName);
                    String temp = streetName + " " + street.openDuration;
                    writer.println(temp);
                }
            }

            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
