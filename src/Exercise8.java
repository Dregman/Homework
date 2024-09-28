public class Exercise8 {
    public static void main(String[] args) {
        printString("Hello, World!", 5);
    }

    public static void printString(String str, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }
}
