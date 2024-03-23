import java.util.Stack;
public class nextgreater {
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        int arr[] = {1, 2, 9, 3, 5};
        int NexGreater[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {//going through right side
            //while loop
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            //check
            if(s.isEmpty()){
                NexGreater[i]=-1;
            }
            else{
                NexGreater[i]=arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0; i<NexGreater.length;i++){
            System.out.print(NexGreater[i]+ " ");
        }
    }
}
