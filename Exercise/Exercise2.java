public class Exercise2 {
    public static void displayArray(int[] array) {
        for (int num : array) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {6, 69, 9};
        displayArray(numbers);
    }
}