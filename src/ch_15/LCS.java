package ch_15;


/*
    Problem :- We are given two Strings s1 and s2. Our task is to find the longest common subsequence in both the strings.
    Note :- Subsequence is different from substring. Substring is continuous where no character is skipped while in subsequence it is
    in increasing order and may skip the characters in between. For eg: For String "Bangalore", anlre is a valid subsequence but not valid substring.

    Solution :- Lets say we have two strings X(x1, x2, x3...xm) and Y(y1, y2, y3...yn). Here x1, x2... denotes the characters at 1st position 2nd position and so on...
    Similary, y1, y2...yn denotes the characters in String Y. Suppose the longest common subsequence is Z(z1, z2,z3...zk).
    Now there are two possible cases for x1 and y1.
    Case 1: x1 = y1
        In the above case z1 must be equal to x1. So, z1 = x1 = y1
    Case 2: x1 not equal to y1
        In the above case z1 will either belong to the X in which case we will have to X(x1, x2...xm) and Y(y2, y3...yn) assuming y1 is not present in z
        Similarly there is another possibility that x1 doesn't belong to the Z. So we will have to check the lcs if X(x2, x3...xm) and Y(y1, y2...yn)
 */

import java.util.Arrays;

public class LCS {
    public static String longestCommonSubsequence(String s1, String s2){
        int i = 0, j = 0;
        String[][] str = new String[s1.length()][s2.length()];
        longestCommonSubsequenceHelper(s1, s2, i, j, str);
        return  str[0][0];
    }

    private static String longestCommonSubsequenceHelper(String s1, String s2, int i, int j, String[][] str){
        String z = "";
        if (i == s1.length() || j == s2.length())
            return z;
        if(str[i][j] != null)
            return str[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            z = s1.charAt(i) + longestCommonSubsequenceHelper(s1, s2, i+1, j+1, str);
        }
        else {
            String z1 = longestCommonSubsequenceHelper(s1, s2, i+1, j, str);
            String z2 = longestCommonSubsequenceHelper(s1, s2, i, j+1, str);
            z = z1.length() > z2.length() ? z1 : z2;
        }
        str[i][j] = z;
        return  z;
    }
}
