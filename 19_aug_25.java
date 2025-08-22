// leetcode.com/problems/number-of-zero-filled-subarrays/?envType=daily-question&envId=2025-08-19

// Given an integer array nums, return the number of subarrays filled with 0.
// A subarray is a contiguous non-empty sequence of elements within an array.

class Solution {

    public long zeroFilledSubarray(int[] nums) {
        long answer = 0;
        for (int i = 0; i < nums.length; i++) {
            long count = 0;
            while (i < nums.length && nums[i] == 0) {
                count++;
                i++;
            }
            if (count != 0) {
                answer += (count * (count + 1)) / 2;
            }
        }
        return answer;
    }
}