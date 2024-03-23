// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.*;
    class PivotPoint{
        public static void main(String args[]){
            int numbers[]={3,4,0,1,2};
            int key = 2;
            System.out.println(search(numbers,key));
        }
        public static int  search(int numbers[],int key){
            int pos=0;
            for(int i=0;i<numbers.length;i++){
                if(numbers[i]>numbers[i+1]){
                    pos=i;
                    break;
                }
            }
            int start= 0;
            int end = pos;
            int mid;
            while(start<=end){
                mid= (start+end)/2;
                if(numbers[mid]==key){
                    return mid;
                }
                if(numbers[mid]>key){
                    end=mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            start= pos;
            end = numbers.length-1;
            mid=0;
            while(start<=end){
                mid= (start+end)/2;
                if(numbers[mid]==key){
                    return mid;
                }
                if(numbers[mid]>key){
                    end=mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            return-1;
        }
    }


