package practice.hashcode.practice2021.model;

import java.util.ArrayList;

public class Delivery {

    int teamCount;
    ArrayList<Integer> pizzasDelivered;

    public Delivery(int teamCount) {
        this.teamCount = teamCount;
    }

    public void setPizzasDelivered(ArrayList<Integer> pizzasDelivered) {
        this.pizzasDelivered = pizzasDelivered;
    }

    public int getTeamCount() {
        return teamCount;
    }

    public String getInSubmissionFormat() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(teamCount);
        for (int id: pizzasDelivered) {
            stringBuilder.append(" ");
            stringBuilder.append(id);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "teamCount=" + teamCount +
                ", pizzasDelivered=" + pizzasDelivered +
                '}';
    }

}
