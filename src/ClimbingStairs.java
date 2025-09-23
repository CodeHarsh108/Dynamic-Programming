import java.util.Scanner;

public class ClimbingStairs {
    public static long helper1(long n, long m){
        if (n == 0) return 1;
        if (m <= 0) return 0;

        long[] dp = new long[(int) (n+1)];
        dp[0] = 1;

        for (int i = 1; i <= n; i++){
            dp[i] = 0;
            for(int k = 1; k <= m; k++){
                int prev = i - k;
                if (prev < 0) break;
                dp[i] += dp[prev];
            }
        }
        return dp[(int) n];
    }

    public static long helper2(long n, long m){
        if (n == 0) return 1;
        if (m <= 0) return 0;

        long[] dp = new long[(int) (n+1)];
        dp[0] = 1;

        long windowSum = 0;
        for (int i = 1; i <= n ; i++) {
            windowSum += dp[i - 1];
            if ((i - 1) - m >= 0) windowSum -= dp[(int) (i-1-m)];
            dp[i] = windowSum;
        }
        return dp[(int) n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (stairs): ");
        long n = sc.nextLong();

        System.out.print("Enter m (max steps at a time): ");
        long m = sc.nextLong();

        long ans1 = helper1(n, m);
        long ans2 = helper2(n, m);

        System.out.println("Ways (helper1 - O(n*m)): " + ans1);
        System.out.println("Ways (helper2 - optimized O(n)): " + ans2);

        sc.close();
    }
}
