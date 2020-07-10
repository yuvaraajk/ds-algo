package dsa.pattern.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of characters where each character represents a fruit tree, you are given two
 * baskets and your goal is to put maximum number of fruits in each basket. The only restriction is
 * that each basket can have only one type of fruit.
 */
public class P5FruitsAndBaskets {

  /**
   * To put maximum number of fruits in 2 baskets
   *
   * @param fruits
   * @return
   */
  private static int maxFruitsInBasket(char[] fruits) {
    int windowStart = 0, windowSum = 0, maxLength = 0;
    Map<Character, Integer> charFreqMap = new HashMap<>();
    for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
      char right = fruits[windowEnd];
      charFreqMap.put(right, charFreqMap.getOrDefault(right, 0) + 1);
      if (charFreqMap.size() > 2) {
        char left = fruits[windowStart];
        charFreqMap.put(left, charFreqMap.get(left) - 1);
        if (charFreqMap.get(left) == 0) {
          charFreqMap.remove(left);
        }
        windowStart++;
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(
        "Maximum number of fruits in 2 baskets: "
            + maxFruitsInBasket(new char[] {'A', 'B', 'C', 'C', 'A', 'C'}));
  }
}
