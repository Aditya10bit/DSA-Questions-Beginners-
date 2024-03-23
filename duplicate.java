import java.util.Stack;

public class duplicate {
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        for(int i =0; i<str.length();i++){
            char ch = str.charAt(i);
        //closing
            if(ch==')'){
                int count =0;
                while(s.peek() !='(' ){
                    s.pop();//operator and operand popped
                    count ++;
                }
                if(count<1){
                    return true;//duplicate
                }
                else{
                    s.pop();//opening pair brackets popped;
                }
            }

            else{
                s.push(ch);//opening
            }
        }
        return false;
    }
    public static void main(String args[]){
        String str="((a+b)+(c+d))";
        System.out.println(isDuplicate(str));
    }
}
