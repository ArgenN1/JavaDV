import java.util.List;
import java.util.Arrays;

class Problem4 {
    public static void printList(List<?> list) {
        for (Object element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        printList(intList);

        List<String> strList = Arrays.asList("A", "B", "C");
        printList(strList);
    }
}