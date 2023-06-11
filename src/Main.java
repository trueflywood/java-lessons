import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        arr.add(0);
        arr.add(1);
        arr.add(0);
        arr.add(3);
        arr.add(5);
        arr.add(6);
        arr.add(0);
        arr.add(12);
        arr.add(0);
        arr.add(1);

        arr.sort((a, b) -> {
           if (a == 0 ) return 1;
           if (b == 0 ) return -1;
           return 0;
        });

        System.out.println(arr);
    }
}