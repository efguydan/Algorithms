import java.util.Arrays;

/**
 * 
 * @author EfeDaniel
 * Link: https://leetcode.com/problems/jump-game-ii/
 * Progress: In Progress
 *
 */

public class JumpGameII {
	public static void main(String [] args) {
		int [] nums1 = {1, 3, 4};
		System.out.println(jump(nums1) + " " + (jump(nums1) == 2));
		int [] nums2 = {1, 2, 3, 4, 5};
		System.out.println(jump(nums2) + " " + (jump(nums2) == 3));
		int [] nums3 = {2, 1};
		System.out.println(jump(nums3) + " " + (jump(nums3) == 1));
		int [] nums4 = {2, 1, 1};
		System.out.println(jump(nums4) + " " + (jump(nums4) == 1));
		int [] nums5 = {2, 1, 1, 1};
		System.out.println(jump(nums5) + " " + (jump(nums5) == 2));
		int [] nums6 = {2, 3, 1, 1, 1};
		System.out.println(jump(nums6) + " " + (jump(nums6) == 2));
        int [] nums7 = {4, 1, 1, 3, 1, 1, 1};
        System.out.println(jump(nums7) + " " + (jump(nums7) == 2));
	}
	
	public static int jump(int[] nums) {
		
        boolean atTheEnd = false;
        int index = 0;
        int noOfJumps = 0;
        int bestJump = 0;
        int length = nums.length - 1;
        
        if(length == 0 || length == -1)
            return 0;
        
        while(!atTheEnd){
            bestJump = optimalJump(nums, index);
            index += bestJump;
            noOfJumps++;
            if (index == length)
                atTheEnd = true;
        }
        return noOfJumps;
    }
    
    public static int optimalJump(int[] nums, int index){
        int max = 0;
        for(int i = 0; i < nums[index]; i++){
            if(index + i > nums.length - 1)
                continue;
            if(nums[index + i] >= max)
                max = nums[index + i];
        }
        while(index + max > nums.length - 1)
            max--;
        return max;
    }
}
