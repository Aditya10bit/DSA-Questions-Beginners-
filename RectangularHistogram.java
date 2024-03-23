import java.util.Stack;

public class RectangularHistogram {
    public static void main(String args[]){
        int arr[]={2, 1,5,6,2,3};
        histogram(arr);
    }
    public static void histogram(int arr[]){
        int maxARea=0;
        int nsr[]=new int [arr.length];
        int nsl[]=new int [arr.length];
        //creating stack
        Stack<Integer> s = new Stack<>();
        //smallest rom right
        for(int i = arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        //smallest from left
         s = new Stack<>();
        for(int i = 0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        //find area
        for(int i =0; i<arr.length;i++){
            int height = arr[i];
            int width=nsr[i]-nsl[i]-1;
            int curr_area=height*width;
            maxARea=Math.max(maxARea,curr_area);
        }
        System.out.println("the max area is "+ maxARea);
    }
}
