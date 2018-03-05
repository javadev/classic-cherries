package org.paukov.backtracking;

import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Created by dpaukov on 3/4/18.
 */
public class AllSubsets extends Backtracking<Boolean, Integer> {

    @Override
    protected boolean isSolution(Boolean[] vector, int k, Integer dataInput) {
        return k == dataInput;
    }

    @Override
    protected void processSolution(Boolean[] vector, int k, Integer dataInput) {
        System.out.print("{");
        for (int i = 1; i <= dataInput; i++) {
            if (vector[i] == TRUE) System.out.print(i);
        }
        System.out.print("}");
    }

    @Override
    protected List<Boolean> constructCandidates(Boolean[] vector, int k, Integer dataInput) {
        return Arrays.asList(TRUE, FALSE);
    }

    @Override
    protected void makeMove(Boolean[] vector, int k, Integer dataInput) {
        // Nothing to do here
    }

    @Override
    protected void unmakeMove(Boolean[] vector, int k, Integer dataInput) {
        // Nothing to do here
    }

    public static void main(String[] args) {
        AllSubsets allSubsets = new AllSubsets();
        Boolean[] vector = new Boolean[4];
        allSubsets.run(vector, 0, 3);
    }
}
