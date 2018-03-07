package org.paukov.backtracking;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dpaukov on 3/6/18.
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is: "((()))", "(()())", "(())()", "()(())", "()()()".
 */
public class GenerateParentheses extends Backtracking<String, Integer> {

    private long count = 0;

    protected boolean isSolution(String[] vector, int k, Integer dataInput) {
        return (k == 2 * dataInput);
    }

    protected void processSolution(String[] vector, int k, Integer dataInput) {
        int balance = 0;
        int i = 1;
        while (balance >= 0 && i <= k) {
            if (vector[i] == "(") {
                balance++;
            } else if (vector[i] == ")") {
                balance--;
            } else {
                throw new RuntimeException("Unsupported symbol: " + vector[i]);
            }
            i++;
        }
        if (balance == 0) {
            count++;
            System.out.printf("%4d: ", count);
            for (i = 1; i <= k; i++) {
                System.out.print(vector[i]);
            }
            System.out.println();
        }
    }

    protected List<String> constructCandidates(String[] vector, int k, Integer dataInput) {
        return Arrays.asList("(", ")");
    }

    protected void makeMove(String[] vector, int k, Integer dataInput) {
        // nothing here
    }

    protected void unmakeMove(String[] vector, int k, Integer dataInput) {
        // nothing here
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        String[] vector = new String[10];
        generateParentheses.run(vector, 0, 3);
    }
}
