package Kattis;

import java.util.Scanner;

public class Spavanac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hh = sc.nextInt();
        int mm = sc.nextInt();
        int time = 45;
        if(mm >= time){
            System.out.println(hh+" "+(mm-time));
        }else{
            time -= mm;
            mm = 60-time;
            hh = (hh == 0)?23:hh-1;
            System.out.println(hh+" "+mm);
        }
    }
}
