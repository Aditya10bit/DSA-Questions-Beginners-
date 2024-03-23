import java.util.*;

public class IndianCoins {
    public static void main(String args[]){
        Integer coins[]={2000,500,200,100,50,20,10,5,2,1};
        Arrays.sort(coins, Comparator.reverseOrder());
        int Maxcoins=0;
         ArrayList<Integer> ans= new ArrayList<>();
         int amount=2512;
         for(int i=0 ; i<coins.length;i++){
             if(coins[i]<=amount){//checking if denomination exists
                 while(coins[i]<=amount){
                     ans.add(coins[i]);
                     Maxcoins++;
                     amount-=coins[i];
                 }
             }
         }
         System.out.println("THE MAXIMUM DENOMINATION IS "+ Maxcoins);
         for(int i=0;i<ans.size();i++){
             System.out.print(ans.get(i)+" ");
         }
    }
}
