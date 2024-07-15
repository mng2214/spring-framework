package com.appdeveloper.algoquestions.algoQ;

import java.util.*;

public class TwoSum {


    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     * <p>
     * Example
     * <p>
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     */

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int possibleNum = target - nums[i];
            if (map.containsKey(possibleNum))
                return new int[]{map.get(possibleNum), i};
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    private static int[] twoSum1(int[] nums, int target) {
        //sort array using Arrrays util
        Arrays.sort(nums); //O(n.log(n))
        //init two pointers
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {

            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        throw new IllegalArgumentException("there is no such elemnts");
    }
}
