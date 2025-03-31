public class problem1<T> {
    private T value;

    public problem1(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        problem1<Integer> intBox = new problem1<>(123);
        System.out.println(intBox.getValue());

        problem1<String> strBox = new problem1<>("Hello");
        System.out.println(strBox.getValue());
    }
}