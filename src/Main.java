import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr01 = new int[]{-5,-1,0,3,6,7,8,11,11,12,19};
        int[] arr02 = new int[]{-4,1,2,15,16,19,20};



        int[] result = concatSort(arr01, arr02);
        System.out.println(Arrays.toString(result));
        // поменяем массивы местами
        int[] result2 = concatSort(arr02, arr01);
        System.out.println(Arrays.toString(result2));
    }
    public static int[] concatSort(int[] arr1, int[] arr2) {
        // проверка пограничных значений
        if (arr1.length == 0) {
            return arr2;
        }

        if (arr2.length == 0) {
            return  arr1;
        }

        int[] result = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;
        int resultIndex = 0;

        do {
            // проверка на окончание одного из маммивов
            if(index1 >= arr1.length) {
                result[resultIndex++] = arr2[index2];
                index2++;
                continue;
            }
            if(index2 >= arr2.length) {
                result[resultIndex++] = arr1[index1];
                index1++;
                continue;
            }

            // проверка промежуточных состояний
            if(arr1[index1] <= arr2[index2] ) {
                result[resultIndex++] = arr1[index1];
                index1++;
            } else {
                result[resultIndex++] = arr2[index2];
                index2++;
            }

        } while(resultIndex < result.length );

        return result;
    }
}