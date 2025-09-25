public class LongestPalindromicSubstring {

    public static int longestPalindromeSubstr(String s) {
        int n = s.length();
        if (n == 0) return 0;

        boolean[][] dp = new boolean[n][n];

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }


        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                maxLen = 2;
            }
        }


        for(int len = 3; len <= n; len++){
            for(int i = 0; i <= n - len; i++){
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }

    // Tester main
    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "a";

        System.out.println("Longest palindrome length in " + s1 + " = " + longestPalindromeSubstr(s1));
        System.out.println("Longest palindrome length in " + s2 + " = " + longestPalindromeSubstr(s2));
        System.out.println("Longest palindrome length in " + s3 + " = " + longestPalindromeSubstr(s3));
    }
}
