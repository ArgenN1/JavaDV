import java.util.Scanner;

public class BC1120 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0 0")) {
                break;
            }

            String[] parts = input.split(" ");
            char failedDigit = parts[0].charAt(0);
            String originalNumber = parts[1];

            String representedNumber = originalNumber.replace(Character.toString(failedDigit), "");

            if (representedNumber.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(new java.math.BigInteger(representedNumber).toString());
            }
        }

        scanner.close();
    }
}
