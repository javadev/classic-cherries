package org.paukov.exercise;

/**
 * Determine whether an integer is a palindrome.
 */
public class PalindromeNumber {

    private int pow10(int p){
        int res = 1;
        for (int i = 0; i < p; i++){
            res *= 10;
        }
        return res;
    }

    public boolean isPalindrome(int value){
        if (value < 0) return false;
        int n = (int)Math.log10(value) + 1;
        int lvalue = value;
        for (int i = 1; i < n; i++){
            int pow = pow10(n - i);
            int l = lvalue / pow;
            lvalue = lvalue % pow;
            int rvalue = value;
            int j = 0;
            int r = -1;
            while( j < i) {
                r = rvalue % 10;
                rvalue /= 10;
                j++;
            }
            if (l !=r ) return false;
        }
        return true;
    }
}
