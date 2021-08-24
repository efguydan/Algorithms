#include <vector>
#include <iostream>

using namespace std;

/**
 * @author EfeDaniel
 * @link: https://leetcode.com/problems/max-consecutive-ones/
 * @progress: Done
 * @return the number of unique elements
 */
class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int max = 0;
        int current = 0;

        for (int x : nums) {
            if (x == 1) {
                current++;
                if (current > max) max = current;
            } else {
                current = 0;
            }
        }

        return max;
    }
};