import java.util.ArrayList;
import java.util.Collections;

public class JobsSequencing {
    static class job{
        int id;
        int deadline;
        int profit;
        public job (int i,int d,int p){
            id = i;
            deadline=d;
            profit=p;
        }
    }
    public static void main(String args[]){
        int jobsInfo[][]={{4,20},{1,5},{2,30},{1,40}};
        //creating an arraylist to store the above information as objects of job class
        ArrayList<job>jobs = new ArrayList<>();
        for(int i =0 ;i<jobsInfo.length;i++){
            jobs.add(new job(i,jobsInfo[i][0],jobsInfo[i][1]));
        }
        Collections.sort(jobs,(obj1,obj2) -> obj2.profit-obj1.profit);//sorting the jobs arraylist on basis of profit in descending order
        int time =0;
        int maxprofit=0;
        ArrayList<Integer>seq=new ArrayList<>();
        for(int i=0;i<jobs.size();i++){
            job curr = jobs.get(i);
            if(curr.deadline>time){
                time++;
                seq.add(curr.id);
                maxprofit+= curr.profit;
            }
        }
       System.out.println("the maximum jobs " + seq.size());
        System.out.println("the maximum profit "+maxprofit);
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }
    }
}
