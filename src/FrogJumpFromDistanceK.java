import java.util.*;

public class FrogJumpFromDistanceK {
    public static int frogJump(int k, int[] h){
        int n = h.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;  // Base case: cost at stone 1 = 0

        // Build DP table
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i - j >= 1) {
                    dp[i] = Math.min(dp[i],
                            dp[i - j] + Math.abs(h[i - 1] - h[i - j - 1]));
                }
            }
        }
        return dp[n]; // min cost to last stone
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number of stones
        System.out.print("Enter number of stones (n): ");
        int n = sc.nextInt();

        // Step 2: Input jump distance K
        System.out.print("Enter max jump distance (k): ");
        int k = sc.nextInt();

        // Step 3: Input heights of stones
        int[] h = new int[n];
        System.out.println("Enter heights of stones:");
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        // Step 4: Call frogJump and print result
        int result = frogJump(k, h);
        System.out.println("Minimum cost to reach last stone: " + result);
    }
}
