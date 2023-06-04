import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
//        arr.add(0);
//        arr.add(1);
//        arr.add(0);
//        arr.add(3);
//        arr.add(12);
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

        Integer nullCount = 0;
        ArrayList<Integer> arrResult = new ArrayList<Integer>();

        for (Integer num:
             arr) {
            if(num != 0) {
                arrResult.add(num);
            } else {
                nullCount++;
            }
        }

        for (int i=0; i<nullCount; i++) {
            arrResult.add(0);
        }

        System.out.println(arrResult.toString());
    }
}