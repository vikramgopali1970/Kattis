package Kattis;

import java.util.Scanner;

public class TwoZeroEightFour {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                board[i][j] = sc.nextInt();
            }
        }
        int mCase = sc.nextInt();
        switch (mCase){
            case 0: moveLeft(board);
                break;
            case 1: //move up
                break;
            case 2: //move right
                break;
            case 3: //move down
                break;
        }
        printBoard(board);
    }

    private static void printBoard(int[][] board) {
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void moveLeft(int[][] board){
        for(int i=0;i<board.length;i++){
            int merge=0;
            int pos = board[i].length-1;
            for(int j=board[i].length-1;j>0;j--){
                if(board[i][j] != 0){
                    int c = 0;
                    while(board[i][j-1] ==0){
                        j--;
                    }
                    System.out.println("checking for "+board[i][pos]+" "+board[i][j-1]+" c is "+j);
                    if(board[i][pos] == board[i][j-1]){
                        board[i][pos] = board[i][pos] + board[i][j-1];
                        board[i][j-1] = 0;
                        j--;
                    }
                }
                pos--;
            }
            pos = board[i].length-1;
            for(int j=board[i].length-1;j>=0;j--){
                if(board[i][j] ==0){
                    board[i][pos--] = board[i][j];
                    board[i][j]=0;
                }
            }
        }
    }
}
