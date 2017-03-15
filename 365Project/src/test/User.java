package test;

public class User {
    String username, name;
    double weight, age;

    public User() {}

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public User setAge(double age) {
        this.age = age;
        return this;
    }
}
