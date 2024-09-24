import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            double X = scanner.nextDouble();

            int days = 0;
            while (X > 1) {
                X /= 2;
                days++;
            }

            System.out.println(days + " dias");
        }

        scanner.close();
    }
}


