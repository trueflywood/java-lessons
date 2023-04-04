import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,-5,-8,-15,-15,3,4,4,3,5,3,4,7,8,7,9,3,5,67,45,78,23};
        int[] arr2 = new int[]{-5,-15,-15,3,3,5,3,7,7,9,3,5,67,45,23};
        System.out.println("исходный массив");
        System.out.println(Arrays.toString(arr));
        System.out.println("1) Удалить в массиве все числа, которые повторяются более двух раз.");

        System.out.println(Arrays.toString(clearDouble(arr)));
        System.out.println("2)Найдите наибольший нечетный элемент.");
        System.out.println("Max odd: " + maxOdd(arr) );
        System.out.println("3)Найдите индекс наибольшего элемент.");
        System.out.println("Max index: " + maxIndex(arr) );
        System.out.println("4)Найдите сумму отрицательных элементов массива.");
        System.out.println("Max index: " + subZeroSumm(arr) );
        System.out.println("5)Найдите наименьший четный элемент массива. Если такого нет, то выведите первый элемент.");
        System.out.println("Min even: " + minEven(arr) );
        System.out.println("Min even: " + minEven(arr2) );
        System.out.println("6)Прописать метод который сортирует массив");
        System.out.println("sort: " + Arrays.toString(sort(arr)) );
        System.out.println("7)Выводит все элементы массива через 1.");
        System.out.println("evenElement: " + Arrays.toString(evenElement(arr)) );
        System.out.println("8)Выводит все элементы массива пока не встретится элемент -1");
//        System.out.println("sort: " + Arrays.toString(sort(arr)) );
        System.out.println("9)Заменить элeменты в массиве отрицательные на положительные и наоборот пример 1 => --1");
//        System.out.println("sort: " + Arrays.toString(sort(arr)) );
        System.out.println("10)Найти количество:\n" +
                "а) четных\n" +
                "б) нечетных\n" +
                "в) положительных\n" +
                "г) отрицательных\n" +
                "д) двухзначных\n" +
                "е) однозначных");
//        System.out.println("sort: " + Arrays.toString(sort(arr)) );

    }

//    public static int[] subArray(int[] arr) {
//        int[] newArr
//    }

    public static int[] evenElement(int[] arr) {
        int lenght = arr.length % 2 == 0 ? arr.length / 2 : arr.length / 2 + 1;
        int[] newArr = new int[lenght];
        int newArrIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i % 2 == 1) newArr[newArrIndex++] = arr[i];
        }
        return newArr;
    }

    public static int[] sort(int[] arr) {

        int[] newArr = Arrays.copyOf(arr, arr.length);
        int tmp = 0;
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr.length-1; j++) {
                if (newArr[j] > newArr [j+1]) {
                    tmp = newArr[j+1];
                    newArr[j+1] = newArr[j];
                    newArr[j] = tmp;
                }
            }
        }
        return  newArr;
    }

    public static  int minEven(int[] arr) {

        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                min = arr[i];
                break;
            }
            if(i == arr.length -1) {
                return arr[0];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i] && arr[i] % 2 == 0  ) min = arr[i];
        }
        return min;
    }

    public static int subZeroSumm(int[] arr) {
        int summ = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) summ += arr[i];
        }
        return summ;
    }

    public static int maxIndex(int[] arr) {
        int maxIndex = 0;
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    public static  int maxOdd(int[] arr) {

        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if(max == 0) {
                if (arr[i] % 2 == 1) max = arr[i];
            } else {
                if (max < arr[i] && arr[i] % 2 == 1  ) max = arr[i];
            }
        }
        return max;
    }

    public static int[] clearDouble(int[] arr) {

        int[] newArr =new int[arr.length];

        int newArrIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length ; j++) {
                if(arr[i] == arr[j] && i != j) break;
                if (j == arr.length-1) newArr[newArrIndex++]=arr[i];
            }
        }



        int[] newArr2 =new int[newArrIndex];
        for (int i = 0; i < newArrIndex; i++) {
            newArr2[i] = newArr[i];
        }
        return newArr2;
    }

}
