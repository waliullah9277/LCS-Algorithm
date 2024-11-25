import java.util.*;

public class lcs_top_down_memoization {

    static int[][] dp = new int[1005][1005];

    public static int lcs(String a, int n, String b, int m) {

        if (n == 0 || m == 0)
            return 0;
        
        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if (a.charAt(n - 1) == b.charAt(m - 1)) {
            int ans = lcs(a, n - 1, b, m - 1);
            return dp[n][m] = ans + 1;
        } else {
            int ans1 = lcs(a, n - 1, b, m);
            int ans2 = lcs(a, n, b, m - 1);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter String a: ");
        String a = in.nextLine();
        System.out.print("Enter string b: ");
        String b = in.nextLine();
        for(int i=0; i<=a.length(); i++){
            for(int j=0; j<=b.length(); j++){
                dp[i][j] = -1;
            }
        }
        int longestLcs = lcs(a, a.length(), b, b.length());
        System.out.println("Longest Common Subsequence is: " + longestLcs);
        in.close();
    }
}
