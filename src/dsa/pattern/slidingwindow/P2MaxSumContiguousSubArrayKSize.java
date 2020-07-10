package dsa.pattern.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any
 * contiguous subarray of size ‘k’.
 */
public class P2MaxSumContiguousSubArrayKSize {

  /**
   * This is brute force approach to find the maximum sum of contiguous subarray of size k. The time
   * complexity of the above algorithm will be O(N∗K), where ‘N’ is the total number of elements in
   * the given array.
   *
   * @param arr
   * @param k
   * @return
   */
  private static int maxSumOfConSubArrayBruteForce(int[] arr, int k) {
    int maxSum = 0;
    for (int i = 0; i <= arr.length - k; i++) {
      int sum = 0;
      for (int j = i; j < i + k; j++) {
        sum += arr[j];
        maxSum = Math.max(sum, maxSum);
      }
    }
    return maxSum;
  }

  /**
   * Using sliding window approach to find the maximum sum of contiguous subarray of size k. The
   * time complexity of the above algorithm will be O(N), where ‘N’ is the total number of elements
   * in the given array.
   *
   * @param arr
   * @param k
   * @return
   */
  private static int maxSumOfConSubArray(int[] arr, int k) {
    int windowStart = 0;
    int windowSum = 0;
    int maxSum = 0;
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd];
      if (windowEnd > k) {
        maxSum = Math.max(maxSum, windowSum);
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    System.out.println(
        "Brute Force: Max Sum of a SubArray of size K: "
            + maxSumOfConSubArrayBruteForce(new int[] {2, 1, 5, 1, 3, 2}, 3));
    System.out.println(
        "Brute Force: Max Sum of a SubArray of size K: "
            + maxSumOfConSubArrayBruteForce(new int[] {2, 3, 4, 1, 5}, 2));
    System.out.println("===============================================================");
    System.out.println(
        "Efficient: Max Sum of a SubArray of size K: "
            + maxSumOfConSubArrayBruteForce(new int[] {2, 1, 5, 1, 3, 2}, 3));
    System.out.println(
        "Efficient: Max Sum of a SubArray of size K: "
            + maxSumOfConSubArrayBruteForce(new int[] {2, 3, 4, 1, 5}, 2));
  }
}
