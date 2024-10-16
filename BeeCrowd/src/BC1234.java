import java.util.Scanner;

public class BC1234 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(convertToDancingSentence(line));
        }

        scanner.close();
    }

    private static String convertToDancingSentence(String line) {
        StringBuilder result = new StringBuilder();
        boolean isUpperCase = true;

        for (char c : line.toCharArray()) {
            if (Character.isLetter(c)) {
                if (isUpperCase) {
                    result.append(Character.toUpperCase(c));
                } else {
                    result.append(Character.toLowerCase(c));
                }
                isUpperCase = !isUpperCase;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
