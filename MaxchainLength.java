import java.util.Arrays;
import java.util.Comparator;

public class MaxchainLength {
    public static void main(String args[]){
        int chain[][]={{50,60},{10,30},{40,90},{70,100}};
        Arrays.sort(chain,Comparator.comparingDouble(o->o[1]));
        int chainLength=1;
        int chainEnd=chain[0][1];//pair end
        for(int i=1 ; i<chain.length;i++){
            if(chain[i][0]>chainEnd){
                chainLength++;
                chainEnd=chain[i][1];
            }
        }
        System.out.println("The max chain length "+ chainLength);

    }
}
