package com.github.shuvava.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

  private static boolean getBit(int value, int bit) {
    value = value & (1 << bit);
    return value != 0;
  }

  private static int setBit(int value, int bit) {
    return value | (1 << bit);
  }

  /**
   * Algorithm using bit operation instead hash map
   *
   * @param board Sudoku board
   * @return true if sudoku is valid
   */
  public static boolean isValidSudoku(List<List<Character>> board) {
    var row = new int[9];
    var col = new int[9];
    var square = new int[9];
    var rlen = board.size();
    var clen = board.get(0).size();
    for (int i = 0; i < rlen; i++) {
      for (int j = 0; j < clen; j++) {
        var val = board.get(i).get(j);
        if (val.equals('.')) {
          continue;
        }
        var valInt = Integer.parseInt(val.toString()) - 1;
        if (getBit(row[i], valInt)) {
          return false;
        }
        row[i] = setBit(row[i], valInt);

        if (getBit(col[j], valInt)) {
          return false;
        }
        col[j] = setBit(col[j], valInt);

        var k = (i / 3) * 3 + (j / 3);
        if (getBit(square[k], valInt)) {
          return false;
        }
        square[k] = setBit(square[k], valInt);
      }
    }

    return true;
  }

  public boolean isValidSudoku(char[][] board) {
    HashSet[] rows = new HashSet[9];
    for (int i = 0; i < 9; i++) {
      rows[i] = new HashSet<>();
    }
    Set<Character>[] columns = new HashSet[9];
    for (int i = 0; i < 9; i++) {
      columns[i] = new HashSet<>();
    }
    HashSet[] boxes = new HashSet[9];
    for (int i = 0; i < 9; i++) {
      boxes[i] = new HashSet<>();
    }
    for (int x = 0; x < 9; x++) {
      for (int y = 0; y < 9; y++) {
        char c = board[x][y];
        if (c == '.') {
          continue;
        }
        HashSet row = rows[x];
        Set<Character> column = columns[y];
        int boxId = (x / 3) * 3 + y / 3;
        HashSet box = boxes[boxId];
        if (row.contains(c) || column.contains(c) || box.contains(c)) {
          return false;
        }
        row.add(c);
        column.add(c);
        box.add(c);
      }
    }
    return true;
  }
}
