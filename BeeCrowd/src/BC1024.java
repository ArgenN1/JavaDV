import java.util.Scanner;

public class BC1024 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            String encryptedLine = encryptLine(line);
            System.out.println(encryptedLine);
        }

        scanner.close();
    }

    private static String encryptLine(String line) {
        StringBuilder shifted = new StringBuilder();

        for (char c : line.toCharArray()) {
            if (Character.isLetter(c)) {
                shifted.append((char) (c + 3));
            } else {
                shifted.append(c);
            }
        }

        String reversed = shifted.reverse().toString();
        int midIndex = reversed.length() / 2;
        StringBuilder finalLine = new StringBuilder();

        finalLine.append(reversed, 0, midIndex);

        for (int j = midIndex; j < reversed.length(); j++) {
            finalLine.append((char) (reversed.charAt(j) - 1));
        }

        return finalLine.toString();
    }
}
