package practice;

/**
 * @author EfeDaniel
 * Link: https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 * Progress: Not Done
 */
public class TapeEquilibrium {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 4, 3}));
        System.out.println(solution(new int[]{-2, -3, -4, -1}));
    }

    public static int solution(int[] nums) {
        int diff = 0, leftIndex = 0, rightIndex = nums.length - 1;
        diff += nums[leftIndex];
        diff -= nums[rightIndex];
        while (rightIndex - leftIndex > 1) {
            if (Math.abs(diff + nums[leftIndex+1]) > Math.abs(diff - nums[rightIndex-1])) {
                rightIndex--;
                diff -= nums[rightIndex];
            } else {
                leftIndex++;
                diff += nums[leftIndex];
            }
        }
        return Math.abs(diff);
    }
}
