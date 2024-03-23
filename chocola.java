import java.util.Arrays;
import java.util.Collections;

public class chocola {
    public static void main(String args[]) {
        int m = 6, n = 4;
        Integer verCost[] = {2, 1, 3, 1, 4};
        Integer horiCost[] = {4, 1, 2};
        //sort in descending order of costs
        Arrays.sort(verCost, Collections.reverseOrder());
        Arrays.sort(horiCost, Collections.reverseOrder());

        int v = 0, h = 0;//pointers
        int vp = 1, hp = 1;//initial pieces
        int cost = 0;
        while (v < verCost.length && h < horiCost.length) {
            if (verCost[v] <= horiCost[h]) {//horizontal
                cost += (horiCost[h] * vp);
                hp++;
                h++;
            } else {//vertical
                cost += (verCost[v] * hp);
                vp++;
                v++;
            }
        }
        while (h < horiCost.length) {
            cost += (horiCost[h] * vp);
            hp++;
            h++;
        }
        while (v < verCost.length) {
            cost += (verCost[v] * hp);
            vp++;
            v++;
        }
        System.out.println("total cuts " + (hp* vp));
        System.out.println("the cost is " + cost);
    }
}


