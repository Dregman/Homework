import java.util.*;

public class TelephonDirectory {
    private Map<String, List<String>> phoneBook;

    public TelephonDirectory() {

        phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        phoneBook.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String lastName)
    {
        return phoneBook.getOrDefault(lastName, Collections.emptyList());
    }

    public static void main(String[] args) {
        TelephonDirectory TelephonDirectory = new TelephonDirectory();

        // Добавляем записи
        TelephonDirectory.add("Захаренко", "+375 (29) 674-20-23");
        TelephonDirectory.add("Миронов", "+375 (44) 850-30-11");
        TelephonDirectory.add("Мазай", "+375 (44) 910-23-68");
        TelephonDirectory.add("Ефремов", "+375 (29) 192-22-18");

        // Ищем номера по фамилии
        System.out.println("Номера для фамилии Захаренко: " + TelephonDirectory.get("Захаренко"));
        System.out.println("Номера для фамилии Миронов: " + TelephonDirectory.get("Миронов"));
        System.out.println("Номера для фамилии Мазай: " + TelephonDirectory.get("Мазай"));
        System.out.println("Номера для фамилии Ефремов: " + TelephonDirectory.get("Ефремов"));
    }
}