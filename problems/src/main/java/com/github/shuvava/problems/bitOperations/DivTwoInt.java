package com.github.shuvava.problems.bitOperations;

public class DivTwoInt {

  public int divide(int dividend, int divisor) {
    boolean isNegative = false;
    long div = dividend;
    long divor = divisor;
    if (div < 0) {
      isNegative = true;
      div = -div;
    }
    if (divisor < 0) {
      isNegative = !isNegative;
      divor = -divor;
    }
    long[] vals = new long[34];
    int max = 0;
    long test = divor;
    vals[0] = test;
    while (div >= test) {
      test = test << 1;
      max += 1;
      vals[max] = test;
    }
    long diff = div;
    long res = 0;
    for (int i = max; i >= 0; i--) {
      if (diff >= vals[i]) {
        diff -= vals[i];
        res += (long) 1 << i;
      }
    }
    if (isNegative) {
      res = -res;
    }
    if (res > Integer.MAX_VALUE) {
      res = Integer.MAX_VALUE;
    }
    if (res < Integer.MIN_VALUE) {
      res = Integer.MIN_VALUE;
    }
    return (int) res;
  }
}
