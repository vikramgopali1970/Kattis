package Kattis;

import java.util.Scanner;

public class Autori {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] str = s.split("-");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length;i++){
            sb.append(str[i].charAt(0));
        }
        System.out.println(sb);
    }
}
