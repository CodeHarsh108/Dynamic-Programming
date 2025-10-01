import java.util.Scanner;

public class MaxSumOfNonAdjElements {
    public static int nonAdjacent(int[] nums){
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n ; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n-1];
    }

    public static int nonAdjacent2(int[] nums){
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n ; i++) {
            int curr = Math.max(prev1, prev2+nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result1 = MaxSumOfNonAdjElements.nonAdjacent(nums);
        int result2 = MaxSumOfNonAdjElements.nonAdjacent2(nums);

        System.out.println("Maximum sum of non-adjacent elements (DP array method): " + result1);
        System.out.println("Maximum sum of non-adjacent elements (Optimized method): " + result2);

        sc.close();
    }


}
