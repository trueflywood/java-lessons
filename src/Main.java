import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        arr.add(7);
        arr.add(6);
        arr.add(8);

        ArrayList<ArrayList<Integer>> summArray = new ArrayList<>();


        // вычисляем количество возможных перестановок
        int colMutation = 1;
        for (int i = 0; i < arr.size(); i++) {
            colMutation *= (i+1);
        }

        // генеррируем все возможные варианты.
        int allVariants = (int) Math.pow(arr.size(), arr.size());

        for (int i = 0; i < allVariants; i++) { // значение

            // преобразуем числов систему с основание равному размеру и длополним 0
            ArrayList<Integer> arrNumPosition = new ArrayList<Integer>();
            int val = i;
            for (int j = 0; j < arr.size(); j++) {
                arrNumPosition.add(val % arr.size());
                val = (val - (val % arr.size())) / arr.size();
            }
            // System.out.println(arrNumPosition);
            // проверка на повторения

            boolean unique = true;
            for (int k = 0; k < arrNumPosition.size()-1; k++) {
                for (int l = k+1; l < arrNumPosition.size(); l++) {
                    if (arrNumPosition.get(k) == arrNumPosition.get(l)) {
                        unique = false;
                        break;
                    }
                }
                if (!unique) break;
            }

            if (unique) {
                // System.out.println(arrNumPosition);
                // преобразование позиций в числа
                ArrayList<Integer> arrNumResult = new ArrayList<Integer>();
                for (int pos :
                        arrNumPosition) {
                    arrNumResult.add(arr.get(pos));

                }
                summArray.add(arrNumResult);
//                System.out.println(arrNumResult);
//                System.out.println();
            }
        }
        System.out.println("количество перестановок (по формуле) = "+colMutation);
        System.out.println("количество перестановок в массиве = "+summArray.size());
        System.out.println(summArray);
    }
}