import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverse {
    public static void reevrsetheQueue(Queue<Integer> q,int k){
        Stack <Integer> s = new Stack<>();
        Queue <Integer> q1 = new LinkedList<>();
        for(int i= 0; i<k;i++){
            s.push(q.remove());
        }
        while(!s.isEmpty() ) {
            q1.add(s.pop());
        }
        while(!q.isEmpty()){
            q1.add(q.remove());
        }
        while(!q1.isEmpty()){
            System.out.print(q1.peek() +" ");
            q1.remove();
        }
    }
    public static void reverseusingdeq(Deque<Integer> d,int k){
        Queue <Integer> q1 = new LinkedList<>();
        for(int i =0;i<k;i++){
            q1.add(d.removeFirst());
        }
        while(!q1.isEmpty()){
            d.addFirst(q1.remove());
        }
        while(!d.isEmpty()){
            System.out.print(d.peek() +" ");
            d.remove();
        }
    }
    public static void main(String args[]){
        Queue <Integer> q = new LinkedList<>();
        Deque<Integer> d = new LinkedList<>();
        d.addLast(10);
        d.addLast(20);
        d.addLast(30);
        d.addLast(40);
        d.addLast(50);
        d.addLast(60);
        d.addLast(70);
        reverseusingdeq(d,3);
//        q.add(10);
//        q.add(20);
//        q.add(30);
//        q.add(40);
//        q.add(50);
//        q.add(60);
//        q.add(70);
//        q.add(80);
//        q.add(90);
//        reevrsetheQueue(q,5);
    }
}
