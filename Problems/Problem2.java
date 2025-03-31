class Problem2 {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        printArray(intArray);

        String[] strArray = {"A", "B", "C"};
        printArray(strArray);
    }
}