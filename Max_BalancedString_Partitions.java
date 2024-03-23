public class Max_BalancedString_Partitions {
    static int BalancedString(StringBuilder s,int n){
        if(n==0){
            return 0;
        }
        int l=0,r=0;
        int ans=0;
        for(int i =0;i <n;i++){
            if(s.charAt(i)=='L'){
                l++;
            }
            else if(s.charAt(i)=='R'){
                r++;
            }
            if(l==r){
                ans++;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        StringBuilder s = new StringBuilder("LRRRRLLRLLRL");
        int n = s.length();
        BalancedString(s,n);
        System.out.println(BalancedString(s,n));
    }
}
