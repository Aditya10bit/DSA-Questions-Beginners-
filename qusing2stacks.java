import java.util.*;
public class qusing2stacks {
    static class queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static  boolean isEmpty(){
            return s1.isEmpty();
        }
        public static void add(int data){//o(n)
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s2.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        public static int remove (){
            if(isEmpty()){
                System.out.println("empty stack");
            }
            return s1.pop();
        }
        public static int peek (){
            if(isEmpty()){
                System.out.println("empty stack");
            }
            return s1.peek();
        }
    }
    static class queue1 {
        static Stack<Integer> s3 = new Stack<>();
        static Stack<Integer> s4 = new Stack<>();

        public static  boolean isEmpty(){
            return s4.isEmpty();
        }
        public static void add(int data){
            s3.push(data);
        }
        public static int remove(){
            while(!s3.isEmpty()){
                s4.push(s3.pop());
            }
            while(isEmpty()){
                System.out.println("empty queue");
            }
            return s4.pop();
        }
        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty stack");
            }
            return s4.peek();
        }
    }
    public static void main(String args[]){
         queue1 q = new queue1();
         q.add(1);
         q.add(2);
         q.add(3);
         while(!q.isEmpty()){
             System.out.println(q.peek());
             q.remove();
         }
    }
}
