import java.util.Arrays;

public class Catalans {

    // Catlans Number

    // Recursive Approch

    public static int CatRec(int n) {
        // Base Case
        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;

        // for(int i = 0 , j = n - 1 ; i < n && j >=0 ; i++ , j--) {
        // ans += CatRec(i)*CatRec(j);
        // }

        for (int i = 0; i < n; i++) {
            ans += CatRec(i) * CatRec(n - i - 1);
        }

        return ans;
    }

    // Memoization Approch

    public static int CatMemo(int n, int dp[]) { // Time Complexity O(n^2)
        // Base Case
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += CatRec(i) * CatRec(n - i - 1);
        }

        dp[n] = ans;
        return dp[n];
    }

    // Tabulation Approch

    public static int CatTab(int n) {  // TC O(n^2)
        // Create the Table
        int dp[] = new int[n + 1];

        // Meaning 
        // dp[n] = Catalan's value for Number n

        // Initialization 
        dp[0] = 1;
        dp[1] = 1;
        // Arrays.fill(dp, -1);

        // Filling the Array
        for(int i = 2 ; i <= n; i++) {
            for(int j = 0 ; j < i ; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        // PrintTable(dp);

        return dp[n];
    }

    // Print Table
    public static void PrintTable(int dp[]) {
        for(int i = 0 ; i < dp.length ; i++) {
            System.out.print(dp[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Recursion Answer: " + CatRec(n));

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Memoization Answer: " + CatMemo(n, dp));

        System.out.println("Tabulation Answer: " + CatTab(n));
    }
}
