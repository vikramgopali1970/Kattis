package Kattis;

import java.util.Scanner;

public class FourThought {

    private static boolean flag = false;
    private static String ans = "";

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] nums = new int[tc];
        for(int i=0;i<tc;i++){
            nums[i] = sc.nextInt();
        }
        for(int i=0;i<tc;i++){
            int num = nums[i];
            StringBuilder sb = new StringBuilder("4");
            flag = false;
            ans = "";
            recusriveHelper(num, 4, 0, sb, "");
            if(ans.equals("")){
                System.out.println("no solution");
            }else{
                System.out.println(ans+" = "+num);
            }
        }
    }

    private static void recusriveHelper(int num, int cur, int ind, StringBuilder sb, String prev) {
        if(flag){
            return;
        }
        if(ind == 3){
            if(num==cur){
                flag = true;
                ans = sb.toString();
                return;
            }
            return;
        }else{
            if(prev.equals("+")){
                cur -= 4;
                sb.append(" * 4");
                recusriveHelper(num, cur + 16, ind+1, sb, "+");
                sb.setLength(sb.length()-4);
                sb.append(" / 4");
                recusriveHelper(num, cur + 1, ind+1, sb, "+");
                sb.setLength(sb.length()-4);
                cur += 4;
            }else if(prev.equals("-")){
                cur += 4;
                sb.append(" * 4");
                recusriveHelper(num, cur - 16, ind+1, sb, "-");
                sb.setLength(sb.length()-4);
                sb.append(" / 4");
                recusriveHelper(num, cur - 1, ind+1, sb, "-");
                sb.setLength(sb.length()-4);
                cur -= 4;
            }else{
                sb.append(" * 4");
                recusriveHelper(num, cur * 4, ind+1, sb, "*");
                sb.setLength(sb.length()-4);
                sb.append(" / 4");
                recusriveHelper(num, cur / 4, ind+1, sb, "/");
                sb.setLength(sb.length()-4);
            }
            sb.append(" + 4");
            recusriveHelper(num, cur + 4, ind+1, sb, "+");
            sb.setLength(sb.length()-4);
            sb.append(" - 4");
            recusriveHelper(num, cur - 4, ind+1, sb, "-");
            sb.setLength(sb.length()-4);
        }
    }
}


//3,2,3,2
/*
2,2,3,3


6,4,5,5,5,5

4,5,5,5,5,6
* */

// 4-4*4*4