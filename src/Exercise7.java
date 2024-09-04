import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        number ();
    }
    public static void number () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int a = scanner.nextInt();
        if (a >= 0) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }
}
