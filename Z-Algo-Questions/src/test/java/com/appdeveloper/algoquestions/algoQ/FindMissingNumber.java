package com.appdeveloper.algoquestions.algoQ;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindMissingNumber {

/*
Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.
 */

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        int missing = findMissing(array);
        System.out.println(missing);
    }

    private static int findMissing(int[] array) {
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            try {
                if (array[i] + 1 != array[i + 1]) {
                    return array[i] + 1;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return array.length;
            }
        }
        throw new RuntimeException("There is no missing number");
    }

    static int getMissingNum(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        for (int i = 1; i < arr.length; i++) {  // or can start from "0" if it considered as num
            if (!set.contains(i)) {
                return i;
            }
        }
        return set.size();
    }
}

