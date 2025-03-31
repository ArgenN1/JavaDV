import java.util.List;
import java.util.Arrays;

class Problem5 {
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        System.out.println(sumOfList(intList));

        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);
        System.out.println(sumOfList(doubleList));
    }
}