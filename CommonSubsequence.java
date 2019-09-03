package Kattis;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CommonSubsequence {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] s = new int[n];
        int[] t = new int[m];
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for(int i=0;i<n;i++){
            s[i] = sc.nextInt();
            set1.add(s[i]);
        }
        for(int i=0;i<m;i++){
            t[i] = sc.nextInt();
            set2.add(t[i]);
        }
        set1.retainAll(set2);


    }
}
