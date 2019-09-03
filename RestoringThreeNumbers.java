package Kattis;

import java.util.Scanner;

public class RestoringThreeNumbers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        for(int i=0;i<4;i++){
            arr[i] = sc.nextInt();
        }
        int max = arr[0];
        for(int i=1;i<4;i++){
            max = Math.max(max, arr[i]);
        }
        int[] res = new int[3];
        int ind = 0;
        for(int i=0;i<4;i++){
            if(max != arr[i]){
                res[ind] = max - arr[i];
                System.out.print(res[ind++]+" ");
            }
        }
    }
}
