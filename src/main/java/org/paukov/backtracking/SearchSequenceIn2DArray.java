package org.paukov.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dpaukov on 3/31/18.
 * <p>
 * Given A is a matrix and S is an array of integers, we say S occurs in A if you can start from some entry in
 * A and traverse adjacent entries in A in the order prescribed by S.
 * Adjacent entries are top, bottom, left and right ones.
 * It is possible to visit an entry in the matrix A more than once.
 * <p>
 * For example, if A =
 * [1 2 3
 * 3 4 5
 * 5 6 7]
 * S = [1 3 4 6]
 * Then S is in A, because A[0][0] = 1, A[1][0] = 3, A[1][1] = 4, A[2][1] = 6
 */
public class SearchSequenceIn2DArray extends Backtracking<SearchSequenceIn2DArray.Cell, SearchSequenceIn2DArray.Grid> {

    Cell[] vector = new Cell[]{};

    static class Cell {
        final int i;
        final int j;

        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "(" + i + "," + j + ')';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Cell cell = (Cell) o;

            if (i != cell.i) return false;
            return j == cell.j;
        }

        @Override
        public int hashCode() {
            return 31 * i + j;
        }
    }

    static class Grid {
        final int[][] matrix;
        final int[] pattern;
        final List<SearchSequenceIn2DArray.Cell> move = new ArrayList<>();

        public Grid(int[][] matrix, int[] pattern) {
            this.matrix = matrix;
            this.pattern = pattern;
        }

        List<Cell> possibleNextCell(Cell cell, int k) {
            List result = new ArrayList();
            int i = cell.i;
            int j = cell.j;
            int nextValue = pattern[k];
            int gridSize = matrix.length;
            if (matrix[i][j] == nextValue) {
                result.add(new Cell(i, j));
            }
            if (i > 0) {
                if (matrix[i - 1][j] == nextValue) {
                    result.add(new Cell(i - 1, j));
                }
            }
            if (i < gridSize - 1) {
                if (matrix[i + 1][j] == nextValue) {
                    result.add(new Cell(i + 1, j));
                }
            }
            if (j > 0) {
                if (matrix[i][j - 1] == nextValue) {
                    result.add(new Cell(i, j - 1));
                }
            }
            if (j < gridSize - 1) {
                if (matrix[i][j + 1] == nextValue) {
                    result.add(new Cell(i, j + 1));
                }
            }
            return result;
        }

        int[] getPath(Cell[] vector, int k) {
            int[] result = new int[k];
            for (int i = 1; i <= k; i++) {
                result[i - 1] = matrix[vector[i].i][vector[i].j];
            }
            return result;
        }
    }


    @Override
    protected boolean isSolution(Cell[] vector, int k, Grid dataInput) {
        return dataInput.pattern.length == k;
    }

    @Override
    protected void processSolution(Cell[] vector, int k, Grid dataInput) {
        if (dataInput.pattern.length == 0){
            return; //empty pattern
        }

        Cell lastVisited = vector[k];
        if (dataInput.pattern[k - 1] == dataInput.matrix[lastVisited.i][lastVisited.j]) {
            System.out.println("Vector: " + Arrays.toString(vector) + ", path: "
                    + Arrays.toString(dataInput.getPath(vector, k)));
            finished = true;
            this.vector = vector;
        }
    }

    @Override
    protected List<Cell> constructCandidates(Cell[] vector, int k, Grid dataInput) {
        List<Cell> result = new ArrayList<>();

        if (dataInput.pattern.length == 0){
            return result; //empty pattern
        }

        if (k == 0) {
            for (int i = 0; i < dataInput.matrix.length; i++) {
                for (int j = 0; j < dataInput.matrix[i].length; j++) {
                    result.add(new Cell(i, j));
                }
            }
            return result;
        } else {
            Cell lastVisited = vector[k];
            if (dataInput.pattern[k - 1] == dataInput.matrix[lastVisited.i][lastVisited.j]) {
                return dataInput.possibleNextCell(lastVisited, k);
            }
        }
        return result;
    }

    static Cell[] calculate(int[][] matrix, int[] pattern) {
        SearchSequenceIn2DArray searchSequenceIn2DArray = new SearchSequenceIn2DArray();
        Grid grid = new Grid(matrix, pattern);
        searchSequenceIn2DArray.run(new Cell[pattern.length + 1], 0, grid);
        return searchSequenceIn2DArray.vector;
    }


    public static void main(String[] args) {
        SearchSequenceIn2DArray searchSequenceIn2DArray = new SearchSequenceIn2DArray();
        int[][] matrix = new int[][]{{1, 2, 3}, {3, 4, 5}, {5, 6, 7}};
        int[] pattern = new int[]{1, 3, 4, 6, 5, 3};
        searchSequenceIn2DArray.calculate(matrix, pattern);
    }
}
