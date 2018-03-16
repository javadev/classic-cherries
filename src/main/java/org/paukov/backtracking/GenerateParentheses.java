package org.paukov.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dpaukov on 3/6/18.
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is: "((()))", "(()())", "(())()", "()(())", "()()()".
 */
public class GenerateParentheses extends Backtracking<String, Integer> {

    private long count = 0;
    private List<String> result = new ArrayList<String>();

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
            StringBuilder builder = new StringBuilder();
            for (i = 1; i <= k; i++) {
                System.out.print(vector[i]);
                builder.append(vector[i]);
            }
            result.add(builder.toString());
            System.out.println();
        }
    }

    protected List<String> constructCandidates(String[] vector, int k, Integer dataInput) {
        return Arrays.asList("(", ")");
    }

    public static List<String> calc(Integer input) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        String[] vector = new String[input * 2 + 1];
        generateParentheses.run(vector, 0, input);
        return generateParentheses.result;
    }

    public static void main(String[] args) {
        GenerateParentheses.calc(3);
    }
}
