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

  public static void main(String[] args) {
    CommonSubstrings cs = new CommonSubstrings("hellodhkjhellohellokjdkjs11223344kjklj",
        "sdsdhellohelloellog122kkds");
    Matrix matrix = cs.compare();
    System.out.println("Distance:   " + matrix.getEditDistance());
    System.out.println("Operations: " + matrix.getEditDistanceOperations());
    System.out.println("Symbols:    " + matrix.getEditDistanceSymbols());
    System.out.println("Common:     " + matrix.getCommonSubstrings());

    CommonSubstrings cs2 = new CommonSubstrings("ABBCADGGHEEASSSCC", "ABDCADGGHMEASSSAC");
    Matrix matrix2 = cs2.compare();
    System.out.println("Distance:   " + matrix2.getEditDistance());
    System.out.println("Operations: " + matrix2.getEditDistanceOperations());
    System.out.println("Symbols:    " + matrix2.getEditDistanceSymbols());
    System.out.println("Common:     " + matrix2.getCommonSubstrings());


  }

  @Override
  int matchOrSubstituteCost(char s, char t) {
    if (s == t) {
      return 0;
    } else {
      return 10;
    }
  }

  public List<String> calculate() {
    EditDistance.Matrix matrix = compare();
    return matrix.getCommonSubstrings();
  }
}
