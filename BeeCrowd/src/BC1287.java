import java.util.Scanner;

public class BC1287 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println(parseFriendlyInteger(input));
        }

        scanner.close();
    }

    private static String parseFriendlyInteger(String input) {
        StringBuilder numberBuilder = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c == 'O' || c == 'o') {
                numberBuilder.append('0');
            } else if (c == 'l') {
                numberBuilder.append('1');
            } else if (Character.isDigit(c)) {
                numberBuilder.append(c);
            }
            // Ignore spaces and commas
        }

        String numberStr = numberBuilder.toString();

        if (numberStr.isEmpty() || (numberStr.length() > 1 && numberStr.charAt(0) == '0')) {
            return "error";
        }

        try {
            long number = Long.parseLong(numberStr);
            if (number < 0 || number > 2147483647) {
                return "error";
            }
            return String.valueOf(number);
        } catch (NumberFormatException e) {
            return "error";
        }
    }
}
