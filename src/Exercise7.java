import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        System.out.println(isNegative(-5));
        System.out.println(isNegative(0));
        System.out.println(isNegative(3));
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }
}