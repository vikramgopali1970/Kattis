package Kattis;

import java.util.Arrays;
import java.util.Scanner;

public class CardMagic {

    static int[][] dp;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        int[][] dp = new int[n+1][t+1];
//        recursiveHelper(n,0,k,t);
//        for(int i=0;i<dp.length;i++){
//            Arrays.fill(dp[i],-1);
//        }
//        memoHelper(n,0,k,t);
        dp[n][0] = 1;
        for(int i=n-1;i>=0;i--) {
            for (int j = 0; j <= t; j++) {
                for (int l = 1; l <= k; l++) {
                    if (j - l >= 0) {
                        dp[i][j] += dp[i + 1][j - l] % 1000000009;
                        dp[i][j] = dp[i][j] % 1000000009;
                    }
                }
            }
        }
        System.out.println(dp[0][t]);
    }

    private static int recursiveHelper(int n, int ind, int k, int t, int count){
        if(ind == n){
            if(t == 0){
                return count+1;
            }
            return count;
        }else if(t < 0){
            return count;
        }else{
            int res = 0;
            for(int i=1;i<=k;i++){
                res += recursiveHelper(n, ind+1, k, t-i, count);
            }
            return res;
        }
    }

    private static int memoHelper(int n, int ind, int k, int t){
        if(ind == n){
            if(t == 0){
                return 1;
            }
            return 0;
        }else if(t < 0){
            return 0;
        }else{
            if(dp[ind][t] != -1){
                return dp[ind][t];
            }
            int res = 0;
            for(int i=1;i<=k;i++){
                res += memoHelper(n, ind+1, k, t-i);
            }
            dp[ind][t] = res;
            return dp[ind][t];
        }
    }
}
