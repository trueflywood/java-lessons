public class Main {
    public static void main(String[] args) {
        System.out.println("Создаем свой массив");
        MyArray arr = new MyArray();
        System.out.println("Заполняем значениями");

        arr.add(2);
        arr.add(4);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(1);
        arr.add(5);
        arr.add(5);
        arr.add(5);
        arr.add(5);
        arr.print();
        System.out.println();
        System.out.println("Удаляем элемент с 3 индексом");
        arr.remove(3);
        arr.print();
        System.out.println("новый размер массива = " + arr.lenght());
        System.out.println();
        System.out.println("Добавляем значения по индексу");
        System.out.println("значение 5 по индексу 3 ");
        arr.add(3,5);
        arr.print();
        System.out.println("новый размер массива = " + arr.lenght());
        System.out.println();
        System.out.println("значение 56 по индексу 7 ");
        arr.add(7,56);
        arr.print();
        System.out.println("новый размер массива = " + arr.lenght());
        System.out.println();
        System.out.println("значение 22 по индексу 9 ");
        arr.add(9,22);
        arr.print();
        System.out.println("новый размер массива = " + arr.lenght());
        System.out.println();
        System.out.println("добавляем значение 33 в начало");
        arr.addStart(33);
        arr.print();
        System.out.println("новый размер массива = " + arr.lenght());
    }
}

class MyArray {
    /**
     * размер массива
     */
    int size;

    /**
     * количество заполненных элементов
     */
    int index;
    int[] arr;

    {
        size = 3;
        index = 0;
        arr = new int[this.size];
    }
    MyArray() {}


    public int lenght() {
        return this.index;
    }
    public void add(int num) {
        if (this.index == this.size) {
            this.regeneration();
        }
        this.arr[index++] = num;
    }
    public  void print(){
        System.out.print('[');

//        for (int i = 0; i < this.lenght(); i++) {
//            System.out.print(this.arr[i]);
//            if (i != this.lenght()-1) System.out.print(",");
//        }
        int i = 0;
        while (i < this.lenght()) {
            System.out.print(this.arr[i]);
            if (i != this.lenght()-1) System.out.print(",");
            i++;
        }
        System.out.print(']');
    }

    private void regeneration() {
        int[] newArr = new int[this.size * 2];

//        for (int i = 0; i < this.size; i++) {
//            newArr[i] = this.arr[i];
//        }
        int i = 0;
        while(i < this.size) {
            newArr[i] = this.arr[i];
            i++;
        }
        this.size *= 2;
        this.arr = newArr;
    }

    public void remove(int index) {
        if (index < this.index && index >= 0) {
            int[] newArr = new int[this.size];

//            for (int i = 0; i < this.index; i++) {
//                if (index > i) {
//                    newArr[i] = arr[i];
//                } else if (index < i) {
//                    newArr[i-1] = arr[i];
//                }
//            }

            int i = 0;
            while (i < this.index) {
                if (index > i) {
                    newArr[i] = arr[i];
                } else if (index < i) {
                    newArr[i-1] = arr[i];
                }
                i++;
            }
            this.index = this.index - 1;
            this.arr = newArr;
        }
    }

    public void add(int index, int value) {
        if (this.index == this.size) {
            this.regeneration();
        }
        if (index < this.index && index >= 0) {

            int[] newArr = new int[this.size];
            newArr[index] = value;

//            for (int i = 0; i < this.index; i++) {
//                if (index > i) {
//                    newArr[i] = arr[i];
//                } else if (index <= i) {
//                    newArr[i+1] = arr[i];
//                }
//            }

            int i = 0;
            while (i < this.index) {
                if (index > i) {
                    newArr[i] = arr[i];
                } else if (index <= i) {
                    newArr[i+1] = arr[i];
                }
                i++;
            }

            this.index++;
            this.arr = newArr;
        }
    }

    public void addStart(int value) {
        this.add(0, value);
    }
}