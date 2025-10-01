import java.util.Scanner;

public class FrogJumpWithKDistance {
    public static int frogJump(int[] heights, int k){
        int n = heights.length;
        if(n == 0 || n == 1) return 0;

        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i-k; j < i; j++) {
                if(j >= 0){
                    int cost = dp[j] + Math.abs(heights[i] - heights[j]);
                    dp[i] = Math.min(dp[i], cost);
                }
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of stones: ");
        int n = sc.nextInt();

        int[] heights = new int[n];
        System.out.println("Enter the heights of the stones:");
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        System.out.print("Enter the maximum jump distance k: ");
        int k = sc.nextInt();

        int result = frogJump(heights, k);
        System.out.println("Minimum cost for the frog to reach the last stone: " + result);

        sc.close();
    }
}
