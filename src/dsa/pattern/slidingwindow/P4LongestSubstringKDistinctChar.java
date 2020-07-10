package dsa.pattern.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct
 * characters.
 */
public class P4LongestSubstringKDistinctChar {

    /**
     * To find the length of longest substring with more than K distinct characters
     *
     * @param input
     * @param k
     * @return
     */
    private static int findLengthOfLongestSubstring(String input, int k) {
        if (input == null || input.isEmpty() || input.length() < k) {
            return 0;
        }
        int maxLength = 0, windowSum = 0, windowStart = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char right = input.charAt(windowEnd);
            charFreqMap.put(right, charFreqMap.getOrDefault(right, 0) + 1);
            if (charFreqMap.size() > k) {
                char left = input.charAt(windowStart);
                charFreqMap.put(left, charFreqMap.get(left) - 1);
                if (charFreqMap.get(left) == 0) {
                    charFreqMap.remove(left);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, (windowEnd - windowStart) + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(
            "Length of longest substring with k distinct char: " + findLengthOfLongestSubstring(
                "cbbebi", 3));
    }
}
