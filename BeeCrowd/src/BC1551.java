import java.util.HashSet;
import java.util.Scanner;

public class BC1551 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            String sentence = scanner.nextLine();
            System.out.println(categorizeSentence(sentence));
        }

        scanner.close();
    }

    private static String categorizeSentence(String sentence) {
        HashSet<Character> letters = new HashSet<>();

        for (char c : sentence.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                letters.add(c);
            }
        }

        int uniqueLetterCount = letters.size();
        int alphabetSize = 26;

        if (uniqueLetterCount == alphabetSize) {
            return "frase completa";
        } else if (uniqueLetterCount >= alphabetSize / 2) {
            return "frase quase completa";
        } else {
            return "frase mal elaborada";
        }
    }
}
