import java.util.Arrays;

public class Exercise13 {
    public static void main(String[] args) {
        arr();
    }

    public static void arr() {
        int array[][] = new int[3][3];
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print (array[i][j] + " ");

            }
            System.out.println ();


        }
    }
}
