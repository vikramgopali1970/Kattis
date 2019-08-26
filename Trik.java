package Kattis;

import java.util.Scanner;

public class Trik {
    private static void swap(int[] cups, int i, int j){
        int temp = cups[i];
        cups[i] = cups[j];
        cups[j] = temp;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String seq = sc.nextLine();
        int[] cups = new int[]{1,0,0};
        for(int i=0;i<seq.length();i++){
            char c = seq.charAt(i);
            switch(c){
                case 'A':
                    swap(cups, 0, 1);
                    break;
                case 'B':
                    swap(cups, 1, 2);
                    break;
                default:
                    swap(cups, 0, 2);
            }
        }
        for(int i=0;i<3;i++){
            if(cups[i] == 1){
                System.out.println(i+1);
                break;
            }
        }
    }
}
