import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] myIntArray = new int[]{1,2,3,4,1000,99999,0,5,6,7,8,0,9};
        ArrayList<Integer> tmpList = new ArrayList<Integer>();
        ArrayList<Integer> resultList = new ArrayList<Integer>();

        for (int i = 0; i < myIntArray.length; i++) {
            if (!tmpList.isEmpty()) {
                if(tmpList.get(tmpList.size() - 1) > myIntArray[i]) {


                    if(resultList.size() < tmpList.size()) {
                      resultList = new ArrayList<>(tmpList);
                    }

                    tmpList.clear();
                }
            }
            tmpList.add(myIntArray[i]);
        }
        if(resultList.size() < tmpList.size()) {
            resultList = new ArrayList<>(tmpList);
        }


        System.out.println(resultList);
    }

//    public getSequence ()

}