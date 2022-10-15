package ch_15.leetcode_problems;

/*
    Problem Statement :- Given a string s, return the longest palindromic substring in s.
    Approach 1: Brute force -> check all the substrings for the palindrome. This will take time complexity of O(n^3)
    Approach 2: Dynamic Programming -> Time complexity O(n^2) using extra space of O(n^2)
 */
public class Problem5 {
        public static String longestPalindrome(String s) {
        String [][] palindrome = new String[s.length()][s.length()];
        return palindromeHelper(s, 0, s.length()-1, palindrome);
    }

    /*
        Solution 1. Top Down Recursive:
        if(the first char == last char) then there can be two scenarios :
            1. the substring excluding first char and last char itself is a palindrome in which case the entire string is the palindrome
            2. the substring excluding first and last char is not palindrome in which case the longest palindrome substring exist in either first to last-1 substring or first+1 to last substring
        else:
            the substring excluding first and last char is not palindrome in which case the longest palindrome substring exist in either first to last-1 substring or first+1 to last substring
        Base case:
        String of length 1 is inherently palindrome
        if length is 2 and both chars are same then it is palindrome
     */
    private static String palindromeHelper(String s, int i, int j, String[][] palindrome){
        if (palindrome[i][j] != null)  // Means we have already calculated the string for i, j
            return palindrome[i][j];
        if (i == j) // base case for string length 1 which is inherently palindrome
            palindrome[i][j] = s.charAt(i) + "";
        else if(j-i == 1){ // for string of length 2
            if (s.charAt(i) == s.charAt(j)) // both the characrets are same hence its a palindrome
                palindrome[i][j] = "" + s.charAt(i) + s.charAt(j);
            else
                palindrome[i][j] = "" +s.charAt(i); // we can consider only one character as palindrome
        }
        else { // for strings of length > 2
            if (s.charAt(i) == s.charAt(j)){ // if first and last characters are same then
                String x = palindromeHelper(s, i + 1, j - 1, palindrome); // checking for substring (i+1, j-1)
                if (x.equals(s.substring(i+1, j)))
                    palindrome[i][j] = s.substring(i, j+1); // case when the substring excluding first and last char itself is a palindrome
                else {
                    palindrome[i][j] = palindromeHelper(s, i+1, j, palindrome).length() > palindromeHelper(s, i, j-1, palindrome).length() ? palindromeHelper(s, i+1, j, palindrome) :  palindromeHelper(s, i, j-1, palindrome);
                    // above line is setting the longer of the two cases:- 1. when we exlude first char 2. when we exclude last char
                }
            }
            else {
                palindrome[i][j] = palindromeHelper(s, i+1, j, palindrome).length() > palindromeHelper(s, i, j-1, palindrome).length() ? palindromeHelper(s, i+1, j, palindrome) :  palindromeHelper(s, i, j-1, palindrome);
                // above line is setting the longer of the two cases:- 1. when we exlude first char 2. when we exclude last char
            }
        }
        return palindrome[i][j];
    }

    /*
        Solution 2: Bottom up
        Here we will use a boolean 2D matrix to store the info that whether the subsring i, j is a palindrome or not.
        all string of length 1 is inherently palindrome. similarly if the length is 2 and both characters are same then its a palindrome
        if (length > 2)
           then the recursive logic applies as it is
     */
    public static String longestPalindromeBottomUp(String s) {
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++){
            palindrome[i][i] = true; // initializing for length 1
            if(i < s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                palindrome[i][i+1] = true; // initializing for length 2
                start = i;
                end = i+1;
            }
        }

        for (int l = 3; l <= s.length(); l++){  // l denotes the length which goes from 3 to the length of the string
            for (int i = 0; i <= s.length() - l; i++){  // for each strin of length l
                palindrome[i][i+l-1] = s.charAt(i) == s.charAt(i+l-1) && palindrome[i+1][i+l-2];  // case when the string is palindrome
                if(palindrome[i][i+l -1]){  // if its a palindrome updating start and end because we are moving toward increasing length of the string
                    start = i;
                    end = i+l-1;
                }
            }
        }
        return s.substring(start, end+1);
    }

}
