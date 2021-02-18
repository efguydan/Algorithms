package practice.hashcode.practice2021.model;

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
        if (countOfTwo > 0 && max > 2) {
            countOfTwo--;
            return 2;
        } else if (countOfThree > 0 && max > 3) {
            countOfThree--;
            return 3;
        } else if (countOfFour > 0 && max > 4) {
            countOfFour--;
            return 4;
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
