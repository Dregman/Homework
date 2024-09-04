import java.util.Arrays;

public class Exercise10 {
    public static void main(String[] args) {
        isArray();
    }

    public static void isArray () {
        int [] originalArray = new int[] {1, 1, 1, 0, 1, 0, 0, 0, 1, 0};
        int [] modifiedArray = new int[originalArray.length];
      for (int i = 0; i < originalArray.length; i++) {
          if (originalArray[i] == 0) {
              modifiedArray[i] = 1;
          } else if (originalArray[i] ==1) {
              modifiedArray[i] = 0;
          }
          System.out.println(Arrays.toString(modifiedArray));
        }

    }
}
