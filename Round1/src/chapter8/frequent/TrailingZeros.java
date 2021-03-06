package chapter8.frequent;
/**
 * 172. Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 * @author Lei
 *
 */
public class TrailingZeros {
    public int trailingZeroes(int n) {
        // 11! = 11 * 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
        // The only chances are 2 5 10, so every 5, there is a 10, a 0
        int sum = 0;
        while ( n > 0) {
            sum += n / 5;
            n = n / 5;
        }
        
        return sum;
    }
    
    public int trailingZeroesNew(int n) {
        int count = 0;
        while (n != 0) {
            count += n / 5;
            n = n / 5;
        }
        
        return count;
    }
    
    public int trailingZeroesRecursion(int n) {
        if (n == 0) {
            return 0;
        }        
        // 25 provides 2 fives, 125 provides 3
        return n / 5 + trailingZeroes(n / 5);
    }
}
