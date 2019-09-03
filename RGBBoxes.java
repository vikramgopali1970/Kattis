package Kattis;

import java.util.Arrays;
import java.util.Scanner;

public class RGBBoxes {

    static int[][] dp;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] balls = new int[3];
        for(int i=0;i<3;i++){
            balls[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        dp = new int[4][n+1];
        for(int i=0;i<4;i++){
            Arrays.fill(dp[i], -1);
        }
        int res = helper(balls,0,n,0);
        System.out.println(dp[0][0]);
    }

    private static int helper(int[] balls, int ind, int n, int sum){
        if(ind >= balls.length){
            if(sum == n){
                return 1;
            }
            return 0;
        }else if(sum > n){
            return 0;
        }else{
            if(dp[ind][sum] != -1){
                return dp[ind][sum];
            }
            int res = 0;
            for(int i=0;i<=(n/balls[ind]);i++){
                res += helper(balls,ind+1, n, sum+(i*balls[ind]));
            }
            dp[ind][sum] = res;
            return res;
        }
    }
}
