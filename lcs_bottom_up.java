import java.util.Scanner;

public class lcs_bottom_up {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string a: ");
        String a = in.nextLine();
        System.out.print("Enter string b: ");
        String b = in.nextLine();
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // if(dp[n][m] == b.length()){
        //     System.out.println("Yes");
        // }
        // else{
        //     System.out.println("No");
        // }

        System.out.println("Longest Common Subsequence is: " + dp[n][m]);
        in.close();
    }
}
