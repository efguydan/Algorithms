package competitions.Hashcode2021.models;

public class Street {

    public String name;
    public int start;
    public int end;
    public int duration;
    public int possibleCars;
    public int openDuration;

    public Street() {

    }

    public Street(String name, int start, int end, int duration) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.duration = duration;
        this.possibleCars = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", duration=" + duration +
                ", possibleCars=" + possibleCars +
                '}';
    }
}
