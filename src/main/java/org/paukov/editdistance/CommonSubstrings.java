package org.paukov.editdistance;

import java.util.List;

/**
 * Created by dpaukov on 3/22/18.
 * <p>
 * Calculates common non-overlapping sub-strings for two given strings.
 */
public class CommonSubstrings extends EditDistance {

    public CommonSubstrings(String str1, String str2) {
        super(str1, str2);
    }

    public List<String> calculate() {
        EditDistance.Matrix matrix = compare();
        return matrix.getCommonSubstrings();
    }

    public static void main(String[] args) {
        CommonSubstrings cs = new CommonSubstrings("hellodhkjhellohellokjdkjs11223344kjklj", "sdsdhellohelloellog122kkds");
        System.out.println(cs.calculate());
    }
}
