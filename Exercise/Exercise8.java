public class Exercise8 {
    public static String repeatString(String input, int count) {
        String repeated = "";
        for (int i = 0; i < count; i++) {
            repeated += input;
        }
        return repeated;
    }

    public static void main(String[] args) {
        System.out.println(repeatString("вв", 3));
    }
}