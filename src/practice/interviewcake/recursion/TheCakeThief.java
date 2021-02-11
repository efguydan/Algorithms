package practice.interviewcake.recursion;

/**
 * @author EfeDaniel
 * Link: https://www.interviewcake.com/question/java/cake-thief?course=fc1&section=dynamic-programming-recursion
 * Progress: Done
 */
public class TheCakeThief {

    public static class CakeType {

        final int weight;
        final int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value  = value;
        }
    }

    public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {
        long[] arr = new long[weightCapacity + 1];
        for (int i = 0; i <= weightCapacity; i++) {
            long currentMaxValue = 0;
            for (CakeType cakeType : cakeTypes) {
                if (cakeType.weight == 0 && cakeType.value != 0) throw new RuntimeException("Invalid Cake");

                if (cakeType.weight <= i) {
                    long maxValueUsingCake = cakeType.value + arr[i - cakeType.weight];
                    currentMaxValue = Math.max(maxValueUsingCake, currentMaxValue);
                }
            }
            arr[i] = currentMaxValue;
        }

        return arr[weightCapacity];
    }


}
