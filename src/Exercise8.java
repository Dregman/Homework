import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        step ();
    }
    public static void step () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Напишите строчку");
        String str = scanner.nextLine();
        System.out.println("Сколько раз её дублировать?");
        int a = scanner.nextInt();
for (int i = 0; i < a; i++) {
    System.out.println(str);
}

    }
}
