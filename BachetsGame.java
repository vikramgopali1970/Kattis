package Kattis;

import java.util.Arrays;
import java.util.Scanner;

public class BachetsGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stones = sc.nextInt();
        int m = sc.nextInt();
        int[] member = new int[m];
        for (int i = 0; i < m; i++) {
            member[i] = sc.nextInt();
        }
        Arrays.sort(member);
        boolean[] dp = new boolean[stones+1];
        dp[0] = false;
        for(int i=0;i<=stones;i++){
            boolean res = false;
            for(int j=0;j<member.length && member[j] <= i;j++){
                res |= !dp[i-member[j]];
            }
            dp[i] = res;
        }
        if(dp[stones]){
            System.out.println("Stan wins");
        }else{
            System.out.println("Ollie wins");
        }

    }

    private boolean bachetsGameHelper(int stones, int[] member) {
        if(stones == 0){
            return true;
        }else{
            boolean res = false;
            for(int i=0;i<member.length && member[i] <= stones;i++){
                res |= this.bachetsGameHelper(stones - member[i], member);
            }
            return !res;
        }
    }
}
