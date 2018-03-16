package org.paukov.backtracking;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Created by dpaukov on 3/4/18.
 */
public class AllPermutations extends Backtracking<Integer, Integer> {
    @Override
    protected boolean isSolution(Integer[] vector, int k, Integer dataInput) {
        return k == dataInput;
    }

    @Override
    protected void processSolution(Integer[] vector, int k, Integer dataInput) {
        for (int i = 1; i <= k; i++) {
            System.out.print(vector[i]);
        }
        System.out.println();
    }

    @Override
    protected List<Integer> constructCandidates(Integer[] vector, int k, Integer dataInput) {
        List<Integer> result = new ArrayList<Integer>();
        boolean[] in_perm = new boolean[dataInput + 1];
        for (int i = 0; i <= k; i++) {
            in_perm[vector[i]] = TRUE;
        }
        for (int i = 1; i <= dataInput; i++) {
            if (in_perm[i] == FALSE) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AllPermutations allPermutations = new AllPermutations();
        Integer[] vector = new Integer[100];
        vector[0] = 0;
        allPermutations.run(vector, 0, 3);
    }
}
