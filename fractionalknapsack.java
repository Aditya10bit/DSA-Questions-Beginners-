import java.util.Arrays;
import java.util.Comparator;

public class fractionalknapsack {
    public static void main(String args[]){
        int value[]={60,100,1200};
        int weight[]={10,20,30};
        int w = 50;
        double ratio[][]= new double [value.length][2];

        for(int i= 0 ; i<value.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=value[i]/(double)weight[i];
        }
        //ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o->o[1]));
        int capacity = w;
        int finalval=0;
        for(int i = ratio.length-1;i>=0;i--){//descending order ratio [6,5,4]
            int idx=(int)ratio[i][0];//index of the ratio
            if(capacity>=weight[idx]){//include full
                finalval+=value[idx];
                capacity-=weight[idx];
            }
            else{
                //include fractional value
                finalval+=(ratio[i][1]*capacity);
                capacity=0;
                break;
            }
        }
        System.out.println("final value is = "+finalval);
    }
}
