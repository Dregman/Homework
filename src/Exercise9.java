import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        leapYear ();
    }
    public static void leapYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год");
        int year = scanner.nextInt();
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println("Год високосный: " + isLeap);
    }

}
