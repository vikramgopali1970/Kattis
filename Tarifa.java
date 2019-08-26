package Kattis;

import java.util.Scanner;

public class Tarifa {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int[] t = new int[n];
        for(int i=0;i<n;i++){
            t[i] = sc.nextInt();
        }
        int remain = 0;
        for(int i=0;i<n;i++){
            if(t[i] < x){
                remain += x-t[i];
            }else{
                remain -= t[i]-x;
            }
        }
        System.out.println(remain+x);
    }
}
