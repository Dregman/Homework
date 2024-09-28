public class Exercise9 {

    public static void main(String[] args) {
        int year = 2024;
        boolean isLeapYear = isLeap(year);
        System.out.println(year + " является високосным: " + isLeapYear);
    }

    public static boolean isLeap(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }
}