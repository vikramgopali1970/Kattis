package Kattis;

import java.util.Arrays;
import java.util.Scanner;

public class Akcija {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i=0;i<n;i++){
            prices[i] = sc.nextInt();
        }
        Arrays.sort(prices);
        int res = 0;
        int mod=0;
        for(int i=prices.length-1;i>=0;i--){
            if(mod%3 != 2){
                res += prices[i];
            }
            mod++;
        }
        System.out.println(res);
    }
}