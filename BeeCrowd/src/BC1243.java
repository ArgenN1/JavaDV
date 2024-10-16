import java.util.Scanner;

public class BC1243 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String statement = scanner.nextLine();
            System.out.println(classifyDifficulty(statement));
        }

        scanner.close();
    }

    private static int classifyDifficulty(String statement) {
        String[] words = statement.split("\\s+");
        int totalLength = 0;
        int wordCount = 0;

        for (String word : words) {
            word = word.trim();
            if (isValidWord(word)) {
                totalLength += word.length() - 1;
                wordCount++;
            }
        }

        if (wordCount == 0) {
            return 0;
        }

        int averageLength = totalLength / wordCount;

        if (averageLength <= 3) {
            return 250;
        } else if (averageLength <= 5) {
            return 500;
        } else {
            return 1000;
        }
    }

    private static boolean isValidWord(String word) {
        return word.length() > 1 && word.matches("^[a-zA-Z]+\\.$");
    }
}
