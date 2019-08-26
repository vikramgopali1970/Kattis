package Kattis;

import java.util.Scanner;

public class Sibice {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int[] mat = new int[n];
        for(int i=0;i<n;i++){
            mat[i] = sc.nextInt();
        }
        double sq = Math.pow(w,2) + Math.pow(h,2);
        for(int i=0;i<n;i++){
            if(Math.pow(mat[i], 2) <= sq){
                System.out.println("DA");
            }else{
                System.out.println("NE");
            }
        }
    }
}
