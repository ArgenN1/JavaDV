import java.util.List;
import java.util.ArrayList;

class Problem6 {
    public static void addNumbers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    public static void main(String[] args) {
        List<Number> numList = new ArrayList<>();
        addNumbers(numList);
        System.out.println(numList);

        List<Object> objList = new ArrayList<>();
        addNumbers(objList);
        System.out.println(objList);
    }
}