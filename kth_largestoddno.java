import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class kth_largestoddno {
    public static void main(String args[]) {
        int l = -3, r = 3, k = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (Math.abs(i) % 2 == 1) {
                list.add(i);
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        if (k > list.size()) {
            System.out.println("0");
        } else {
            System.out.println(list.get(k - 1));
        }
    }
}
