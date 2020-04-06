package com.github.shuvava.problems.other;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * <p>A happy number is a number defined by the following process: Starting with any positive
 * integer, replace the number by the sum of the squares of its digits, and repeat the process until
 * the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include
 * 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * <p>Example:
 *
 * <p>Input: 19 Output: true Explanation: 12 + 92 = 82 82 + 22 = 68 62 + 82 = 100 12 + 02 + 02 = 1
 */
public class HappyNumber {

  /**
   * Since this problem is mathmetical by nature, there is usually some cheeky solution that has
   * linear time and constant space. Sometimes math can get a constant time solution but this is not
   * expected by the interviewer in most cases.
   * <p>
   * We know that when N=1, our result is happy. You have to be curious and wonder what is the next
   * number that is happy? This takes the provided problem's info and explores inputs further. So
   * you try 2, 3, 4, 5, 6, and finally 7. Another number that is happy is N=7. Now you try 8, 9,
   * and 10. Only 10 is happy as well! You don't need to try all these numbers once you realize that
   * 2, 4, 8 are multiples so only try 4, 3, 6, 9 are also all multiples so just try 9. Since 4 and
   * 9 are unhappy, the other multiples are also unhappy.
   * <p>
   * Notice how any other number in the range of 1 & 9 inclusive always goes into a loop. We can
   * then assume that if N ever falls below 10, then we return false UNLESS it is 1 or 7.
   * <p>
   * But now we have to consider, what if we have a number greater than 10? Will such a number ever
   * loop back to a value between 1 and 10? If so, we have good cases to return true/false but if
   * not then this exploration was useless.
   * <p>
   * First notice that multiplying a happy number by 10 results in a new happy number. N=1, 10, 100,
   * 1000 are clearly happy.
   * <p>
   * Now notice that multiplying an un-happy number by 10 also results in an unhappy number! N=2,
   * 20, 200, 2000
   * <p>
   * Also notice how reversing the order of numbers does not change whether the new number will be
   * happy. Example, 20 is unhappy and reversing it to 02 is still an unhappy number, this is
   * clearly always true since summations do not depend on ordering of digits!
   */
  public boolean isHappy(int n) {
    while (true) {
      if (n == 1 || n == 7) {
        return true;
      }
      if (n < 10) {
        return false;
      }
      n = squareSumDigits(n);
    }
  }

  private int squareSumDigits(int n) {
    int sum = 0;
    //Loop each digit until hit 0
    while (n != 0) {
      int digit = n % 10; //get rightmost digit
      sum += digit * digit; //increment sum by square of digit
      n /= 10; //remove last digit
    }
    return sum;
  }
}
