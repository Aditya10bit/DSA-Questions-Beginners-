import java.util.Stack;

public class jcf {
    public static void pushatBottom(Stack<Integer> s , int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushatBottom(s,data);
        s.push(top);
    }
    public static String ReverseString(String str){
        Stack<Character> s = new Stack<>();
        int i = 0;
        while(i<str.length()){
            s.push(str.charAt(i));
            i++;
        }
        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
            char curr=s.pop();
            result.append(curr);
        }
        return result.toString();
    }
    public static void ReverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();//popping the element and calling for the next level till the stack is empty
        ReverseStack(s);
        pushatBottom(s,top);//pushing the top at bottom

    }
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
       ReverseStack(s);
       while(!s.isEmpty()){
           System.out.println(s.peek());
           s.pop();
       }
    }
}
