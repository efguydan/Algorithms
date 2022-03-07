package competitions.Hashcode2021.models;

import java.util.ArrayList;

public class Car {

    public int streetCount;
    public ArrayList<String> streets;

    public Car() {
    }

    public Car(int streetCount, ArrayList<String> streets) {
        this.streetCount = streetCount;
        this.streets = streets;
    }

    public void setStreetCount(int streetCount) {
        this.streetCount = streetCount;
    }

    public void setStreets(ArrayList<String> streets) {
        this.streets = streets;
    }

    @Override
    public String toString() {
        return "Car{" +
                "streetCount=" + streetCount +
                ", streets=" + streets +
                '}';
    }
}
