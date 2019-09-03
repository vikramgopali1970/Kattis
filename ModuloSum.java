package Kattis;

import java.util.Arrays;
import java.util.Scanner;

public class ModuloSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        boolean zero = false;
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
            if(nums[i] == 0){
                zero = true;
            }
        }
        if(zero){
            System.out.println("YES");
        }else{
            if(helper(nums,0,m,0)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static boolean helper(int[] nums, int ind, int m, int sum){
        if(ind >= nums.length){
            if(sum != 0 && sum % m == 0){
                return true;
            }
            return false;
        }else{
            return  helper(nums, ind+1, m, sum+nums[ind]) || helper(nums, ind+1, m, sum);
        }
    }
}
