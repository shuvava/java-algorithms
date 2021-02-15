package com.github.shuvava.arrays;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians),
 * return the indexes of the k weakest rows in the matrix ordered from the weakest to the
 * strongest.
 * <p>
 * A row i is weaker than row j, if the number of soldiers in row i is less than the number of
 * soldiers in row j, or they have the same number of soldiers but i is less than j. Soldiers are
 * always stand in the frontier of a row, that is, always ones may appear first and then zeros.
 * Constraints: m == mat.length n == mat[i].length 2 <= n, m <= 100 1 <= k <= m matrix[i][j] is
 * either 0 or 1.
 */
public class MatrixWeakestRow {

  public static List<Integer> kWeakestRows(List<List<Integer>> mat, int k) {
    var result = new ArrayList<Entry<Long, Integer>>();
    if (k == 0 || mat.size() == 0) {
      return new ArrayList<>();
    }

    for (int i = 0; i < mat.size(); i++) {
      var row = mat.get(i);
      result.add(new SimpleEntry<>(row.stream()
        .mapToLong(Integer::longValue)
        .sum(), i));
    }

    result.sort(Entry.comparingByKey());

    return result.stream()
      .limit(k)
      .map(Entry::getValue)
      .collect(Collectors.toList());
  }
}
