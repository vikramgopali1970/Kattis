package Kattis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiverseString {

    public static void main(String[] args){
        DiverseString ds = new DiverseString();
//        ds.solution(6,1,1);
//        ds.solution(0,1,8);
        System.out.println(ds.solution(1,1,2));
        System.out.println(ds.solution(6,1,1));
        System.out.println(ds.solution(0,1,8));
    }

    public class Node{
        int count;
        char val;

        public Node(char val, int count){
            this.val = val;
            this.count = count;
        }
    }

    public String solution(int A, int B, int C){
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o2.count,o1.count);
            }
        });
        ArrayList<Node> lst = new ArrayList<Node>();
        int[] ch = new int[26];
        Node a = new Node('a',A);
        Node b = new Node('b',B);
        Node c = new Node('c',C);
        Node prev = null;
        if(a.count > 0){
            pq.offer(a);
        }
        if(b.count > 0){
            pq.offer(b);
        }
        if(c.count > 0){
            pq.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Node peek = pq.poll();
            sb.append(peek.val);
            peek.count--;
            ch[peek.val - 'a']++;
            if(prev != null){
                pq.offer(prev);
                prev = null;
            }
            if(ch[peek.val - 'a'] < 2 && peek.count>0){
                pq.offer(peek);
            }else{
                ch[peek.val - 'a'] = 0;
                if(peek.count != 0){
                    prev = peek;
                }
            }
        }
        return sb.toString();
    }
}
