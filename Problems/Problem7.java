interface Pair<K, V> {
    K getKey();
    V getValue();
}

class Problem7 implements Pair<String, Integer> {
    private String key;
    private Integer value;

    public Problem7(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Problem7("Age", 25);
        System.out.println(pair.getKey() + ": " + pair.getValue());
    }
}