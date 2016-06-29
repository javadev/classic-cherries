package org.paukov.exercise;


import java.util.*;

/**
 * Given four digits, find the maximum valid time that can be displayed on
 * a digital clock (in 24 -hour format) using those digits. for example,
 * given digits 2,3,5,9 the maximum valid time is "23:59". note that "24:39"
 * is not a valid time.
 */
public class MaxPossibleTime {


    List<Integer> calc(List<Integer> input) {
        List<Integer> output = new ArrayList<Integer>();
        Collections.sort(input, Collections.reverseOrder());
        if (findSolutions(0, output, input)) {
            return output;
        } else {
            return null;
        }
    }

    boolean findSolutions(int n, List<Integer> output, List<Integer> input) {

        if (output.size() == 4) {
            System.out.println(output);
            return true;
        }

        for (int i=0; i<input.size(); i++) {
            Integer val = input.get(i);
            if (isValid(val, n, output)) {
                applyValue(val, n, output);
                List<Integer> newInput = new ArrayList<Integer>();
                for (int j=0; j<input.size(); j++) {
                    if ( i != j) {
                        newInput.add(input.get(j));
                    }
                }

                if (findSolutions(n+1, output, newInput))
                    return true;
                removeValue(val, n, output);
            }
        }
        return false;
    }


    boolean isValid(Integer value, int n,  List<Integer> output){
        return isGoodCandidate(output, value);
    }

    void applyValue(Integer value, int n,  List<Integer> output){
        if (output.size() > n)
            output.set(n, value);
        else
            output.add(n, value);
    }

    void removeValue(Integer value, int n,  List<Integer> output){
        output.remove(n);
    }

    boolean isGoodCandidate(List<Integer> result, Integer candidate){
        if (result.isEmpty()) {
            return checkH1(result, candidate);
        } else if (result.size()==1) {
            return checkH2(result, candidate);
        } else if (result.size()==2) {
            return checkM1(result, candidate);
        } else if (result.size()==3) {
            return checkM2(result, candidate);
        }
        return false;
    }

    boolean checkH1(List<Integer> result, Integer candidate){
        return candidate>=0 && candidate<=2;
    }

    boolean checkH2(List<Integer> result, Integer candidate){
        Integer d1 = result.get(0);
        Integer d2 = candidate;
        if (d1 == 2 && d2 > 3) {
            return false;
        } else if (d2 < 0 || d2 > 9) {
            return false;
        }
        return true;
    }

    boolean checkM1(List<Integer> result, Integer candidate){
        Integer d3 = candidate;
        if (d3 < 0 || d3 > 5) {
            return false;
        }
        return true;
    }

    boolean checkM2(List<Integer> result, Integer candidate){
        Integer d4 = candidate;
        if (d4 < 0 || d4 > 9) {
            return false;
        }
        return true;
    }

}
