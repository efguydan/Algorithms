package practice.hashcode.practice2021.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Teams {

    private int countOfTwo;
    private int countOfThree;
    private int countOfFour;

    public Teams(int countOfTwo, int countOfThree, int countOfFour) {
        this.countOfTwo = countOfTwo;
        this.countOfThree = countOfThree;
        this.countOfFour = countOfFour;
    }

    public void setCountOfTwo(int countOfTwo) {
        this.countOfTwo = countOfTwo;
    }

    public void setCountOfThree(int countOfThree) {
        this.countOfThree = countOfThree;
    }

    public void setCountOfFour(int countOfFour) {
        this.countOfFour = countOfFour;
    }

    public int getTotalCount() {
        return countOfTwo + countOfThree + countOfFour;
    }

    public int getNextTeam(int max) {
//        return getTeamFromTwo(max);
        return getTeamFromFour(max);
//        return getRandomizedTeams(max);
    }

    public int getTeamFromTwo(int max) {
        if (countOfTwo > 0 && max >= 2) {
            countOfTwo--;
            return 2;
        } else if (countOfThree > 0 && max >= 3) {
            countOfThree--;
            return 3;
        } else if (countOfFour > 0 && max >= 4) {
            countOfFour--;
            return 4;
        }
        return 0;
    }

    public int getRandomizedTeams(int max) {
        List<Integer> candidates = new ArrayList<>();
        if (max >= 2 && countOfTwo >= 0) candidates.add(2);
        if (max >= 3 && countOfThree >= 0) candidates.add(3);
        if (max >= 4 && countOfFour >= 0) candidates.add(4);
        if (candidates.isEmpty()) return 0;
        if (candidates.size() == 1) return candidates.get(0);
        Random rnd = new Random();
        int guess = candidates.get(rnd.nextInt(candidates.size() - 1));
        if (guess == 2) countOfTwo--;
        if (guess == 3) countOfThree--;
        if (guess == 4) countOfFour--;
        return guess;
    }

    public int getTeamFromFour(int max) {
        if (countOfFour > 0 && max >= 4) {
            countOfFour--;
            return 4;
        } else if (countOfThree > 0 && max >= 3) {
            countOfThree--;
            return 3;
        } else if(countOfTwo > 0 && max >= 2) {
            countOfTwo--;
            return 2;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Teams{" +
                "countOfTwo=" + countOfTwo +
                ", countOfThree=" + countOfThree +
                ", countOfFour=" + countOfFour +
                '}';
    }
}
