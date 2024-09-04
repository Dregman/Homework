import java.util.Arrays;

public class Exercise12 {
    public static void main(String[] args) {
        Array();
    }

    public static void Array() {
        int[] myArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] < 6) {
                myArray[i] *= 2;
                System.out.println(Arrays.toString(myArray) + " ");
            }
        }


    }
}