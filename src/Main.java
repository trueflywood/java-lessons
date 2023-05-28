import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        MyNumber arabicNum = new MyNumber();
        System.out.println("введите число от 1 до 4999" );
        Scanner scanner = new Scanner(System.in);
        try {
            Integer select = scanner.nextInt();
            arabicNum.setNumber(select);
            System.out.println("число в римской системе будет: " + arabicNum.toRoman());

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }

}

class MyNumber {
    private Integer myNum = null;

    MyNumber() {

    }
    MyNumber(Integer num) {
        this.myNum = num;
    }

    @Override
    public String toString() {
        return this.myNum.toString();
    }

    public void setNumber(Integer num) {
        this.myNum = num;
    }

    public Integer getNumber() {
        return this.myNum;
    }

    public String toRoman() throws Exception {
        TreeMap<Integer, String> initMap = new TreeMap<>();
        initMap.put(1000, "M");
        initMap.put(900, "CM");
        initMap.put(500, "D");
        initMap.put(400, "CD");
        initMap.put(100, "C");
        initMap.put(90, "XC");
        initMap.put(50, "L");
        initMap.put(40, "XL");
        initMap.put(10, "X");
        initMap.put(9, "IX");
        initMap.put(5, "V");
        initMap.put(4, "IV");
        initMap.put(1, "I");

        Integer tmpNum = this.getNumber();
        StringBuilder romanNumberString = new StringBuilder();


        if(tmpNum > 4999 || tmpNum < 1) {
            throw new Exception("Для преобразования число должно быть от 1 до 4999");
        }
        for (int num: initMap.keySet().stream().sorted((Integer a, Integer b )-> b - a).toList()) {
            while (tmpNum >= num) {
                tmpNum -= num;
                romanNumberString.append(initMap.get(num));
            }
        }
        return romanNumberString.toString();
    }
}