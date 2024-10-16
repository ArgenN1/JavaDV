import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BC1332 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            System.out.println(identifyNumber(word));
        }

        scanner.close();
    }

    private static int identifyNumber(String word) {
        Map<String, Integer> correctWords = new HashMap<>();
        correctWords.put("one", 1);
        correctWords.put("two", 2);
        correctWords.put("three", 3);

        for (Map.Entry<String, Integer> entry : correctWords.entrySet()) {
            if (isSimilar(word, entry.getKey())) {
                return entry.getValue();
            }
        }

        return -1;
    }

    private static boolean isSimilar(String word, String correctWord) {
        int differences = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != correctWord.charAt(i)) {
                differences++;
                if (differences > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
