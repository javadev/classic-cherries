package org.paukov.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dpaukov on 3/12/18.
 * <p>
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters is just like on the telephone buttons is given.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationsPhoneNumber extends Backtracking<String, List<String>> {

    private String[][] mapping = {
            {}, {""},
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}};

    private List<String> result = new ArrayList<String>();

    protected boolean isSolution(String[] vector, int k, List<String> dataInput) {
        return k == dataInput.size();
    }

    protected void processSolution(String[] vector, int k, List<String> dataInput) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= k; i++) {
            builder.append(vector[i]);
            System.out.print(vector[i]);
        }
        result.add(builder.toString());
        System.out.println();
    }

    protected List<String> constructCandidates(String[] vector, int k, List<String> dataInput) {
        try {
            int number = Integer.parseInt(dataInput.get(k));
            return new ArrayList<String>(Arrays.asList(mapping[number]));
        } catch (NumberFormatException ex) {
            return new ArrayList<String>(); // no candidates
        }
    }

    public static List<String> calc(String input) {
        LetterCombinationsPhoneNumber letterCombinationsPhoneNumber = new LetterCombinationsPhoneNumber();
        letterCombinationsPhoneNumber.run(new String[input.length() + 1], 0, Arrays.asList(input.split("")));
        return letterCombinationsPhoneNumber.result;
    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber.calc("23");
    }
}
