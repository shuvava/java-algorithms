package com.github.shuvava.problems.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * * iven a 2D board and a word, find if the word exists in the grid.
 *
 * <p>The word can be constructed from letters of sequentially adjacent cell, where "adjacent"
 * cells
 * are those horizontally or vertically neighboring. The same letter cell may not be used more than
 * once.
 *
 * <p>Example:
 *
 * <p>board = [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
 *
 * <p>Given word = "ABCCED", return true. Given word = "SEE", return true. Given word = "ABCB",
 * return false.
 *
 * <p>Constraints:
 *
 * <p>board and word consists only of lowercase and uppercase English letters. 1 <= board.length <=
 * 200 1 <= board[i].length <= 200 1 <= word.length <= 10^3
 */
public class WordSearch {

  private final Tuple[] neighbors = new Tuple[]{
      new Tuple(0, 1), new Tuple(1, 0),
      new Tuple(0, -1), new Tuple(-1, 0)
  };

  public boolean exist(char[][] board, String word) {
    int letters = word.length();
    int rows = board.length;
    if (rows == 0) {
      return false;
    }
    int cols = board[0].length;
    if (letters > rows * cols) {
      return false;
    }
    WordSearchConfig config = new WordSearchConfig(rows, cols, letters, board, word);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (board[i][j] == word.charAt(0)) {
          Tuple point = new Tuple(i, j);
          Set<Tuple> stack = new HashSet<>() {{
            add(point);
          }};
          boolean check = dfs(config, i, j, stack, 1);
          if (check) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean dfs(WordSearchConfig config, int x, int y, Set<Tuple> stack, int count) {
    if (count == config.letters) {
      return true;
    }
    for (Tuple neighbor : neighbors) {
      int x2 = x + neighbor.x;
      int y2 = y + neighbor.y;
      Tuple point = new Tuple(x2, y2);
      if (0 <= x2 && x2 < config.rows && 0 <= y2 && y2 < config.cols && !stack.contains(point)) {
        if (config.board[x2][y2] == config.word.charAt(count)) {
          stack.add(point);
          boolean check = dfs(config, x2, y2, stack, count + 1);
          if (check) {
            return true;
          }
          stack.remove(point);
        }
      }
    }
    return false;
  }
}

class WordSearchConfig {

  public final int rows;
  public final int cols;
  public final int letters;
  public final char[][] board;
  public final String word;

  WordSearchConfig(int rows, int cols, int letters, char[][] board, String word) {
    this.rows = rows;
    this.cols = cols;
    this.letters = letters;
    this.board = board;
    this.word = word;
  }
}

class Tuple {

  public final int x;
  public final int y;

  public Tuple(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "(" + x + "," + y + ")";
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }

    if (!(other instanceof Tuple)) {
      return false;
    }

    Tuple other_ = (Tuple) other;

    // this may cause NPE if nulls are valid values for x or y. The logic may be improved to handle nulls properly, if needed.
    return other_.x == this.x && other_.y == this.y;
  }

}