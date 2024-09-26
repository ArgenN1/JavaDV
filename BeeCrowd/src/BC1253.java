import java.util.Scanner;

public class BC1253 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            String encodedString = scanner.nextLine();
            int shift = scanner.nextInt();
            scanner.nextLine();

            StringBuilder decodedString = new StringBuilder();
            for (char ch : encodedString.toCharArray()) {
                char decodedChar = (char) ((ch - 'A' - shift + 26) % 26 + 'A');
                decodedString.append(decodedChar);
            }

            System.out.println(decodedString.toString());
        }

        scanner.close();
    }
}
