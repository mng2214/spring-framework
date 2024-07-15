package com.appdeveloper.algoquestions.algoQ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class isAnagram {

    public static void main(String[] args) {
        // Task 1 isAnagram()
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram1(s, t));
        System.out.println(isAnagram2(s, t));
    }


    /**
     * Question-1 Valid Anagram
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     * <p>
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     */

    public static boolean isAnagram(String s, String t) {

        List<String> list = Stream.of(s, t)
                .map(word -> {
                    char[] charArray = word.toCharArray();
                    Arrays.sort(charArray);
                    return new String(charArray);
                })
                .toList();
        String s1 = list.get(0), s2 = list.get(1);
        return s1.equals(s2);
    }


    public static boolean isAnagram1(String str1, String str2) {
        boolean result = false;
        //convert strings to array using toChar() or split() methods
        String[] arr1 = str1.split("");
        String[] arr2 = str2.split("");
        //sort arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        //check equality using Arays equals method
        result = Arrays.equals(arr1, arr2);
        return result;
    }

    public static boolean isAnagram2(String s, String t) {

        Map<Character, Integer> mapOne = new HashMap<>();

        if (s.length() != t.length()) return false;

        for (int i = 0; i< s.length(); i++){
            if (!mapOne.containsKey(s.charAt(i))) {
                mapOne.put(s.charAt(i), 1);
            } else {
                mapOne.put(s.charAt(i), mapOne.get(s.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!mapOne.containsKey(c) || mapOne.get(c) == 0) {
                return false;
            }
            mapOne.put(c, mapOne.get(c) - 1);
        }

        for (int value : mapOne.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

}
