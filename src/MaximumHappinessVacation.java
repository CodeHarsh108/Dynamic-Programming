public class MaximumHappinessVacation {
    static int[][] dp;
    public static int max(int[][] points){
        int n = points.length;
        dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(0, 3, points);
    }

    private static int helper(int day, int prev, int[][] points) {
        if (day == points.length) return 0;
        if(dp[day][prev] != -1) return dp[day][prev];
        int  maxHap = 0;
        for (int act = 0; act < 3; act++) {
            if(act != prev){
                int currHap = points[day][act] + helper(day+1, act, points);
                maxHap = Math.max(currHap, maxHap);
            }
        }
        return  dp[day][prev] = maxHap;
    }
    public static void main(String[] args) {
        int[][] points = {
                {10, 40, 70}, // day 0
                {20, 50, 80}, // day 1
                {30, 60, 90}  // day 2
        };
        System.out.println("Maximum Happiness: " + max(points));
    }
}
