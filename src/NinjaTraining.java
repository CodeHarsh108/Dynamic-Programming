import java.util.Scanner;

public class NinjaTraining {
    public static int ninja(int[][] points){
        int n = points.length;

        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][1], points[0][0]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));


        for (int i = 1; i < n   ; i++) {
            for (int last = 0; last <= 3; last++){
                dp[i][last] = 0;
                for (int task = 0; task <= 2; task++){
                    if (task != last){
                        dp[i][last] = Math.max(dp[i][last], dp[i-1][task] + points[i][task]);
                    }
                }
            }
        }

        return dp[n-1][3];

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of days: ");
        int n = sc.nextInt();

        int[][] points = new int[n][3];

        System.out.println("Enter the points for each task on each day (3 tasks per day):");
        for (int i = 0; i < n; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            for (int j = 0; j < 3; j++) {
                points[i][j] = sc.nextInt();
            }
        }

        int maxPoints = ninja(points);

        System.out.println("Maximum points Ninja can earn: " + maxPoints);

        sc.close();
    }
}
