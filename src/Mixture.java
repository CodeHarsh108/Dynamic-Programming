public class Mixture {
    public static int minSmoke(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] color = new int[n][n];

        for(int i = 0; i < n; i++){
            color[i][i] = arr[i];
            dp[i][i] = 0;
        }

        for(int len = 2; len <= n; len++){
            for (int i = 0; i <= n - len; i++){
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int smoke = dp[i][k] + dp[k+1][j] + color[i][k] * color[k+1][j];
                    if(smoke <dp[i][j]){
                        dp[i][j] = smoke;
                        color[i][j] = (color[i][k] + color[k+1][j]) % 100;
                    }
                }
            }
        }
        return dp[0][n-1];
    }
    public static void main(String[] args) {
        int[] arr = {40, 60, 20};
        System.out.println("Minimum smoke: " + minSmoke(arr));
    }
}
