package org.paukov.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dpaukov on 3/13/18.
 * <p>
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * <p>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p>
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 */
public class RemoveInvalidParentheses extends Backtracking<Boolean, List<String>> {

    private int minRemoved = Integer.MAX_VALUE;
    private List<List<Boolean>> result = new ArrayList<List<Boolean>>();
    private long count = 0;

    protected boolean isSolution(Boolean[] vector, int k, List<String> dataInput) {
        return k == dataInput.size();
    }

    protected void processSolution(Boolean[] vector, int k, List<String> dataInput) {
        int balance = 0;
        int i = 1;
        while (balance >= 0 && i <= k) {
            if (vector[i]) {
                if (dataInput.get(i - 1).equals("(")) {
                    balance++;
                } else if (dataInput.get(i - 1).equals(")")) {
                    balance--;
                }
            }
            i++;
        }
        int removed = 0;
        if (balance == 0) {
            count++;
            System.out.printf("%4d: ", count);
            StringBuilder builder = new StringBuilder();
            for (i = 1; i <= k; i++) {
                if (vector[i]) {
                    System.out.print(dataInput.get(i - 1));
                    builder.append(dataInput.get(i - 1));
                } else {
                    removed++;
                }
            }

            if (removed < minRemoved) {
                minRemoved = removed;
                result.clear();
                result.add(new ArrayList<Boolean>(Arrays.asList(vector)));
            } else if (removed == minRemoved) {
                result.add(new ArrayList<Boolean>(Arrays.asList(vector)));
            }
            System.out.println(", removed=" + removed + ", minRemoved=" + minRemoved);
        }
    }

    protected List<Boolean> constructCandidates(Boolean[] vector, int k, List<String> dataInput) {
        if (dataInput.get(k).equals("(") || dataInput.get(k).equals(")")) {
            return Arrays.asList(Boolean.TRUE, Boolean.FALSE);
        } else {
            return Arrays.asList(Boolean.TRUE);
        }
    }

    protected void makeMove(Boolean[] vector, int k, List<String> dataInput) {
        // do nothing
    }

    protected void unmakeMove(Boolean[] vector, int k, List<String> dataInput) {
        // do nothing
    }

    public static Set<String> calc(String input) {
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
        Boolean[] vector = new Boolean[input.length() + 1];
        List<String> dataInput = Arrays.asList(input.split(""));
        removeInvalidParentheses.run(vector, 0, dataInput);
        Set<String> result = new HashSet<String>();
        for (List<Boolean> solution : removeInvalidParentheses.result) {
            StringBuilder solutionBuilder = new StringBuilder();
            for (int i = 1; i <= dataInput.size(); i++) {
                if (solution.get(i)) {
                    solutionBuilder.append(dataInput.get(i - 1));
                }
            }
            result.add(solutionBuilder.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses.calc("()())()");
    }
}
