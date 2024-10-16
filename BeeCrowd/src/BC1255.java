import java.util.*;

public class BC1255 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            System.out.println(findMostFrequentLetters(line));
        }

        scanner.close();
    }

    private static String findMostFrequentLetters(String line) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : line.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
        }

        int maxFrequency = Collections.max(frequencyMap.values());
        List<Character> mostFrequentLetters = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                mostFrequentLetters.add(entry.getKey());
            }
        }

        Collections.sort(mostFrequentLetters);

        StringBuilder result = new StringBuilder();
        for (char letter : mostFrequentLetters) {
            result.append(letter);
        }

        return result.toString();
    }
}
