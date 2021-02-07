package practice.interviewcake.sortingsearchindandlogarithms;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/find-duplicate-optimize-for-space?course=fc1&section=sorting-searching-logarithms
 * Progress: Done
 */
public class FindRepeatSpaceEdition {

    public static int findRepeat(int[] numbers) {
        int min = 1;
        int max = numbers.length-1;

        while(min < max) {
            int mid = (min + max) / 2;
            int lowerRangeFloor   = min;
            int lowerRangeCeiling = mid;
            int upperRangeFloor   = mid + 1;
            int upperRangeCeiling = max;

            int itemsInLowerRange = 0;
            for (int number: numbers) {
                if (number >= lowerRangeFloor && number <= lowerRangeCeiling) itemsInLowerRange++;
            }

            int distinctPossibleIntegersInLowerRange = lowerRangeCeiling - lowerRangeFloor + 1;

            if (itemsInLowerRange > distinctPossibleIntegersInLowerRange) {
                min   = lowerRangeFloor;
                max = lowerRangeCeiling;
            } else {
                min   = upperRangeFloor;
                max = upperRangeCeiling;
            }
        }

        return min;
    }

}
