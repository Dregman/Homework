import java.util.Arrays;

public class Exercise14 {
    public static void main(String[] args) {
        arr();
    }

    public static void arr () {
        int len = 5;
        int initialValue = 42;

        int[] resultArray = new int[len];
        for (int i = 0; i < len; i++) {
            resultArray[i] = initialValue;
        }
        System.out.println(Arrays.toString(resultArray) + " ");
    }
}

