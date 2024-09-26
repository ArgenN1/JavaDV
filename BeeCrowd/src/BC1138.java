import java.util.Scanner;

public class BC1138 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            if (A == 0 && B == 0) break;

            int[] digitCount = new int[10];
            for (int i = A; i <= B; i++) {
                for (char digit : Integer.toString(i).toCharArray()) {
                    digitCount[digit - '0']++;
                }
            }

            for (int count : digitCount) {
                System.out.print(count + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
