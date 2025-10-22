import java.util.Arrays;

public class UnboundedKnapsack {
    public static int unboundedKnapsack1(int[] val, int[] wt, int cap){
        int n = val.length;
        int[] dp = new int[cap + 1];
        Arrays.fill(dp, 0);
        for(int i = 1; i <= cap; i++){
            for (int j = 0; j < n; j++){
                if(wt[j] <= i){
                    dp[i] = Math.max(dp[i], val[j] + dp[i - wt[j]]);
                }
            }
        }
        return dp[cap];
    }

    public static int unboundedKnapsack2(int[] val, int[] wt, int cap){
        int n = val.length;
        int[] dp = new int[cap + 1];
        Arrays.fill(dp, 0);
        for(int i = 0; i < n; i++){
            for (int w = wt[i]; w <= cap; w++){
                    dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
            }
        }
        return dp[cap];
    }

    public static int unboundedKnapsack3(int[] val, int[] wt, int cap){
        int n = val.length;
        int[][] dp = new int[cap + 1][cap + 1];
        for(int i = 0; i <= n; i++){
            for (int w = 0; w <= cap; w++){
                if (i == 0 || w == 0){
                    dp[i][w] = 0;
                }else if (wt[i - 1] <= w){
                    dp[i][w] = Math.max(dp[i-1][w], val[i-1] + dp[i][w - wt[i-1]]);

                }else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[n][cap];
    }

    public static void main(String[] args) {
        // Test Case 1: Knapsack capacity 50
        int[] val1 = {60, 100, 120};
        int[] wt1 = {10, 20, 30};
        int cap1 = 50;
        System.out.println("Test Case 1: " + unboundedKnapsack1(val1, wt1, cap1)); // Expected output: 300

        // Test Case 2: Knapsack capacity 100
        int[] val2 = {10, 40, 50, 70};
        int[] wt2 = {5, 10, 15, 20};
        int cap2 = 100;
        System.out.println("Test Case 2: " + unboundedKnapsack1(val2, wt2, cap2)); // Expected output: 1000

        // Test Case 3: Knapsack capacity 5
        int[] val3 = {1, 2, 3};
        int[] wt3 = {4, 5, 6};
        int cap3 = 5;
        System.out.println("Test Case 3: " + unboundedKnapsack1(val3, wt3, cap3)); // Expected output: 2
    }
    }
