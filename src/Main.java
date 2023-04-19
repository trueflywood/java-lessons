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

        try {
            arr.removeByIndex(3);
        } catch (ArrayException e) {
            System.out.println(e.getMessage());
        }

        arr.print();
        System.out.println("новый размер массива = " + arr.lenght());
        System.out.println();
        System.out.println("Добавляем значения по индексу");
        System.out.println("значение 5 по индексу 3 ");
        try {
            arr.insertByIndex(3,5);
        } catch (ArrayException e) {
            System.out.println(e.getMessage());
        }
        arr.print();
        System.out.println("новый размер массива = " + arr.lenght());
        System.out.println();
        System.out.println("значение 56 по индексу 7 ");
        try {
            arr.insertByIndex(7,56);
        } catch (ArrayException e) {
            System.out.println(e.getMessage());
        }
        arr.print();
        System.out.println("новый размер массива = " + arr.lenght());
        System.out.println();
        System.out.println("значение 22 по индексу 9 ");
        try {
            arr.insertByIndex(9,22);
        } catch (ArrayException e) {
            System.out.println(e.getMessage());
        }
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
        size = 10;
        index = 0;
        arr = new int[10];
    }
    MyArray() {}


    public int lenght() {
        return this.index;
    }
    public void add(int num) {
        if (this.index == this.size) {
            this.resizeArray();
        }
        this.arr[index++] = num;
    }
    public  void print(){
        System.out.print('[');

        for (int i = 0; i < this.lenght(); i++) {
            System.out.print(this.arr[i]);
            if (i != this.lenght()-1) System.out.print(",");
        }
        System.out.print(']');
    }

    private void resizeArray() {
        int[] newArr = new int[this.size * 2];
        for (int i = 0; i < this.size; i++) {
            newArr[i] = this.arr[i];
        }
        this.size *= 2;
        this.arr = newArr;
    }

    public void removeByIndex(int index) throws ArrayException {
        if (index < this.index && index >= 0) {
            int[] newArr = new int[this.size];
            for (int i = 0; i < this.index; i++) {
                if (index > i) {
                    newArr[i] = arr[i];
                } else if (index < i) {
                    newArr[i-1] = arr[i];
                }
            }
            this.index = this.index- 1;
            this.arr = newArr;
        } else {
            throw new ArrayException("индекс не попадает в диапазон");
        }

    }

    public void insertByIndex(int index, int value) throws ArrayException {
        if (this.index == this.size) {
            this.resizeArray();
        }
        if (index < this.index && index >= 0) {

            int[] newArr = new int[this.size];
            newArr[index] = value;
            for (int i = 0; i < this.index; i++) {
                if (index > i) {
                    newArr[i] = arr[i];
                } else if (index <= i) {
                    newArr[i+1] = arr[i];
                }
            }
            this.index++;
            this.arr = newArr;
        } else {
          throw new ArrayException("индекс не попадает в диапазон");
        }
        // TODO

    }
}

class ArrayException extends Exception {

    private String message = "";

    public ArrayException() {
        super();
    }

    public ArrayException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return "Custom ArrayException: " + message;
    }
}