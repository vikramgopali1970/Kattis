package Kattis;


public class Betting {


    public static void main(String[] args){
        Betting b = new Betting();
        System.out.println(b.solution(8,0 ));    //7
        System.out.println(b.solution(18,2 ));  //6
        System.out.println(b.solution(10,10));  //4
        System.out.println(b.solution(647,100));  //4
    }

    public int solution(int N, int k){
        return this.helper(N,1,k,0,0);
    }

    private int helper(int N, int coins, int k, int all, int turn){
        if(coins > N){
            return turn;
        }else{
            int one = Integer.MAX_VALUE;
            int ai = Integer.MAX_VALUE;
            if(coins+1 <= N){
                one = this.helper(N,coins+1, k, all, turn+1);
            }
            if(all+1 <= k && (coins*2) <= N){
                ai = this.helper(N, coins*2, k, all+1, turn+1);
            }
            int min = Math.min(one,ai);
            return (min == Integer.MAX_VALUE)?turn:min;
        }
    }
}
