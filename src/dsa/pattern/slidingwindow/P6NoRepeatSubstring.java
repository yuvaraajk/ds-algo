package dsa.pattern.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/** Given a string, find the length of the longest substring which has no repeating characters. */
public class P6NoRepeatSubstring {

  /**
   * Find the longest substring without duplicate characters. 1. Iterate over the string, maintain
   * the window start and end index 2. check if char already exists then move to start index to
   * duplicate char
   *
   * @param input
   * @return
   */
  private static int findNoRepeatChars(String input) {
    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> charIndexMap = new HashMap<>();
    for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
      char right = input.charAt(windowEnd);
      if (charIndexMap.containsKey(right)) {
        windowStart = Math.max(windowStart, charIndexMap.get(right) + 1);
      }
      charIndexMap.put(right, windowEnd);
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(
        "Longest substring which has no repeating chars: " + findNoRepeatChars("aabccbb"));
  }
}
