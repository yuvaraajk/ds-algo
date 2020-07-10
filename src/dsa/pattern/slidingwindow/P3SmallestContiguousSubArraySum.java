package dsa.pattern.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘S’, find the length of the smallest
 * contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray
 * exists.
 */
public class P3SmallestContiguousSubArraySum {

  /**
   * Get the smallest contiguous subarray who sum is greater than or equal to 'S'.
   *
   * @param arr
   * @param s
   * @return
   */
  private static int smallestContSubArray(int[] arr, int s) {
    int windowStart = 0, windowSum = 0, minLength = Integer.MAX_VALUE;
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd];
      while (windowSum >= s) {
        minLength = Math.min(minLength, (windowEnd - windowStart) + 1);
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }

  public static void main(String[] args) {
    System.out.println(
        "Brute Force: Smallest Contiguous SubArray of sum >= S: "
            + smallestContSubArray(new int[] {2, 1, 5, 2, 3, 4}, 7));
  }
}
