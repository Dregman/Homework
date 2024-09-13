import java.util.*;


public class Main {
    public static void main(String[] args) {
        String[] words = {
                "молоко", "гора", "время", "дворец", "самолет",
                "комар", "сигарета", "гора", "дворец", "молоко",
                "молоко", "самолет", "время", "гора",
        };

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        System.out.println("Уникальные слова:");
        for (String uniqueWord : uniqueWords) {
            System.out.println(uniqueWord);
        }

        System.out.println("\nЧастота слов:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}