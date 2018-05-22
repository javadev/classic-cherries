package org.paukov.editdistance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dpaukov on 3/22/18.
 *
 * Given two words word1 and word2, find the minimum number of
 * steps required to convert word1 to word2. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 * a) Insert a character
 * b) Delete a character
 * c) Substitute a character
 *
 * https://leetcode.com/problems/edit-distance/description/
 */
public class EditDistance {

  String source;
  String target;

  public EditDistance(String source, String target) {
    this.source = source;
    this.target = target;
  }

  int matchOrSubstituteCost(char s, char t) {
    if (s == t) {
      return 0;
    } else {
      return 1;
    }
  }

  int insertOrDeleteCost(char s) {
    return 1;
  }

  Matrix compare() {
    int[] operations = new int[3];
    Matrix matrix = new Matrix(source, target);

    for (int i = 0; i <= target.length(); i++) {
      matrix.initRow(i);
    }
    for (int j = 0; j <= source.length(); j++) {
      matrix.initColumn(j);
    }

    for (int i = 1; i <= source.length(); i++) {
      for (int j = 1; j <= target.length(); j++) {
        int previousMatchCost = matrix.getCost(i - 1, j - 1);
        int previousInsertCost = matrix.getCost(i, j - 1);
        int previousDeleteCost = matrix.getCost(i - 1, j);

        operations[Matrix.MATCH] =
            previousMatchCost + matchOrSubstituteCost(source.charAt(i - 1), target.charAt(j - 1));
        operations[Matrix.INSERT] = previousInsertCost + insertOrDeleteCost(target.charAt(j - 1));
        operations[Matrix.DELETE] = previousDeleteCost + insertOrDeleteCost(source.charAt(i - 1));

        // find the minimum of the available operation's costs
        matrix.setCell(i, j, operations[Matrix.MATCH], Matrix.MATCH);

        for (int k = Matrix.INSERT; k <= Matrix.DELETE; k++) {
          if (operations[k] < matrix.getCost(i, j)) {
            matrix.setCell(i, j, operations[k], k);
          }
        }
      }
    }
    return matrix;
  }

  public static class Matrix {

    private static final int UNKNOWN = -1;
    private static final int MATCH = 0;
    private static final int INSERT = 1;
    private static final int DELETE = 2;
    String source;
    String target;
    Cell[][] matrix;

    Matrix(String source, String target) {
      this.source = source;
      this.target = target;
      this.matrix = new Cell[source.length() + 1][target.length() + 1];
      for (int i = 0; i <= source.length(); i++) {
        for (int j = 0; j <= target.length(); j++) {
          this.matrix[i][j] = new Cell();
        }
      }
    }

    private void initRow(int i) {
      matrix[0][i].cost = i;
      if (i > 0) {
        matrix[0][i].parent = INSERT;
      } else {
        matrix[0][i].parent = UNKNOWN;
      }
    }

    private void initColumn(int j) {
      matrix[j][0].cost = j;
      if (j > 0) {
        matrix[j][0].parent = DELETE;
      } else {
        matrix[j][0].parent = UNKNOWN;
      }
    }

    int getCost(int i, int j) {
      return matrix[i][j].cost;
    }

    int getParent(int i, int j) {
      return matrix[i][j].parent;
    }

    private void setCell(int i, int j, int cost, int parent) {
      matrix[i][j].cost = cost;
      matrix[i][j].parent = parent;
    }

    public int getEditDistance() {
      return matrix[source.length()][target.length()].cost;
    }

    public String getEditDistanceOperations() {
      StringBuilder builder = reconstructPath(source.length(), target.length(), new StringBuilder(),
          (source, target, i, j, path) -> {
            if (source.charAt(i - 1) == target.charAt(j - 1)) {
              path.append('-'); // Match - nothing to do
            } else {
              path.append('S'); // Substitute
            }
          },
          (source, target, i, j, path) -> path.append('I'), // Insert
          (source, target, i, j, path) -> path.append('D')  // Delete
      );
      return builder.toString();
    }

    public String getEditDistanceSymbols() {
      StringBuilder builder = reconstructPath(source.length(), target.length(), new StringBuilder(),
          (source, target, i, j, path) -> {
            if (source.charAt(i - 1) == target.charAt(j - 1)) {
              path.append(source.charAt(i - 1));
            } else {
              path.append(target.charAt(j - 1));
            }
          },
          (source, target, i, j, path) -> path.append(target.charAt(j - 1)),
          (source, target, i, j, path) -> path.append('~')
      );
      return builder.toString();
    }

    /**
     * Returns common non-overlapping sub-strings
     */
    public List<String> getCommonSubstrings() {
      String operations = getEditDistanceOperations();
      String symbols = getEditDistanceSymbols();

      List<String> result = new ArrayList<>();
      int index = 0;

      StringBuilder builder = new StringBuilder();
      for (char c : operations.toCharArray()) {
        if (c == '-') {
          builder.append(symbols.charAt(index));
        } else {
          String subString = builder.toString();
          if (!subString.isEmpty()) {
            result.add(builder.toString());
          }
          builder = new StringBuilder();
        }
        index++;
      }
      String subString = builder.toString();
      if (!subString.isEmpty()) {
        result.add(builder.toString());
      }
      return result;
    }

    private StringBuilder reconstructPath(
        int i, int j, StringBuilder path, OutFunction matchOut, OutFunction insertOut,
        OutFunction deleteOut) {
      if (getParent(i, j) == UNKNOWN) {
        return path;
      }
      if (getParent(i, j) == MATCH) {
        reconstructPath(i - 1, j - 1, path, matchOut, insertOut, deleteOut);
        matchOut.apply(source, target, i, j, path);
      }
      if (getParent(i, j) == INSERT) {
        reconstructPath(i, j - 1, path, matchOut, insertOut, deleteOut);
        insertOut.apply(source, target, i, j, path);
      }
      if (getParent(i, j) == DELETE) {
        reconstructPath(i - 1, j, path, matchOut, insertOut, deleteOut);
        deleteOut.apply(source, target, i, j, path);
      }
      return path;
    }

    interface OutFunction {

      void apply(String source, String target, int i, int j, StringBuilder path);
    }

    private class Cell {

      int cost;
      int parent;
    }

  }
}
