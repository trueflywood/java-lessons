public class MaxLengthFields {
    static Integer maxID = 2;
    static Integer maxName = 3;
    static Integer maxSurname = 7;
    static Integer maxNumber = 7;
    static Integer maxAge = 7;



    static public void reset() {
        MaxLengthFields.maxID = 2;
        MaxLengthFields.maxName = 3;
        MaxLengthFields.maxSurname = 7;
        MaxLengthFields.maxNumber = 7;
        MaxLengthFields.maxAge = 7;
    }


    static String toMyString() {
        return  "\n MaxLengthFields.maxID =" + MaxLengthFields.maxID +
                "\n MaxLengthFields.maxName =" + MaxLengthFields.maxName +
                "\n MaxLengthFields.maxSurname =" + MaxLengthFields.maxSurname +
                "\n MaxLengthFields.maxNumber =" + MaxLengthFields.maxNumber +
                "\n MaxLengthFields.maxAge =" + MaxLengthFields.maxAge + "\n";
                  

    }
}
