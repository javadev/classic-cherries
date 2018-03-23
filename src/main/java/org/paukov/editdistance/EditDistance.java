package org.paukov.editdistance;

/**
 * Created by dpaukov on 3/22/18.
 */
public class EditDistance {

    public static class Matrix {

        private static final int UNKNOWN = -1;
        private static final int MATCH = 0;
        private static final int INSERT = 1;
        private static final int DELETE = 2;

        private class Cell {
            int cost;
            int parent;
        }

        String source;
        String target;
        Cell[][] matrix;

        private Matrix(String source, String target) {
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

        interface OutFunction {
            void apply(String source, String target, int i, int j, StringBuilder path);
        }

        public String getEditDistanceOperations() {
            StringBuilder builder = reconstructPath(source.length(), target.length(), new StringBuilder(),
                    (source, target, i, j, path) -> {
                        if (source.charAt(i - 1) == target.charAt(j - 1)) {
                            path.append('-');
                        } else {
                            path.append('S');
                        }
                    },
                    (source, target, i, j, path) -> path.append('I'),
                    (source, target, i, j, path) -> path.append('D')
            );
            return builder.toString();
        }

        public String getEditDistanceSymbols() {
            StringBuilder builder = reconstructPath(source.length(), target.length(), new StringBuilder(),
                    (source, target, i, j, path) -> {
                        if (source.charAt(i - 1) == target.charAt(j - 1)) {
                            path.append('-');
                        } else {
                            path.append(target.charAt(j - 1));
                        }
                    },
                    (source, target, i, j, path) -> path.append(target.charAt(j - 1)),
                    (source, target, i, j, path) -> path.append('D')
            );
            return builder.toString();
        }


        private StringBuilder reconstructPath(
                int i, int j, StringBuilder path, OutFunction matchOut, OutFunction insertOut, OutFunction deleteOut) {
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

    }

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

                operations[Matrix.MATCH] = previousMatchCost + matchOrSubstituteCost(source.charAt(i - 1), target.charAt(j - 1));
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
}