import java.util.ArrayList;
import java.util.List;

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }
}

class Product {
    private int id;
    private String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "'}";
    }
}

class Repository<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T getById(int id) {
        return items.get(id);
    }

    public List<T> getAll() {
        return items;
    }
}

public class problem10 {
    public static void main(String[] args) {
        Repository<User> userRepo = new Repository<>();
        userRepo.add(new User(1, "Alice"));
        System.out.println(userRepo.getById(0));

        Repository<Product> productRepo = new Repository<>();
        productRepo.add(new Product(1, "Laptop"));
        System.out.println(productRepo.getById(0));
    }
}