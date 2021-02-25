package Competitions.Hashcode2021.models;

public class Simulation {

    public int duration;
    public int noOfIntersections;
    public int noOfStreets;
    public int noOfCars;
    public int bonusPoints;

    public Simulation() {

    }
    public Simulation(int duration, int noOfIntersections, int noOfStreets, int noOfCars, int bonusPoints) {
        this.duration = duration;
        this.noOfIntersections = noOfIntersections;
        this.noOfStreets = noOfStreets;
        this.noOfCars = noOfCars;
        this.bonusPoints = bonusPoints;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setNoOfIntersections(int noOfIntersections) {
        this.noOfIntersections = noOfIntersections;
    }

    public void setNoOfStreets(int noOfStreets) {
        this.noOfStreets = noOfStreets;
    }

    public void setNoOfCars(int noOfCars) {
        this.noOfCars = noOfCars;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    @Override
    public String toString() {
        return "Simulation{" +
                "duration=" + duration +
                ", noOfIntersections=" + noOfIntersections +
                ", noOfStreets=" + noOfStreets +
                ", noOfCars=" + noOfCars +
                ", bonusPoints=" + bonusPoints +
                '}';
    }
}
