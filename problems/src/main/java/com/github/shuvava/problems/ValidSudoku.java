package com.github.shuvava.problems;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

  public boolean isValidSudoku(char[][] board) {
    Set<Character>[] rows = new HashSet[9];
    for (int i = 0; i < 9; i++) {
      rows[i] = new HashSet<>();
    }
    Set<Character>[] columns = new HashSet[9];
    for (int i = 0; i < 9; i++) {
      columns[i] = new HashSet<>();
    }
    Set<Character>[] boxes = new HashSet[9];
    for (int i = 0; i < 9; i++) {
      boxes[i] = new HashSet<>();
    }
    for (int x = 0; x < 9; x++) {
      for (int y = 0; y < 9; y++) {
        char c = board[x][y];
        if (c == '.') {
          continue;
        }
        Set<Character> row = rows[x];
        Set<Character> column = columns[y];
        int boxId = (x / 3) * 3 + y / 3;
        Set<Character> box = boxes[boxId];
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
