package chapter8.frequent1;
/**
 * Given an array with integers.

Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.

Return the largest difference.

 Notice

The subarray should contain at least one number

Have you met this question in a real interview? Yes
Example
For [1, 2, -3, 1], return 6.
 * @author Lei
 *
 */
public class MaxSubArrayDiff {

	public static void main(String[] args) {
		//[1,2,-3,1]
		int[] nums = {1,2,-3,1};
		int res = maxDiffSubArrays(nums);
		System.out.println(res);
	}

    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public static int maxDiffSubArrays(int[] nums) {
        int size = nums.length;
        
        int[] leftMax = new int[size];
        int[] leftMin = new int[size];
        int[] rightMax = new int[size];
        int[] rightMin = new int[size];
        int[] copy = new int[size];
        
        for (int i = 0; i < size; i++) {
            copy[i] = -1 * nums[i];
        }
        
        // Max, from left to right
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            leftMax[i] = max;
            System.out.print(leftMax[i] + " - ");
        }
        
        System.out.println();
        
        // Max, from right to left
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            rightMax[i] = max;
            System.out.print(rightMax[i] + " - ");
        }
        
        System.out.println();
        
        // Min, from left to right
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for (int i = 0; i < size; i++) {
            sum += copy[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            leftMin[i] = -1 * max;
            System.out.print(leftMin[i] + " - ");
        }
        
        System.out.println();
        
        // Min, from right to left
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += copy[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            rightMin[i] = -1 * max;
            System.out.print(rightMax[i] + " - ");
        }
        
        System.out.println();
        
        int diff = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {
            diff = Math.max(diff, Math.abs(leftMax[i] - rightMin[i + 1]));
            diff = Math.max(diff, Math.abs(leftMin[i] - rightMax[i + 1]));
        }
        
        return diff;
    }
}

