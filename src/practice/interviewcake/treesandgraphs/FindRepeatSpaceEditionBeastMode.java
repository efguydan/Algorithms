package practice.interviewcake.treesandgraphs;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/find-duplicate-optimize-for-space-beast-mode?course=fc1&section=trees-graphs
 * Progress: Done
 */
public class FindRepeatSpaceEditionBeastMode {

    public static int findDuplicate(int[] intArray) {
        int tortoise, hare = tortoise = intArray[0];
        do {
            tortoise = intArray[tortoise];
            hare = intArray[intArray[hare]];
        } while (tortoise != hare);
        hare = intArray[0];
        while (tortoise != hare) {
            tortoise = intArray[tortoise];
            hare = intArray[hare];
        }
        return hare;
    }

}
