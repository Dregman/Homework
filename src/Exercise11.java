import java.sql.Array;
import java.sql.SQLOutput;

public class Exercise11 {
    public static void main(String[] args) {
        myArray();
    }

    public static void myArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }



    }
}
