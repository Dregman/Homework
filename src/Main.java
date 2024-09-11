public class Main {
    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "Денис"}
        };

        try {
            int sum = createReport(validArray);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int createReport(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int rows = 4;
        int cols = 4;

        if (array.length != rows || array[0].length != cols) {
            throw new MyArraySizeException("Неверный размер массива");
        }

        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                try {
                    sum = sum + Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]");
                }
            }
        }

        return sum;
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super("Размер массива должен быть 4x4");
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super("Размер массива должен быть 4x4");
    }
}
