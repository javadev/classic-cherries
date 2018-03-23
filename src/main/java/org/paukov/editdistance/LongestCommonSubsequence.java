package org.paukov.editdistance;

import java.util.List;

/**
 * Created by dpaukov on 3/23/18.
 * <p>
 * Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 */
public class LongestCommonSubsequence extends EditDistance {

    public LongestCommonSubsequence(String source, String target) {
        super(source, target);
    }

    @Override
    int matchOrSubstituteCost(char s, char t) {
        if (s == t) {
            return 0;
        } else {
            return 10;
        }
    }

    public String calculate() {
        List<String> substrings = compare().getCommonSubstrings();
        StringBuilder builder = new StringBuilder();
        for (String s : substrings) {
            builder.append(s);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence("democrat", "republican");
        Matrix matrix = lcs.compare();
        System.out.println("Distance:   " + matrix.getEditDistance());
        System.out.println("Operations: " + matrix.getEditDistanceOperations());
        System.out.println("Symbols:    " + matrix.getEditDistanceSymbols());
        System.out.println("Common:     " + matrix.getCommonSubstrings());

        LongestCommonSubsequence lcs2 = new LongestCommonSubsequence("ABCDGH", "AEDFHR");
        Matrix matrix2 = lcs2.compare();
        System.out.println("Distance:   " + matrix2.getEditDistance());
        System.out.println("Operations: " + matrix2.getEditDistanceOperations());
        System.out.println("Symbols:    " + matrix2.getEditDistanceSymbols());
        System.out.println("Common:     " + matrix2.getCommonSubstrings());
    }
}
