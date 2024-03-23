import java.util.Deque;
import java.util.LinkedList;

public class deq {
    static Deque<Integer> stack = new LinkedList<>();
        public static void push(int data){
           stack.addLast(data);
        }
    public static int pop(){
        if(isEmpty()){
            System.out.println("empty stack");
        }
        return stack.removeLast();
    }
    public static int peek(){
            if(isEmpty()){
                System.out.println("empty stack");
            }
        return stack.getLast();
    }
    public static boolean isEmpty(){
            return stack.isEmpty();
    }
    public static void main(String args[]) {
     deq  d = new deq();
     d.push(1);
     d.push(2);
     d.push(3);
     while(!d.isEmpty()){
         System.out.println(d.pop());
     }
    }
}
