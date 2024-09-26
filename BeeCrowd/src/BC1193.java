import java.util.Scanner;

public class BC1193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= N; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String numberStr = parts[0];
            String format = parts[1];

            int decimalValue = 0;

            if (format.equals("dec")) {
                decimalValue = Integer.parseInt(numberStr);
            } else if (format.equals("bin")) {
                decimalValue = Integer.parseInt(numberStr, 2);
            } else if (format.equals("hex")) {
                decimalValue = Integer.parseInt(numberStr, 16);
            }

            String decimalOutput = decimalValue + " dec";
            String hexOutput = Integer.toHexString(decimalValue) + " hex";
            String binaryOutput = Integer.toBinaryString(decimalValue) + " bin";

            System.out.println("Case " + i + ":");
            if (!format.equals("dec")) {
                System.out.println(decimalOutput);
            }
            if (!format.equals("hex")) {
                System.out.println(hexOutput);
            }
            if (!format.equals("bin")) {
                System.out.println(binaryOutput);
            }
            System.out.println();
        }

        scanner.close();
    }
}