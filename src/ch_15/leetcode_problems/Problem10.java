package ch_15.leetcode_problems;

public class Problem10 {

    /*
        Problem :- Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
        '.' Matches any single character.
        '*' Matches zero or more of the preceding element.
       The matching should cover the entire input string (not partial).

       Solution :- if pattern has ended then the string must have been ended otherwise it's not a match
       if pattern has not ended match the first character and if there is one more char left and it's a '*' then we can either ignore the result of the match and assume that current char
       in the pattern is not a match or we can consider the match and assume that 'a*' has expanded to aa* in which case the pattern will remain same but string will move by one char.
       If this explanation is unclear please check the code below.
     */

    // Approach 1 : Recursive
    public static boolean regexPatternMatchingRecursive(String s, String p){
        return regexPatternMatchingRecursiveHelper(s, p, 0, 0); // i will keep track of the present char of string s (which is our txt) and j keep track of char in patter
    }

    private static boolean regexPatternMatchingRecursiveHelper(String s, String p, int i, int j) {
        if (j == p.length()) // pattern has ended
            return i == s.length();
        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'); // Matching the first character of the string and pattern
        if (j + 1 < p.length() && p.charAt(j+1) == '*'){ // if next char is present in pattern and it is equal to * then two scenarios are possible
            return regexPatternMatchingRecursiveHelper(s, p, i, j + 2) || // we can ignore the current match of the pattern and move forward to the next char which will signify that * is 0 occurrence of that char
                    firstMatch && regexPatternMatchingRecursiveHelper(s, p, i+1, j);// We will consider the match and move the string one char further but the pattern will be same which will signify that *
            // is 1 or more occurrence of that char.
        }
        else { // next char in pattern is either not present or its not * which makes it mandatory to consider the first match and move 1 char ahead in both pattern and string
            return firstMatch && regexPatternMatchingRecursiveHelper(s, p, i+1, j+1);
        }
    }

    // Approach 2: DP Top Down -> The above approach works fine but it takes lot of time. So, lets apply dp to reduce the function calls
    // Here code will be same as above but only change will be we will be using an array to store the result of the matches
    public static boolean regexPatternMatchingTopDown(String s, String p){
        Boolean [][] match = new Boolean[s.length()+1][p.length()+1]; // Here Boolean can have three values -> null, true, false which will correspond to not yet calculated, not matched and matched respectively
        return regexPatternMatchingTopDownHelper(s, p, 0, 0, match); // i will keep track of the present char of string s (which is our txt) and j keep track of char in pattern
    }

    private static boolean regexPatternMatchingTopDownHelper(String s, String p, int i, int j, Boolean[][] match) {
        if (match[i][j] != null)
            return match[i][j];
        if (j == p.length()) { // pattern has ended which is our base case
            match[i][j] = i == s.length();
            return match[i][j];
        }
        boolean finalAnswer = false;// we can initialize with any value
        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'); // Matching the first character of the string and pattern
        if (j + 1 < p.length() && p.charAt(j+1) == '*'){ // if next char is present in pattern and it is equal to * then two scenarios are possible
            finalAnswer = regexPatternMatchingTopDownHelper(s, p, i, j + 2, match) || // we can ignore the current match of the pattern and move forward to the next char which will signify that * is 0 occurrence of that char
                    firstMatch && regexPatternMatchingTopDownHelper(s, p, i+1, j, match);// We will consider the match and move the string one char further but the pattern will be same which will signify that *
            // is 1 or more occurrence of that char.
        }
        else { // next char in pattern is either not present or its not * which makes it mandatory to consider the first match and move 1 char ahead in both pattern and string
            finalAnswer = firstMatch && regexPatternMatchingTopDownHelper(s, p, i+1, j+1, match);
        }
        match[i][j] = finalAnswer;
        return finalAnswer;
    }

    // Approach 3: DP Bottom up
    public static boolean regexPatternMatchingBottomUp(String s, String p){
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        match[s.length()][p.length()] = true; // since this would mean both p and s are exhausted
        for (int i = s.length(); i >= 0; i--){
            for (int j = p.length() - 1; j >= 0; j--){
                boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j + 1 < p.length() && p.charAt(j+1) == '*'){
                    match[i][j] = match[i][j+2] || firstMatch && match[i+1][j];
                }
                else {
                    match[i][j] = firstMatch && match[i+1][j+1];
                }
            }
        }
        return match[0][0];
    }

}
