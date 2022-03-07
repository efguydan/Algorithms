package competitions.Hashcode2021.models;

import java.util.ArrayList;

public class Intersection {

    public int id;
    public ArrayList<Street> streets;

    public Intersection(int id, ArrayList<Street> streets) {
        this.id = id;
        this.streets = streets;
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "id=" + id +
                ", streets=" + streets +
                '}';
    }
}
