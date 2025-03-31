class Problem9<T extends Problem9<T>> {
    public T self() {
        return (T) this;
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

class PersonBuilder extends Problem9<PersonBuilder> {
    private String name;
    private int age;

    public PersonBuilder setName(String name) {
        this.name = name;
        return self();
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return self();
    }

    public Person build() {
        return new Person(name, age);
    }
}

class M {
    public static void main(String[] args) {
        Person person = new PersonBuilder()
                .setName("Alice")
                .setAge(30)
                .build();
        System.out.println(person);
    }
}