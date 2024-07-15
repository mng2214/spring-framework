package com.appdeveloper.algoquestions.algoQ;

public class isPalindrome {

    public static void main(String[] args) {


        // Task 2 isPalindrome()
        String s1 = "A man, a plan, a canal: Panama";
       // String s1 = "ab";
         System.out.println(isPalindrome(s1));
       //  System.out.println(isPalindrome1(s1));
    }

    /**
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
     * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
     * Given a string s, return true if it is a palindrome, or false otherwise.
     * <p>
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     */

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String sReversed = new StringBuilder(s).reverse().toString();
        return s.equals(sReversed);
    }


    public static boolean isPalindrome1(String s) {

        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0, right = cleanedString.length() - 1;
        while (left < right) {
            if (cleanedString.charAt(left) != cleanedString.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }



}
