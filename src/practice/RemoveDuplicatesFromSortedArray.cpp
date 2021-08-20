#include <vector>
#include <iostream>

using namespace std;

/**
 * @author EfeDaniel
 * @link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @progress: Done
 * @return the number of unique elements
 */
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        int k = 1;
        int pointer = 1;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] != nums[i-1]) {
                nums[pointer++] = nums[i];
                k++;
            }
        }
        return k;
    }
};