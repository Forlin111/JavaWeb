package pojo;

public class student {
    private int id;
    private String name;
    private int age;
    private String number;

    public student(int id, String name, int age, String number) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.number = number;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", number='" + number + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNumber() {
        return number;
    }
}

