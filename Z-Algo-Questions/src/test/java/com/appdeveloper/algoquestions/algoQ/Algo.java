package com.appdeveloper.algoquestions.algoQ;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Algo {

    /**
     * TASK 1
     * <p>
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

    /**
     * * TASK 2
     * <p>
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
     * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
     * Given a string s, return true if it is a palindrome, or false otherwise.
     * <p>
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     */

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^\\p{L}]", "").toLowerCase();
        String sReversed = new StringBuilder(s).reverse().toString();
        return sReversed.equals(s);
    }

//    public static boolean isPalindrome(String s) {
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
//                sb.append(c);
//            }
//        }
//
//        String letterOnlyStr = sb.toString();
//        String reversedString = new StringBuilder(letterOnlyStr).reverse().toString();
//
//        return letterOnlyStr.equalsIgnoreCase(reversedString);
//    }


    public static void main(String[] args) {
        // Task 1 isAnagram()
        String s = "anagram", t = "nagaram";
        // System.out.println(isAnagram(s, t));

        // Task 2 isPalindrome()
        String s1 = "A man, a plan, a canal: Panama";
        // System.out.println(isPalindrome(s1));
    }
}
