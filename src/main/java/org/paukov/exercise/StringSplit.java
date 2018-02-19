package org.paukov.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 2/18/18.
 */
public class StringSplit {

    private final Character symbol;

    public StringSplit(Character symbol) {
        this.symbol = symbol;
    }

    public List<String> split(String str){
        List<String> result = new ArrayList<String>();
        int i = -1, j = 0;
        while (j < str.length()) {
            if (str.charAt(j) == symbol) {
                if (i+1 < j) {
                    result.add(str.substring(i + 1, j));
                }
                i = j;
            }
            j++;
        }
        if (i+1 < str.length()) {
            result.add(str.substring(i + 1, str.length()));
        }
        return result;
    }
}
