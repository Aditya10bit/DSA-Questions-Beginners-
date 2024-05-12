import java.io.*;
import java.math.*;
import java.util.*;

public class towerofh {
    public static void towerOfHanoi(int N,char src,char helper,char dest){
        if(N==1){
            System.out.println("MOVING DISK "+ N +" FROM "+ src + " to " + dest);//same
            return;
        }
        towerOfHanoi(N-1,src,dest,helper);//moving the n-1 disks from source to helper using destination as helper
        System.out.println("MOVING DISK " + N+ " FROM "+ src + " to " + dest);//moving the last disk from source to destination
        towerOfHanoi(N-1,helper,src,dest);//moving the n-1  from helper to destination disk using source as helper
    }
    public static void main(String args[]){
        int N = 3;
        towerOfHanoi(N, 's', 'h', 'd');
    }
}
//Next time when you solve a problem maintain intendation becoz that is very important in Interview point of view 
