import java.util.Scanner;

public class Exercise5 {

    public static void main(String[] args) {
        summ();
    }
    public static void summ () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число");
        int a = scanner.nextInt();
        System.out.println("Введите второе число");
        int b = scanner.nextInt();
        int summ = a + b;
        if (summ >= 10 && summ <= 20) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}