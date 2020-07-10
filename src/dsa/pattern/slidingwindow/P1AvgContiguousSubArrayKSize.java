package dsa.pattern.slidingwindow;

import java.util.Arrays;

/**
 * Problem 1: Find the average of contiguous subarray of size 'K' from the given array.
 */
public class P1AvgContiguousSubArrayKSize {

    /**
     * Find the average of all contiguous subarrays of size ‘K’ in the given array.
     * This is brute force approach, it takes O(N * K) time to compute the average of subarray of size K.
     *
     * @param arr
     * @param k
     * @return
     */
    private static double[] findAvgContSubArrayKSizeBruteForce(int[] arr, int k) {
        double[] output = new double[arr.length - k + 1];
        for (int i = 0; i <= arr.length - k; i++) {
            double sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            output[i] = sum / k;
        }
        return output;
    }

    /**
     * Find the average of all contiguous subarrays of size ‘K’ in the given array.
     * Using sliding window approach, it takes O(N) time to compute the average of subarray of size K.
     *
     * @param arr
     * @param k
     * @return
     */
    private static double[] findAvgContSubArrayKSize(int[] arr, int k) {
        double[] output = new double[arr.length - k + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                output[windowStart] = windowSum / k;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        double[] output = findAvgContSubArrayKSizeBruteForce(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5);
        System.out.println("Brute Force: Average of subarrays of size k : " + Arrays.toString(output));
        output = findAvgContSubArrayKSize(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 4);
        System.out.println("Efficient: Average of subarrays of size k : " + Arrays.toString(output));
    }
}
