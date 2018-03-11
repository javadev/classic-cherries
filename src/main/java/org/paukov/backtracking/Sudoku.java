package org.paukov.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dpaukov on 3/10/18.
 * Simple Sudoku solver based on the Backtracking algorithm.
 */
public class Sudoku extends Backtracking<Integer, Sudoku.Board> {
    private static final int DIMENSION = 9;
    private static final int CELLS = DIMENSION * DIMENSION;
    private static final int EMPTY_CELL = 0;

    static class Point {
        final int x;
        final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Board {
        int[][] matrix = new int[DIMENSION + 1][DIMENSION + 1];
        Point[] move = new Point[CELLS + 1];

        void setCellValue(int x, int y, int value) {
            matrix[x][y] = value;
        }

        void setCellValue(int k, int value) {
            matrix[move[k].x][move[k].y] = value;
        }

        void freeCell(int k) {
            matrix[move[k].x][move[k].y] = EMPTY_CELL;
        }

        void setMove(int k, Point p) {
            move[k] = p;
        }

        Point nextCell() {
            for (int i = 1; i <= DIMENSION; i++) {
                for (int j = 1; j <= DIMENSION; j++) {
                    if (matrix[i][j] == EMPTY_CELL) {
                        return new Point(i, j);
                    }
                }
            }
            return null;
        }

        Set<Integer> possibleValues(Point point) {
            Set<Integer> possible = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            for (int i = 1; i <= DIMENSION; i++) {
                possible.remove(matrix[i][point.y]);
                possible.remove(matrix[point.x][i]);
            }
            int sector_x = (point.x - 1) / 3;
            int sector_y = (point.y - 1) / 3;
            for (int i = 3 * sector_x + 1; i <= 3 * sector_x + 3; i++) {
                for (int j = 3 * sector_y + 1; j <= 3 * sector_y + 3; j++) {
                    possible.remove(matrix[i][j]);
                }
            }
            return possible;
        }

        void print() {
            System.out.println("Board:");
            System.out.println("|---------|---------|---------|");
            for (int i = 1; i <= DIMENSION; i++) {
                System.out.print("|");
                for (int j = 1; j <= DIMENSION; j++) {
                    if (matrix[i][j] != EMPTY_CELL) {
                        System.out.printf(" %d ", matrix[i][j]);
                    } else {
                        System.out.print("   ");
                    }
                    if (j % 3 == 0) {
                        System.out.print("|");
                    }
                }
                System.out.println();
                if (i % 3 == 0) {
                    System.out.println("|---------|---------|---------|");
                }
            }
        }
    }

    protected boolean isSolution(Integer[] vector, int k, Board dataInput) {
        Point point = dataInput.nextCell();
        return point == null;
    }

    protected void processSolution(Integer[] vector, int k, Board dataInput) {
        dataInput.print();
        finished = true;
    }

    protected List<Integer> constructCandidates(Integer[] vector, int k, Board dataInput) {
        ArrayList<Integer> candidates = new ArrayList<Integer>();
        Point point = dataInput.nextCell();
        if (point == null) {
            return candidates; // no candidates found
        }
        dataInput.setMove(k + 1, point);
        candidates.addAll(dataInput.possibleValues(point));
        return candidates;
    }

    protected void makeMove(Integer[] vector, int k, Board dataInput) {
        dataInput.setCellValue(k, vector[k]);
    }

    protected void unmakeMove(Integer[] vector, int k, Board dataInput) {
        dataInput.freeCell(k);
    }


    /**
     * Sudoku Board:
     * |---------|---------|---------|
     * |         |         |    1  2 |
     * |         |    3  5 |         |
     * |         | 6       |    7    |
     * |---------|---------|---------|
     * | 7       |         | 3       |
     * |         | 4       | 8       |
     * | 1       |         |         |
     * |---------|---------|---------|
     * |         | 1  2    |         |
     * |    8    |         |    4    |
     * |    5    |         | 6       |
     * |---------|---------|---------|
     * <p>
     * Solution:
     * |---------|---------|---------|
     * | 6  7  3 | 8  9  4 | 5  1  2 |
     * | 9  1  2 | 7  3  5 | 4  8  6 |
     * | 8  4  5 | 6  1  2 | 9  7  3 |
     * |---------|---------|---------|
     * | 7  9  8 | 2  6  1 | 3  5  4 |
     * | 5  2  6 | 4  7  3 | 8  9  1 |
     * | 1  3  4 | 5  8  9 | 2  6  7 |
     * |---------|---------|---------|
     * | 4  6  9 | 1  2  8 | 7  3  5 |
     * | 2  8  7 | 3  5  6 | 1  4  9 |
     * | 3  5  1 | 9  4  7 | 6  2  8 |
     * |---------|---------|---------|
     */
    public static void main(String[] args) {
        Board board = new Board();

        board.setCellValue(1, 8, 1);
        board.setCellValue(1, 9, 2);
        board.setCellValue(2, 5, 3);
        board.setCellValue(2, 6, 5);
        board.setCellValue(3, 4, 6);
        board.setCellValue(3, 8, 7);
        board.setCellValue(4, 1, 7);
        board.setCellValue(4, 7, 3);
        board.setCellValue(5, 4, 4);
        board.setCellValue(5, 7, 8);
        board.setCellValue(6, 1, 1);
        board.setCellValue(7, 4, 1);
        board.setCellValue(7, 5, 2);
        board.setCellValue(8, 2, 8);
        board.setCellValue(8, 8, 4);
        board.setCellValue(9, 2, 5);
        board.setCellValue(9, 7, 6);

        board.print();

        Sudoku sudoku = new Sudoku();
        Integer[] vector = new Integer[100];
        sudoku.run(vector, 0, board);
    }
}
