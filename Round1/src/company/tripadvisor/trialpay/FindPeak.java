package company.tripadvisor.trialpay;
/**
 * 问题：在一个数组A[n]中，找出所有这样的A[i]，它比它前面的所有数都要大，比它后面的数都要小
例如：如果A[8] = {1 2 3 4 5 6 7 8}，则输出 1 2 3 4 5 6 7 8
            如果A[8] = {8 7 6 5 4 3 2 1},则输出为空
            如果A[8] = {3 5 4 2 1 6 8 7},则输出为6
 */
public class FindPeak {

	public static void main(String[] args) {
		FindPeak q = new FindPeak();
		int[] N = {3, 1, 8, 9, 6, 10, 13};
		int res = q.findPeak(N);
		System.out.println(res);
	}
	
	// O(N)
	int findPeakN(int[] N) {
		int[] min = new int[N.length];
		min[N.length - 1] = N[N.length - 1];
		
		for (int i = N.length - 2; i >= 0; i--) {
			min[i] = Math.min(min[i + 1], N[i]);
		}
		
		int max = N[0];
		for (int i = 1; i < N.length - 1; i++) {
			if (N[i] > max && N[i] <= min[i]) {
				return N[i];
			}
			max = Math.max(max, N[i]);
		}
		
		return -1;
	}
	
	void anotherVersion() {
		//找出数组中，比前面所有数都大，比后面所有数都小的数。
		int[] arr = {21,11,45,56,9,66,77,89,78,68,100,120,111};
		
		int len = arr.length;
		int[] left = new int[len];
		int[] right = new int[len];
		
		left[0] = arr[0];
		for (int i = 1; i < len; i++) {
			left[i] = Math.max(left[i - 1], arr[i]);
		}
		
		right[len - 1] = arr[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			right[i] = Math.min(right[i + 1], arr[i]);
		}
		
		for (int i = 0; i < len; i++) {
			if (left[i] <= right[i]) {
				System.out.println(arr[i]);
//				break;
			}
		}
	}
	
	// O(N2)
	int findPeak(int[] N) {
		int max = N[0];
		
		for (int i = 1; i < N.length; i++) {
			if (N[i] > max) {
				max = N[i];
				if (checkTailing(N, i)) {
					return max;
				}
			}
		}
		
		return -1;
	}
		
	boolean checkTailing(int[] N, int pos) {
		int candidate = N[pos];
		for (int i = pos + 1; i < N.length; i++) {
			if (N[i] <= candidate) {
				return false;
			}
		}
		
		return true;
	}
}