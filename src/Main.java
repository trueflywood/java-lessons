class MyString {
    char[] arr;

    {
        arr = new char[]{};
    }

    MyString() {

    }

    MyString(char[] arr) {
        this.arr = arr;
    }

    MyString(String str) {
        this.arr = str.toCharArray();
    }


    // return -1 not
    // return index yes
    int indexOf(char sym) {
        for (int i = 0; i < arr.length; i++) {
            if (sym == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    int lastIndexOf(char sym) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (sym == arr[i]) {
                return i;
            }
        }
        return -1;
    }


    // ?
    int indexOf(String word) {
        char[] newArr = word.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (newArr[0] == arr[i]) {
                for (int j = 0; j < newArr.length; j++) {
                    if (i+j <arr.length && newArr[j] == arr[i + j]) {
                        if ( j == newArr.length - 1){
                            return i;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return -1;
    }


    public int length() {
        return arr.length;
    }


    char[] toCharArray(){
        return arr;
    }

    String trim(){
        // "          Farid          ";
        int start ,end;
        start = end = 0;


//    farid 1000
        for (int i = 0 , j=arr.length-1; i < arr.length; i++ , j--) {
            if (arr[i]!=' ' && start==0){
                start = i;
            }

            if (arr[j]!=' ' && end==0){
                end = j;
            }

            if (end!=0 && start!=0){
                break;
            }
        }


        String str ="";
        for (int i = start; i <= end; i++) {
            str+=arr[i];
        }

        return str;



    }


    boolean startsWith(String str){


        if (str.length()>arr.length){
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (arr[i]!=str.charAt(i)){
                return false;
            }
        }
        return true;
    }




    String replace(char oldChar, char newChar) {
        char[] newArr = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i] == oldChar ? newChar : arr[i];
        }
        return new String(newArr);
    }





    String reverse() {
        char[] newArr = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[arr.length - 1 - i];
        }
        return new String(newArr);
    }

    //str.trimL()
    String trimL() {
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=' ' && start==0){
                start = i;
                break;
            }
        }
        String str ="";
        for (int i = start; i < arr.length; i++) {
            str+=arr[i];
        }
        return str;
    }

    //str.trimR()
    String trimR() {
        int end = 0;
        for (int i = this.arr.length-1 ; i >= 0; i--) {
            if (arr[i]!=' ' && end==0){
                end = i;
                break;
            }
        }
        String str ="";
        for (int i = 0; i <= end; i++) {
            str+=arr[i];
        }
        return str;
    }


    boolean endsWith(String str) {
        if (str.length()>arr.length){
            return false;
        }

        for (int i = (arr.length - str.length()); i < arr.length; i++) {
            if (arr[i] != str.charAt(i + str.length() - arr.length)){
                return false;
            }
        }
        return true;
    }
    char charAt(int index) {
        if (index > arr.length - 1 || index < 0) return 0;
        return arr[index];
    }

    boolean contains(String str) {
        if (str.length()>arr.length){
            return false;
        }


        for (int i = 0; i <= arr.length - str.length(); i++) {
            if (arr[i] == str.charAt(0)) {
                int start = i;
                int end = start + str.length();
                for (int j = start; j < end; j++) {
                    int index = j - start;
                    if (str.charAt(index) == arr[j]) {
                        if (j == (end - 1)) return true;
                    } else {
                        break;
                    }
                }
            }
        }
        return false;
    }

    boolean equals(String str) {
        return str.length() == arr.length && this.contains(str);
    }

}


public class Main {
    public static void main(String[] args) {
        MyString myString = new MyString("  s Farid   f        ");
        String str = new String("  s Farid   f        ");



        System.out.println("replace(' ', '_') : |" + myString.replace(' ', '_') + "|");
        System.out.println("reverse : |" + myString.reverse() + "|");
        System.out.println("trimL : |" + myString.trimL() +"|");
        System.out.println("trimR : |" + myString.trimR() + "|");
        System.out.println("startsWith(\"  s\") : " + myString.startsWith("  s"));
        System.out.println("endsWith(\"id   f        \") : " + myString.endsWith("id   f        "));
        System.out.println("charAt(4) : " + myString.charAt(4));
        System.out.println("contains(\" Farid\") : " + myString.contains(" Farid"));
        System.out.println("equals(\"  s Farid   f        \") : " + myString.equals("  s Farid   f        "));
    }
}