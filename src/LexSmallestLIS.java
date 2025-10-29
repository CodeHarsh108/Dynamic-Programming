import java.util.*;

public class LexSmallestLIS {
    public static int[] longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        if (n == 0) return new int[0];

        // dp[i] = length of LIS ending at i
        int[] dp = new int[n];
        // prev[i] = previous index in optimal sequence
        int[] prev = new int[n];
        // To break ties: for same length, track the actual sequence values

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLength = 1;
        int maxEndIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        // Found longer sequence
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    } else if (dp[j] + 1 == dp[i]) {
                        // Same length - choose lexicographically smaller
                        if (isLexSmaller(arr, prev, j, prev[i], i)) {
                            prev[i] = j;
                        }
                    }
                }
            }

            // Update global maximum
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxEndIndex = i;
            } else if (dp[i] == maxLength) {
                // Same length - choose lexicographically smaller ending
                if (isLexSmaller(arr, prev, maxEndIndex, i, -1)) {
                    maxEndIndex = i;
                }
            }
        }

        // Reconstruct the sequence
        return reconstructSequence(arr, prev, maxEndIndex, maxLength);
    }

    // Helper: Compare two sequences for lexicographical order
    private static boolean isLexSmaller(int[] arr, int[] prev, int idx1, int idx2, int end) {
        List<Integer> seq1 = getSequence(arr, prev, idx1);
        List<Integer> seq2 = getSequence(arr, prev, idx2);

        if (end != -1) {
            seq1.add(arr[end]);
            seq2.add(arr[end]);
        }

        // Compare lexicographically
        for (int i = 0; i < Math.min(seq1.size(), seq2.size()); i++) {
            if (seq1.get(i) < seq2.get(i)) return true;
            if (seq1.get(i) > seq2.get(i)) return false;
        }

        // If all equal, shorter is considered smaller (but they should be same length)
        return seq1.size() <= seq2.size();
    }

    // Helper: Get sequence ending at given index
    private static List<Integer> getSequence(int[] arr, int[] prev, int idx) {
        List<Integer> sequence = new ArrayList<>();
        while (idx != -1) {
            sequence.add(0, arr[idx]); // Add to front
            idx = prev[idx];
        }
        return sequence;
    }

    // Helper: Reconstruct final sequence
    private static int[] reconstructSequence(int[] arr, int[] prev, int endIndex, int length) {
        int[] result = new int[length];
        int idx = endIndex;

        for (int i = length - 1; i >= 0; i--) {
            result[i] = arr[idx];
            idx = prev[idx];
        }

        return result;
    }

    // Test
    public static void main(String[] args) {
        int[] arr = {2, 6, 3, 4, 1, 2, 9, 5, 8};
        int[] result = longestIncreasingSubsequence(arr);
        System.out.println("Lexicographically smallest LIS: " + Arrays.toString(result));
        // Output: [1, 2, 5, 8] or similar based on implementation
    }
}