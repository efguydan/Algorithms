package practice.hackerrankinterviewlessons.sorting;

/**
 * @author EfeDaniel
 * Link: https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem
 * Progress: Done
 */
public class SortingComparator implements Comparable<SortingComparator.Player> {

    @Override
    public int compareTo(Player o) {
        return 0;
    }

    static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public int compare(Player a, Player b) {
        if (a.score > b.score) {
            return -1;
        } else if (a.score < b.score) {
            return 1;
        } else {
            return a.name.compareTo(b.name);
        }
    }

}
