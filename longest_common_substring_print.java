import java.util.*;

public class longest_common_substring_print {
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
                if(i==0 || j==0){
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
                    dp[i][j] = 0;
                }
            }
        }

        int mx = 0;
        int si=n,sj=m;

        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(dp[i][j] > mx){
                    mx = dp[i][j];
                    si = i;
                    sj = j;
                }
            }
        }
        System.out.println(mx);

        String ans = "";

        while(si!=0 && sj!=0){
            if(a.charAt(si-1) == b.charAt(sj-1)){
                ans += a.charAt(si-1);
                si--;
                sj--;
            }
            else{
                break;
            }
        }

        String rev = new StringBuilder(ans).reverse().toString();
        System.out.println(rev);

        in.close();
    }
}
