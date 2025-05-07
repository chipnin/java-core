package algorithm.dp;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class FibonacciDP {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để đọc input từ bàn phím
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number : ");
        try {
            int n = Integer.parseInt(scanner.nextLine());

            if (n < 0) {
                System.out.println("Error: Negative number");
                return;
            }

            int fibonacciN = topDownDP(n);
            System.out.printf("Fibonacci %d: = %d", n, fibonacciN);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    static int bottomUpDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    static int topDownDP(int n) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        return topDown(n, dp);
    }

    static int topDown(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) return dp[n];

        dp[n] = topDown(n - 1, dp) + topDown(n - 2, dp);
        return dp[n];
    }
}
