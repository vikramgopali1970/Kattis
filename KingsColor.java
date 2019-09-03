package Kattis;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KingsColor {

    public static void main(String[] args){
//        Double price = 32.234;
//        String numberAsString = String.format ("%.2f", price);
//        DecimalFormat decim = new DecimalFormat("#.00");
//        Double price2 = Double.parseDouble(decim.format(price));
//        System.out.println(numberAsString);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] color = new int[n];
        int[] tree = new int[n];
        Arrays.fill(tree, -1);
        Arrays.fill(color, -1);
        for(int i=1;i<n;i++){
            tree[i] = sc.nextInt();
        }
        int res = memoHelper(tree,0,k, 0);
        System.out.println(res);
    }

    private static int recursiveHelper(int[] tree, int ind, int k, int[] color){
        if(ind == tree.length){
            if(checkColor(color, k)){
                return 1;
            }
            return 0;
        }else{
            int res = 0;
            for(int i=1;i<=k;i++){
                if(ind != 0 && color[tree[ind]] == i){
                    continue;
                }
                int val = color[ind];
                color[ind] = i;
                res += recursiveHelper(tree, ind+1, k, color);
                color[ind] = val;
            }
            return res;
        }
    }


    private static int memoHelper(int[] tree, int ind, int k, int c){
        if(ind == tree.length){
            if(c==k){
                return 1;
            }
            return 0;
        }else{
            int res = 0;
            if(ind ==0){
                for(int i=1;i<=k && i<=k;i++){
                    res += memoHelper(tree, ind+1, k, i);
                }
            }else{
                for(int i=c;i<=k-1;i++){
                    res += memoHelper(tree, ind+1, k, i+1);
                }
            }

            return res;
        }
    }

    private static boolean checkColor(int[] color, int k) {
        Set<Integer> set  =new HashSet<Integer>();
        for(int i=0;i<color.length;i++){
            set.add(color[i]);
        }
        return set.size() == k;
    }
}

/*

1,2,2,2
1,2,2,3
1,2,3,2
1,2,3,3


 */